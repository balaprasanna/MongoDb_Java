package Mango_db;

import com.datastax.driver.core.*;
import com.mongodb.BasicDBObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


import java.net.UnknownHostException;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class testMongoDbConnector {

	public static void main(String args[]){
		
		try {
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			DB db = mongoClient.getDB( "local" );
			// to get all the collections in a specific database in mongodb
			Set<String> colls = db.getCollectionNames();

			for (String s : colls) {
			    System.out.println(s);
			}
			
			DBCollection coll = db.getCollection("Car");
			System.out.println("Car collection count in mongo db is"+coll.count()+"");
			
			
		//	BasicDBObject myObj= new BasicDBObject("name", "Dhilip");
		//	coll.insert(myObj);
			
			System.out.println("Car collection count in mongo db is"+coll.count()+"");
			
			DBObject myDoc = coll.findOne();
			
			System.out.println(myDoc.get("name").toString());
			
			// very dangerous code...
			// make sure while uncomment
			// inserting multiple documents..
			/*for (int i=0; i < 1000000; i++) {
			    coll.insert(new BasicDBObject("name"," Prasanna "+i));
			}
			*/
			
			
	/*		System.out.println(System.currentTimeMillis());
			
			long var = System.currentTimeMillis();
			DBCursor cursor = coll.find();
			try {
			   while(cursor.hasNext()) {
			       //System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
			System.out.println("Car collection count in mongo db is"+coll.count()+"");
		
			System.out.println(System.currentTimeMillis());
			System.out.println(System.currentTimeMillis()-var);*/
			
			
			// query
		Random a = new Random();
		int value=	a.nextInt(100000);
	// pass this random number as argument to query th document in mongodb
		
			
			BasicDBObject query = new BasicDBObject("name", " Prasanna "+value);

			DBCursor cursor = coll.find(query);

			try {
			   while(cursor.hasNext()) {
			       System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}
