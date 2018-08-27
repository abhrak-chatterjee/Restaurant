package com.restaurant.query;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.restaurant.db.ConnectionFactory;

public class RestaurantDetails 
{
	MongoDatabase database;
	DB db;
	@SuppressWarnings("rawtypes")
	public void getAllRestaurants()
	{
		// Retrieving a collection 
		database=ConnectionFactory.getDB();
		MongoCollection<Document> collection = database.getCollection("Restaurant");
		System.out.println("Collection sampleCollection selected successfully"); 

      // Getting the iterable object 
      FindIterable<Document> iterDoc = collection.find(); 
      // Getting the iterator 
      Iterator<Document> it = iterDoc.iterator(); 
    
      while (it.hasNext()) 
      {  
         System.out.println(it.next()); 
      }
	}
	public void query2()
	{
		db = ConnectionFactory.getDB1();
	    DBCollection coll = db.getCollection("Restaurant");
		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		fields.put("_id", 0);
		fields.put("restaurant_id", 1);
		fields.put("name", 2);
		fields.put("borough", 3);
		fields.put("cuisine", 4);
		DBCursor cursor = coll.find(allQuery, fields);
		while (cursor.hasNext()) 
		{
			System.out.println(cursor.next());
		}
	}
	public void query3()
	{
		db = ConnectionFactory.getDB1();
	    DBCollection coll = db.getCollection("Restaurant");
		BasicDBObject allQ1 = new BasicDBObject();
		BasicDBObject field = new BasicDBObject();
		field.put("_id", 0);
	   field.put("restaurant_id", 1);
	   field.put("name", 1);
	   field.put("borough", 1);
	   field.put("cuisine", 1);  
	   DBCursor cursor1 = coll.find(allQ1, field);
	   while (cursor1.hasNext()) 
	   {
		   System.out.println(cursor1.next());
	   }
	   System.out.println("Retrieved without id!\n\n");
	}
	public void query4()
	{
		db = ConnectionFactory.getDB1();
	    DBCollection coll = db.getCollection("Restaurant");
		BasicDBObject allQ1 = new BasicDBObject();
		BasicDBObject field1 = new BasicDBObject();
		field1.put("_id", 0);
		   field1.put("restaurant_id", 1);
		   field1.put("name", 1);
		   field1.put("borough", 1);
		   field1.put("cuisine", 1);
		   field1.put("address.zipcode", 1);
		   DBCursor cursor2 = coll.find(allQ1, field1);
		   while (cursor2.hasNext()) {
		   System.out.println(cursor2.next());
		   
		   }
		   System.out.println("Zipcode printed");


	}
	public void query5()
	{
		System.out.println("Borough=Bronx");
		database=ConnectionFactory.getDB();
		MongoCollection<Document> collection = database.getCollection("Restaurant");
		System.out.println("Borough=Bronx");
	   FindIterable<Document> iter =collection.find(Filters.eq("borough","Bronx")); 
	   int i1 = 1;  
	   Iterator<Document> it1 = iter.iterator();   
	   while (it1.hasNext()) 
	   {  
	      System.out.println(it1.next());  
	      i1++;    
	   }
	}
	public void query6()
	{
		System.out.println("Borough=Bronx, First 5");
		database=ConnectionFactory.getDB();
		MongoCollection<Document> collection = database.getCollection("Restaurant");
		FindIterable<Document> iter1 =collection.find(Filters.eq("borough","Bronx")).limit(5); 
		   Iterator<Document> it2 = iter1.iterator();   
		   while (it2.hasNext())
		   {  
		      System.out.println(it2.next());    
		   }

	}
	public void query7()
	{
		System.out.println("\n\nBorough=Bronx, next 5 after skipping ");
		database=ConnectionFactory.getDB();
		MongoCollection<Document> collection = database.getCollection("Restaurant");
		FindIterable<Document> iter2 =collection.find(Filters.eq("borough","Bronx")).limit(5).skip(5); 
	   int i3 = 1;  
	   Iterator it3 = iter2.iterator();   
	   while (it3.hasNext()) 
	   {  
	      System.out.println(it3.next());  
	      i3++;    
	   }
	}
	public void query8()
	{
		System.out.println("Score greater than 90:");
		db = ConnectionFactory.getDB1();
	    DBCollection coll = db.getCollection("Restaurant");
		BasicDBObject allQuery = new BasicDBObject();
		allQuery.put("grades.score", new BasicDBObject("$gt",90));
		DBCursor cursor = coll.find(allQuery);
		while(cursor.hasNext()) 
		{
			System.out.println(cursor.next());
		}
	}

	public void query9()
	{
		db = ConnectionFactory.getDB1();
	    DBCollection coll = db.getCollection("Restaurant");
		BasicDBObject allQuery = new BasicDBObject();
		System.out.println("Score more than 80 and less than 100:");
		allQuery.put("grades.score", new BasicDBObject("$gt",80).append("$lt", 100));
		DBCursor cursor = coll.find(allQuery);
		while(cursor.hasNext()) 
		{
			System.out.println(cursor.next());
		}
	}

	public void query10()
	{
		db = ConnectionFactory.getDB1();
	    DBCollection coll = db.getCollection("Restaurant");
		BasicDBObject allQuery = new BasicDBObject();
		System.out.println("Latitude value less than -95.754168:");
		allQuery.put("adress.coord.0", new BasicDBObject("$lt",95.754168));
		DBCursor cursor = coll.find(allQuery);
		while(cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}

}
