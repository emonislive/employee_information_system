package com.mycompany.database_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 160, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 160, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 250, 25);
        
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new HomePage();
                    dispose(); // Close the login page
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        // You may modify this method to authenticate against your database
        // For demonstration purposes, it currently uses hardcoded credentials
        String hardcodedUsername = "admin";
        String hardcodedPassword = "admin123";

        return username.equals(hardcodedUsername) && password.equals(hardcodedPassword);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
