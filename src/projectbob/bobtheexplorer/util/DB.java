package projectbob.bobtheexplorer.util;

import java.sql.*;
import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

import projectbob.bobtheexplorer.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Database class for accessing user info and scores.
 */
public class DB {
    // SQL Command
    private static final String SQL_CREATE_TABLE_HIGHSCORES =
            "CREATE TABLE IF NOT EXISTS HighScores ( " +
            "PlayerName VARCHAR(255) PRIMARY KEY NOT NULL," +
            "Password VARCHAR(32) NOT NULL," +
            "Score INT NOT NULL )";
    private static final String SQL_INSERT_INTO_HIGHSCORES =
            "INSERT INTO HighScores (PlayerName, Password, Score) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_HIGHSCORES =
            "UPDATE HighScores SET Score = ? WHERE PlayerName = ?";
    private static final String SQL_DELETE_FROM_HIGHSCORES =
            "DELETE FROM HighScores WHERE PlayerName = ?";
    private static final String SQL_SELECT_ALL_FROM_HIGHSCORES =
            "SELECT * FROM HighScores WHERE PlayerName = ?";
    private static final String SQL_SELECT_ALL_FROM_HIGHSCORES_ORDERED =
            "SELECT * FROM HighScores ORDER BY Score DESC";
    
    private Connection conn;
    private String checksum;
    private Properties props;
    
    /**
     * Initializes database.
     * @param checksum MD5 checksum obtained from preferences
     * @throws java.lang.IllegalStateException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public DB(String checksum, Properties props) throws IllegalStateException,
            SQLException, ClassNotFoundException {
        // Loads database
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:data.db");
        
        Statement stmt = this.conn.createStatement();
        
        // Attempts to create new table
        stmt.executeUpdate(SQL_CREATE_TABLE_HIGHSCORES);
        stmt.close();
        
        // Generates MD5 checksum of the database file
        try {
            this.props = props;
            this.checksum = generateChecksum();
        } catch (IOException e) {}
        
        // Checksum verification
        if (!this.checksum.equals(checksum) && checksum != null)
            throw new IllegalStateException("Database file corrupted");
    }
    
    /**
     * Generates the MD5 checksum of the database file.
     * @return MD5 checksum
     */
    private String generateChecksum() throws IOException {
        InputStream is = Files.newInputStream(Paths.get("data.db"));
        final String ret = DigestUtils.md5Hex(is);
        is.close();
        props.setDBChecksum(ret);
        return ret;
    }
    
    /**
     * Gets the MD5 checksum of the database file by the time it was loaded.
     * @return MD5 checksum
     */
    public String getChecksum() {
        return this.checksum;
    }
    
    /**
     * Gets the active connection instance.
     * @return Current connection
     */
    public Connection getConnection() {
        return conn;
    }
    
    /**
     * Closes database connection.
     * @throws java.sql.SQLException
     */
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
    
    /**
     * Adds a score record 
     * @param playerName Player's name
     * @param score Score obtained
     */
    public void addScoreRecord(String playerName, String password, int score)
            throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(SQL_INSERT_INTO_HIGHSCORES);
        stmt.setString(1, playerName);
        stmt.setString(2, DigestUtils.md5Hex(password));
        stmt.setInt(3, score);
        stmt.executeUpdate();
        stmt.close();
        
        // Generates MD5 checksum of the database file
        try {
            this.checksum = generateChecksum();
        } catch (IOException e) {}
    }
    
    /**
     * Updates a score record 
     * @param playerName Player's name
     * @param score Score obtained
     */
    public void updateScoreRecord(String playerName, int score)
            throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(SQL_UPDATE_HIGHSCORES);
        stmt.setInt(1, score);
        stmt.setString(2, playerName);
        stmt.executeUpdate();
        stmt.close();
        
        // Generates MD5 checksum of the database file
        try {
            this.checksum = generateChecksum();
        } catch (IOException e) {}
    }
    
    /**
     * Removes a score record 
     * @param playerName Player's name
     */
    public void removeScoreRecord(String playerName)
            throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(SQL_DELETE_FROM_HIGHSCORES);
        stmt.setString(1, playerName);
        stmt.executeUpdate();
        stmt.close();
        
        // Generates MD5 checksum of the database file
        try {
            this.checksum = generateChecksum();
        } catch (IOException e) {}
    }
    
    /**
     * Searches for a player (credentials)
     * @param playerName Player's name
     * @return Map of player's name to hashed password
     */
    public HashMap<String, String> findPlayer(String playerName)
            throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(SQL_SELECT_ALL_FROM_HIGHSCORES);
        stmt.setString(1, playerName);
        ResultSet rs = stmt.executeQuery();
        
        HashMap<String, String> ret = new HashMap<>();
        
        while (rs.next()) {
            ret.put(rs.getString("PlayerName"), rs.getString("Password"));
        }
        
        rs.close();
        stmt.close();
        
        return ret;
    }
    
    /**
     * Searches for a player (score)
     * @param playerName Player's name
     * @return Map of player's name to score
     */
    public HashMap<String, Integer> findScore(String playerName)
            throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(SQL_SELECT_ALL_FROM_HIGHSCORES);
        stmt.setString(1, playerName);
        ResultSet rs = stmt.executeQuery();
        
        HashMap<String, Integer> ret = new HashMap<>();
        
        while (rs.next()) {
            ret.put(rs.getString("PlayerName"), rs.getInt("Score"));
        }
        
        rs.close();
        stmt.close();
        
        return ret;
    }
    
    /**
     * Searches for all scores
     * @return Map of player's names to scores
     */
    public LinkedHashMap<String, Integer> findScore()
            throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(SQL_SELECT_ALL_FROM_HIGHSCORES_ORDERED);
        ResultSet rs = stmt.executeQuery();
        
        LinkedHashMap<String, Integer> ret = new LinkedHashMap<>();
        
        while (rs.next()) {
            ret.put(rs.getString("PlayerName"), rs.getInt("Score"));
        }
        
        rs.close();
        stmt.close();
        
        return ret;
    }
}
