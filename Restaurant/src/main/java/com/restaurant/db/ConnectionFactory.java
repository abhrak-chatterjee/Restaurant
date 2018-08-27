package com.restaurant.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class ConnectionFactory
{
	static MongoClient mongo;
	static DB db;
	public static MongoDatabase getDB()
	{
		  mongo = new MongoClient( "localhost" , 27017 ); 
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("RestaurantDB");  
	      return database;
	} 
	@SuppressWarnings({ "deprecation" })
	public static DB getDB1()
	{    
		mongo = new MongoClient( "localhost" , 27017 );
		db = mongo.getDB("RestaurantDB");  
	    return db;
	}
}
