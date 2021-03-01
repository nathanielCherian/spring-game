package com.example.project.Database;

import org.json.simple.JSONArray;
import org.sqlite.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Table {

    private ArrayList<Column> columns = new ArrayList<>();
    private String tableName;
    private SQLiteController controller;
    private String[] columnNames;

    public Table(String tableName){
        this.tableName = tableName;
        this.controller = new SQLiteController();

        turnOnForeignKey();
    }

    public void turnOnForeignKey(){
        System.out.println("turning on foreign keys...");
        this.controller.executeCommand("PRAGMA foreign_keys = ON;\n");
    }

    public Table create(){
        controller.createTable(tableName, columns.toArray(new Column[columns.size()]));
        columnNames = new String[columns.size()];
        for(int i=0;i<columnNames.length;i++){
            columnNames[i] = columns.get(i).getName();
        }
        return this;
    }

    public Table addColumn(Column column){
        columns.add(column);
        return this;
    }

    public void createRow(Object[] data){

        /*
        Add validation here
        - data length
        - value type
         */

        if(data.length != columnNames.length) return;

        ArrayList<String> dataVals = new ArrayList<>();
        ArrayList<String> specifiedCols = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i] == null){
                //dataVals[i] = "null";
                continue;
            }
            dataVals.add("'%s'".formatted(data[i].toString()));
            specifiedCols.add(columnNames[i]);
        }

        controller.addRow(this.tableName, specifiedCols.toArray(new String[specifiedCols.size()]), dataVals.toArray(new String[dataVals.size()]));
    }

    public void deleteRow(int columnIndex, Object value){
        String c = columnNames[columnIndex];
        controller.deleteRowByColumn(this.tableName, c, value.toString());
    }

    public Object[][] getFullTable(){
        ResultSet rs = controller.getTable(tableName);
        ArrayList<Object[]> fullTable = new ArrayList<>();
        try{
            while (rs.next()){
                Object[] row = new Object[columns.size()];
                for(int i=0;i<columns.size();i++){
                    row[i] = rs.getObject(i+1);
                }
                fullTable.add(row);
            }
            return fullTable.toArray(Object[][]::new);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public JSONArray getFullTableJSON(){
        ResultSet rs = controller.getTable(tableName);
        JSONArray array = new JSONArray();
        try{
            while (rs.next()){
                JSONArray row = new JSONArray();
                for(int i=0;i<columns.size();i++){
                    row.add(rs.getObject(i+1));
                }
                array.add(row);
            }
            return array;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public void executeRawCommand(String command){
        controller.executeCommand(command);
    }


}
