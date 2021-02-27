package com.example.project.People;

import com.example.project.Database.Column;
import com.example.project.Database.Table;
import com.example.project.Security;
import org.apache.logging.log4j.message.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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


    public String parseJSON(String s){

        try{
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(s);
            String actionCode = (String) object.get("actionCode");
            object.remove("actionCode");
            switch (actionCode){
                case "CREATE":
                    return addPersonFromJSON(object);
                case "DELETE_BY_ID":
                    return removePersonByID(object);
                case "ADMIN":
                    return adminCommand(object);
                default:
                    return "400";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "400";
    }



    public JSONObject getTableData(){
        JSONArray tableData = people.getFullTableJSON();
        JSONObject object = new JSONObject();
        object.put("data", tableData);
        return object;
    }

    public String addPersonFromJSON(JSONObject object){
        Set<String> keys = object.keySet();
        Collection<String> values = object.values();

        /*
           ADD VALIDATION HERE
           - check user input
           - bleach
         */

        people.createRow(keys.toArray(new String[keys.size()]), values.toArray());
        return "200";
    }

    public String removePersonByID(JSONObject object){
        int idToRemove = Long.valueOf((Long) object.get("idToRemove")).intValue();
        people.deleteRow(0, idToRemove);
        return "200";
    }



    public String adminCommand(JSONObject object){
        if(!Security.verifySignature((String)object.get("password"))) return "Incorrect Authentication";
        String command = (String) object.get("command");
        people.executeRawCommand(command);
        return "200";
    }

    /*
    public String adminQuery(JSONObject object){
        String query = (String) object.get("query");
    }
    */



}
