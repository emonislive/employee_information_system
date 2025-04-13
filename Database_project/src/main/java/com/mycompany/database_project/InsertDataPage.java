package com.mycompany.database_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataPage extends JFrame {
    private JTextField nameField;
    private JTextField valueField;
    private JTextField descriptionField;
    private JTextField categoryField;

    public InsertDataPage() {
        setTitle("Insert Data");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        nameLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 250, 25);
        panel.add(nameField);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setBounds(10, 50, 80, 25);
        valueLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(valueLabel);

        valueField = new JTextField();
        valueField.setBounds(100, 50, 250, 25);
        panel.add(valueField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 80, 80, 25);
        descriptionLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(descriptionLabel);

        descriptionField = new JTextField();
        descriptionField.setBounds(100, 80, 250, 25);
        panel.add(descriptionField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(10, 110, 80, 25);
        categoryLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setBounds(100, 110, 250, 25);
        panel.add(categoryField);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(10, 150, 100, 25);
        insertButton.setBackground(new java.awt.Color(92, 184, 92)); // Button color #5CB85C
        insertButton.setForeground(Color.BLACK); // Font color #000000
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertData(nameField.getText(), valueField.getText(), descriptionField.getText(), categoryField.getText());
                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error inserting data");
                }
            }
        });
        panel.add(insertButton);

        add(panel);
        setVisible(true);
    }

    private void insertData(String name, String value, String description, String category) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO data (name, value, description, category) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, value);
        statement.setString(3, description);
        statement.setString(4, category);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InsertDataPage::new);
    }
}
