package com.pluralsight.sandbox.datasource;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import static com.mongodb.client.model.Updates.*;

@Deprecated(forRemoval = true)
public class Read {
	
	static JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();

	public static String readStudent(Integer studentId) {

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://fwdeible:11235813@sandbox-db.0psklxt.mongodb.net/?retryWrites=true&w=majority&appName=sandbox-db")) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_guides");
            MongoCollection<Document> planetCollection = sampleTrainingDB.getCollection("planets");

            // find one document with new Document
            Document student = planetCollection.find(new Document("orderFromSun", studentId)).first();
            
            // find a list
            // uses the .Filters.* import for gte
//            List<Document> studentList = gradesCollection.find(gte("student_id", studentId)).into(new ArrayList<>());
//            System.out.println("Student list with an ArrayList:");
//            for (Document student : studentList) {
//                System.out.println(student.toJson());
//            }
            
            
         // update one document
//            Bson filter = eq("student_id", 10000);
//            Bson updateOperation = set("comment", "You should learn MongoDB! NOWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW!");
//            UpdateResult updateResult = gradesCollection.updateOne(filter, updateOperation);
//            System.out.println("=> Updating the doc with {\"student_id\":10000}. Adding comment.");
//            System.out.println(gradesCollection.find(filter).first().toJson(prettyPrint));
//            System.out.println(updateResult);
            
            
//            Document student1 = gradesCollection.find(new Document("student_id", 10000)).first();
//            System.out.println("updated comment: " + student1.getString("comment"));
            
            if(Objects.isNull(student)) {
            	return "No planet found at position " + studentId;
            }
            else {
            	return student.toJson();
            }
        }
    }
}
