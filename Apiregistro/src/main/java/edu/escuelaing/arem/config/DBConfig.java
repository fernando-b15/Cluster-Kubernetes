package edu.escuelaing.arem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
public class DBConfig {
	
	 @Bean
	    public MongoTemplate mongoTemplate() throws Exception {

		 ConnectionString connString = new ConnectionString(
				    "mongodb+srv://admin:protocolo15@basemongocluster.otant.mongodb.net/test&w=majority"
		);
	     MongoClientSettings settings = MongoClientSettings.builder()
				    .applyConnectionString(connString)
				    .retryWrites(true)
				    .build();

	        MongoClient mongoClient = MongoClients.create(settings);	

	        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient,"AREM");

	        return mongoTemplate;
	    }

	   

}

