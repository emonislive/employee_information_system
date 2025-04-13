package com.mycompany.database_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataPage extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField valueField;
    private JTextField descriptionField;
    private JTextField categoryField;

    public UpdateDataPage() {
        setTitle("Update Data");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(40, 42, 54)); // Background color #282A36

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 20, 80, 25);
        idLabel.setForeground(new Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(100, 20, 250, 25);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 80, 25);
        nameLabel.setForeground(new Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 50, 250, 25);
        panel.add(nameField);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setBounds(10, 80, 80, 25);
        valueLabel.setForeground(new Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(valueLabel);

        valueField = new JTextField();
        valueField.setBounds(100, 80, 250, 25);
        panel.add(valueField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 110, 80, 25);
        descriptionLabel.setForeground(new Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(descriptionLabel);

        descriptionField = new JTextField();
        descriptionField.setBounds(100, 110, 250, 25);
        panel.add(descriptionField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(10, 140, 80, 25);
        categoryLabel.setForeground(new Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setBounds(100, 140, 250, 25);
        panel.add(categoryField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(10, 180, 100, 25);
        updateButton.setBackground(new Color(92, 184, 92)); // Button color #5CB85C
        updateButton.setForeground(Color.BLACK); // Font color #000000
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateData(Integer.parseInt(idField.getText()), nameField.getText(), valueField.getText(), descriptionField.getText(), categoryField.getText());
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating data");
                }
            }
        });
        panel.add(updateButton);

        add(panel);
        setVisible(true);
    }

    private void updateData(int id, String name, String value, String description, String category) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE data SET name = ?, value = ?, description = ?, category = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, value);
        statement.setString(3, description);
        statement.setString(4, category);
        statement.setInt(5, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UpdateDataPage::new);
    }
}
