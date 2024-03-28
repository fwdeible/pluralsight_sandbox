package com.pluralsight.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pluralsight.sandbox.datasource.Read;

@SpringBootApplication
public class SandboxApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(SandboxApplication.class, args);
//	}
	
	public static void main(String[] args) {
        String connectionString = "mongodb+srv://fwdeible:11235813@sandbox-db.0psklxt.mongodb.net/?retryWrites=true&w=majority&appName=sandbox-db";
//        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
//            System.out.println("=> Connection successful: " + preFlightChecks(mongoClient));
//            System.out.println("=> Print list of databases:");
//            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//            databases.forEach(db -> System.out.println(db.toJson()));
            
//            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");
//            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("grades");
            
//            Document student = addStudent();
            
//            gradesCollection.insertOne(student);
            
//            Read.readStudent(1);
            
//        }
        SpringApplication.run(SandboxApplication.class, args);
        

            

    }

    static boolean preFlightChecks(MongoClient mongoClient) {
        Document pingCommand = new Document("ping", 1);
        Document response = mongoClient.getDatabase("admin").runCommand(pingCommand);
        System.out.println("=> Print result of the '{ping: 1}' command.");
        System.out.println(response.toJson(JsonWriterSettings.builder().indent(true).build()));
        return response.get("ok", Number.class).intValue() == 1;
    }

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Sandbox beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

	private static Document addStudent() {
		Random rand = new Random();
		Document student = new Document("_id", new ObjectId());
		student.append("student_id", 10000d)
		       .append("class_id", 1d)
		       .append("scores", List.of(new Document("type", "exam").append("score", rand.nextDouble() * 100),
		                                 new Document("type", "quiz").append("score", rand.nextDouble() * 100),
		                                 new Document("type", "homework").append("score", rand.nextDouble() * 100),
		                                 new Document("type", "homework").append("score", rand.nextDouble() * 100)));
		return student;
	}
	
}
