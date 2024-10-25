package projectbob.bobtheexplorer.util;

import java.sql.*;
import java.io.*;
import java.nio.file.*;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Database class for accessing user info and scores.
 */
public class DB {
    // SQL Command
    public static final String SQL_CREATE_TABLE_HIGHSCORES =
            "CREATE TABLE IF NOT EXISTS HighScores ( " +
            "PlayerName VARCHAR(255) PRIMARY KEY NOT NULL," +
            "Score INT NOT NULL )";
    
    private Connection conn;
    private String checksum;
    
    /**
     * Initializes database.
     * @param checksum MD5 checksum obtained from preferences
     * @throws java.lang.IllegalStateException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public DB(String checksum) throws IllegalStateException,
            SQLException, ClassNotFoundException {
        // Loads database
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:data.db");
        
        Statement stmt = this.conn.createStatement();
        
        // Attempts to create new table
        stmt.executeUpdate(SQL_CREATE_TABLE_HIGHSCORES);
        stmt.close();
        
        // Generates MD5 checksum of the database file
        try (InputStream is = Files.newInputStream(Paths.get("data.db"))) {
            this.checksum = DigestUtils.md5Hex(is);
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
     */
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
