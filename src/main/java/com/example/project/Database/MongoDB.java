/*package com.example.project.Database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDB {

    public static void main(String[] args) {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://firstuser:FXdD1AjgAgssJFZ6@cluster0.1m76a.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");

        MongoCollection<Document> table = database.getCollection("relationships");
        Document doc = new Document("name", "Nathaniel C")
                .append("id",123);
        table.insertOne(doc);

        /*
        MongoClient mongoClient = new MongoClient("54.67.48.1", 27017);
        MongoDatabase db = mongoClient.getDatabase("speedysalamanders");
        MongoCollection<Document> table = db.getCollection("relationships");

        Document doc = new Document("name", "Nathaniel C")
                .append("id",123);
        table.insertOne(doc);
        */
/*
    }


}
*/