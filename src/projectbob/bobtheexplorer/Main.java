/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectbob.bobtheexplorer;

import projectbob.bobtheexplorer.util.*;
import javafx.application.Application;

/**
 * Main class where things load up first
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static DB db;
    public static void main(String[] args) {
        // Loads properties
        Properties props = new Properties();
        
        // Loads MD5 checksum from saved properties
        final String DB_CHECKSUM = props.getDBChecksum();

        // Loads database
        try {
            db = new DB(DB_CHECKSUM, props);
            props.setDBChecksum(db.getChecksum());
            
            Application.launch(projectbob.bobtheexplorer.UI.App.class, args);
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage()                   +
                    "\nPlease delete data.db file to reset "    +
                    "(any previous progress would be lost).");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}
