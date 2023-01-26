package com.rishabh.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConfig extends AbstractMongoClientConfiguration {
	
	@Autowired
    private MappingMongoConverter mappingMongoConverter;

	
	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	 @Override
	    public MongoClient mongoClient() {
	        return MongoClients.create(host);
	    }

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * @Override public Mongo mongo() throws Exception { return new
	 * MongoClient(host); }
	 */
	
	
	  @Bean 
	  public GridFsTemplate gridFsTemplate() throws Exception { 
		  return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter); }
	 

}
