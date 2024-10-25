/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectbob.bobtheexplorer.util;

import java.util.prefs.Preferences;

/**
 *
 * @author Ong Yean
 */
public class Properties {
    private Preferences prefs;
    
    /**
     * Initializes properties instance.
     */
    public Properties() {
        this.prefs = Preferences.userNodeForPackage(projectbob.bobtheexplorer.Main.class);
    }
    
    /**
     * Gets the MD5 checksum of the database file from saved properties.
     * @return MD5 checksum
     */
    public String getDBChecksum() {
        return prefs.get("DB_CHECKSUM", null);
    }
    
    /**
     * Sets the MD5 checksum of the database file in properties.
     * @param checksum MD5 checksum
     */
    public void setDBChecksum(String checksum) {
        prefs.put("DB_CHECKSUM", checksum);
    }
}
