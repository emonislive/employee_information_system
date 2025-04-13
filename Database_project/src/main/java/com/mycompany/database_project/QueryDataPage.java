package com.mycompany.database_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class QueryDataPage extends JFrame {
    private JTextArea queryArea;
    private JTextArea resultArea;

    public QueryDataPage() {
        setTitle("Query Data");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36
        setLayout(new BorderLayout());

        // Panel for the query area
        JPanel queryPanel = new JPanel(new BorderLayout());
        queryPanel.setBackground(new java.awt.Color(40, 42, 54)); // Background color #282A36

        JLabel queryLabel = new JLabel("SQL Query:");
        queryLabel.setForeground(new java.awt.Color(255, 255, 255)); // Font color #FFFFFF
        queryPanel.add(queryLabel, BorderLayout.NORTH);

        queryArea = new JTextArea();
        JScrollPane queryScroll = new JScrollPane(queryArea);
        queryPanel.add(queryScroll, BorderLayout.CENTER);

        JButton executeButton = new JButton("Execute");
        queryPanel.add(executeButton, BorderLayout.SOUTH);

        // Result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setForeground(new java.awt.Color(255, 85, 85)); // Query result font color #FF5555
        JScrollPane resultScroll = new JScrollPane(resultArea);

        // Split pane to allow resizing between query area and result area
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, queryPanel, resultScroll);
        splitPane.setDividerLocation(150); // Initial divider location
        splitPane.setResizeWeight(0.5); // Give equal weight to both components
        add(splitPane, BorderLayout.CENTER);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    executeQuery(queryArea.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Automatically populate the query area with a SELECT statement to retrieve all data from the 'data' table
        queryArea.setText("SELECT * FROM data;");

        // Execute the default query automatically when the page loads
        try {
            executeQuery(queryArea.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }

    private void executeQuery(String query) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        StringBuilder results = new StringBuilder();
        for (int i = 1; i <= columnCount; i++) {
            results.append(metaData.getColumnName(i)).append("\t");
        }
        results.append("\n");

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                results.append(resultSet.getString(i)).append("\t");
            }
            results.append("\n");
        }

        resultArea.setText(results.toString());

        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QueryDataPage::new);
    }
}
