package com.mycompany.database_project;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    public HomePage() {
        // Set the look and feel to Metal to ensure custom colors are applied
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Home Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Adjusted to GridLayout(4, 1) to fit 4 buttons
        panel.setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JButton insertButton = new JButton("Insert Data");
        insertButton.addActionListener(e -> new InsertDataPage());
        insertButton.setBackground(new java.awt.Color(40, 42, 54)); // Button color #282A36
        insertButton.setForeground(Color.WHITE); // Font color #FFFFFF
        panel.add(insertButton);

        JButton updateButton = new JButton("Update Data");
        updateButton.addActionListener(e -> new UpdateDataPage());
        updateButton.setBackground(new java.awt.Color(40, 42, 54)); // Button color #282A36
        updateButton.setForeground(Color.WHITE); // Font color #FFFFFF
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete Data");
        deleteButton.addActionListener(e -> new DeleteDataPage());
        deleteButton.setBackground(new java.awt.Color(40, 42, 54)); // Button color #282A36
        deleteButton.setForeground(Color.WHITE); // Font color #FFFFFF
        panel.add(deleteButton);

        JButton queryButton = new JButton("Query Data");
        queryButton.addActionListener(e -> new QueryDataPage());
        queryButton.setBackground(new java.awt.Color(40, 42, 54)); // Button color #282A36
        queryButton.setForeground(Color.WHITE); // Font color #FFFFFF
        panel.add(queryButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomePage::new);
    }
}
