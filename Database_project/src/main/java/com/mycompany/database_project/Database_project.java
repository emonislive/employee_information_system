package com.mycompany.database_project;

import javax.swing.UIManager;

public class Database_project {
    public static void main(String[] args) {
        // Set the look and feel of the GUI to the system's look and feel (optional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch the login page
        new LoginPage();
    }
}
