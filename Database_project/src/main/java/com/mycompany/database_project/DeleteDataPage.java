package com.mycompany.database_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDataPage extends JFrame {
    private JTextField idField;

    public DeleteDataPage() {
        setTitle("Delete Data");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 20, 80, 25);
        idLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        panel.add(idLabel);

        idField = new JTextField(20);
        idField.setBounds(100, 20, 160, 25);
        panel.add(idField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(10, 50, 250, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteData(Integer.parseInt(idField.getText()));
                    JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    private void deleteData(int id) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM data WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();

        statement.close();
        connection.close();
    }
}
