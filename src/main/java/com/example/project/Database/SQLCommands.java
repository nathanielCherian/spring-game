package com.example.project.Database;

import java.sql.ResultSet;

public interface SQLCommands {
    void createTable(String tableName, Column[] columns);
    void deleteTable(String tableName);

    void addRow(String tableName, String[] columnNames, String[] values);
    void deleteRowByColumn(String tableName, String columnName, String targetValue);

}

