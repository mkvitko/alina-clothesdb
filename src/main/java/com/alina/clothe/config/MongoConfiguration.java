package com.alina.clothe.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

/**
 * Created by mkvitko on 3/23/16.
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.alina.clothe.dao", "com.alina.clothe.entity"})
@PropertySource(value = "classpath:clothe.properties")
public class MongoConfiguration {

    @Value("${mongo.server.host}")
    private String mongoServerHost;
    @Value("${mongo.server.port}")
    private String mongoServerPort;
    @Value("${mongo.server.password}")
    private String mongoServerPassword;
    @Value("${mongo.server.user}")
    private String mongoServerUser;
    @Value("${mongo.db.name}")
    private String mongoDatabaseName;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(new ServerAddress(mongoServerHost, Integer.valueOf(mongoServerPort)),
                Collections.singletonList(MongoCredential.createCredential(mongoServerUser, mongoDatabaseName, mongoServerPassword.toCharArray()))),
                mongoDatabaseName);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) throws Exception {
        return new MongoTemplate(mongoDbFactory);
    }
}