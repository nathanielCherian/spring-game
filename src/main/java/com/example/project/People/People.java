package com.example.project.People;

import com.example.project.Database.Column;
import com.example.project.Database.Table;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class People {

    //Tester method
    public static void main(String[] args) {

        Table people = new Table("People")
                .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
                .addColumn(new Column("name", Column.STRING).isNotNull())
                .addColumn(new Column("school", Column.STRING))
                .create();

        people.createRow(new String[]{"name", "school"}, new Object[]{"Nathaniel C", "Del Norte"});
        Object[][] tableData = people.getFullTable();
        System.out.println(Arrays.deepToString(tableData));
    }


    private Table people;
    public People(){
        people = new Table("People")
                .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
                .addColumn(new Column("name", Column.STRING).isNotNull())
                .addColumn(new Column("school", Column.STRING))
                .create();
    }

    public JSONObject getTableData(){
        Object[][] tableData = people.getFullTable();
        JSONArray arr = new JSONArray();
        arr.add(tableData);
        JSONObject object = new JSONObject();
        object.put("data", Arrays.deepToString(tableData));
        return object;
    }

    public String addPersonFromString(String payload){
        try{
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(payload);
            Set<String> keys = object.keySet();
            Collection<String> values = object.values();

            /*
               ADD VALIDATION HERE
               - check user input
               - bleach
             */

            people.createRow(keys.toArray(new String[keys.size()]), values.toArray());
            return "200";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "400";
    }


    public static void addPeople(){
        //people.createRow(new String[]{"name", "school"}, new Object[]{"Nathaniel C", "Del Norte"});
    }

}
