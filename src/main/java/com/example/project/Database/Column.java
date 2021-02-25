package com.example.project.Database;

import org.sqlite.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Column {

    public static String NULL = "NULL";
    public static String INTEGER = "INTEGER";
    public static String REAL = "REAL";
    public static String TEXT = "TEXT";
    public static String STRING = "STRING";
    public static String BLOB = "BLOB";

    private ArrayList<String> columnData = new ArrayList<>();


    public Column(String name, String type){
        columnData.add(name);
        columnData.add(type);
    }

    public Column isPrimaryKey(){
        this.columnData.add("PRIMARY KEY");
        return this;
    }

    public Column isNotNull(){
        this.columnData.add("NOT NULL");
        return this;
    }

    public Column isUnique(){
        this.columnData.add("UNIQUE");
        return this;
    }

    public Column isAutoIncrement(){
        this.columnData.add("AUTOINCREMENT");
        return this;
    }


    public String toString(){
        return String.join(" ", columnData);
    }

    public String getName(){
        return columnData.get(0);
    }

    //tester method
    public static void main(String[] args) {
        Column column1 = new Column("id", "integer").isPrimaryKey().isAutoIncrement();
        Column column = new Column("name", "TEXT").isNotNull().isUnique();
        Column[] cs = {column, column1};
        String[] c = new String[cs.length];
        for(int i=0;i<cs.length;i++){
            c[i] = cs[i].toString();
        }
        System.out.println(String.join(", \n", c));
    }
}
