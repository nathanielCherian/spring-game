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

        people.createRow(new Object[]{null, "Nathaniel C", "Del Norte"});
        Object[][] tableData = people.getFullTable();
        System.out.println(Arrays.deepToString(tableData));

        Table relationships = new Table("Relationships")
                .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
                .addColumn(new Column("personId", Column.INTEGER).isForeignKey("People", "id", Column.CASCADE))
                .addColumn(new Column("personId2", Column.INTEGER).isForeignKey("People", "id", Column.CASCADE))
                .create();
        relationships.createRow(new Object[]{null,1,100});
        System.out.println(Arrays.deepToString(relationships.getFullTable()));

    }


    private Table people;
    private Table relationships;
    public People(){
        people = new Table("People")
                .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
                .addColumn(new Column("name", Column.STRING).isNotNull())
                .addColumn(new Column("school", Column.STRING))
                .create();

        relationships = new Table("Relationships")
                .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
                .addColumn(new Column("personId1", Column.INTEGER).isForeignKey("People", "id", Column.CASCADE))
                .addColumn(new Column("personId2", Column.INTEGER).isForeignKey("People", "id", Column.CASCADE))
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
                case "CREATE_RELATIONSHIP":
                    return addRelationshipFromJSON(object);
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

    public JSONObject getTableDataRelationship(){
        JSONArray tableData = relationships.getFullTableJSON();
        JSONObject object = new JSONObject();
        object.put("data", tableData);
        return object;
    }


    public String getPersonFromId(int id){
        JSONArray personData = people.getRowsByColumn("id", id);
        JSONArray relationshipData = relationships.getRowsByColumn("personId1", id);
        JSONObject object = (JSONObject) personData.get(0);
        object.put("relationships", relationshipData);

        return object.toJSONString();
    }

    public String addPersonFromJSON(JSONObject object){

        Object[] data = new Object[3];
        data[0] = null; //id
        data[1] = (String) object.get("name");
        data[2] = (String) object.get("school");

        /*
           ADD VALIDATION HERE
           - check user input
           - bleach
         */

        people.createRow(data);
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


    public String addRelationshipFromJSON(JSONObject object){

        Object[] data = new Object[3];
        data[0] = null; //auto-inc id
        data[1] = Long.valueOf((Long) object.get("personId1")).intValue();
        data[2] = Long.valueOf((Long) object.get("personId2")).intValue();
        if(data[1] == data[2]) return "400"; //force unique
        relationships.createRow(data);

        return "200";
    }

}
