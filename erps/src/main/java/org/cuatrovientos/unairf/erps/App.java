package org.cuatrovientos.unairf.erps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static int option;
	private static boolean cancel = true;
	private static int number = 10;
    public static void main( String[] args ) throws ClassNotFoundException, SQLException, IOException {
    	
		
    showMenu();
       
    }
    private static void createDatabase() throws ClassNotFoundException, SQLException {
    	Class.forName("org.sqlite.JDBC");
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		String sql = "create table friends (id integer, name varchar(30))";
		statement.executeUpdate(sql);
		System.out.println("Database created successdylly");
		String insertSql = "insert into friends values(3,'Zoco')";
		statement.executeUpdate(insertSql);
	}
	private static void deleteAll() throws IOException {
		// TODO Auto-generated method stub
		showMenu();
	}
	private static void delete() throws IOException {
		// TODO Auto-generated method stub
		showMenu();
	}
	private static void modify() throws IOException {
		// TODO Auto-generated method stub
		showMenu();
	}
	private static void insert() throws IOException {
		// TODO Auto-generated method stub
		showMenu();
	}
	private static void showAll() throws IOException {
		System.out.println("Showing all");
		
		
		showMenu();
	}
	public static void showMenu() throws IOException {
		System.out.println("0. Create database");
    	System.out.println( "1. Show all registres" );
		System.out.println( "2. Insert new registre" );
		System.out.println( "3. Modify registre" );
		System.out.println( "4. Delete registre" );
		System.out.println( "5. Delete all registres" );
		System.out.println( "6. Exit" );
		while (cancel) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose an option: ");
			String line = reader.readLine();
			try{
			number = Integer.parseInt(line);
			if (number < 7 && number > 0) {
				optionSelected(number);
				cancel = false;
				break;
			} else {
				cancel = true;
			}
			} catch (Exception e){
				System.out.println("Error: " + number + line);
				cancel = true;
			}finally {
			     
			}
		}
		
    }
	private static void optionSelected(int number) throws ClassNotFoundException, SQLException, IOException {
		
		switch (number) {
    	case 6:
    		createDatabase();
   System.out.println("Created database");
    		break;
    	case 1: 
    		showAll();
    		System.out.println("Showed all");
    		break;
    	case 2: 
    		insert();
    		System.out.println("Inserted");
    		break;
    	case 3:
    		modify();
    		System.out.println("Modifying");
    		break;
    	case 4:
    		delete();
    		System.out.println("Deleting");
    		break;
    	case 5:
    		deleteAll();
    		System.out.println("Deleting all");
    		break;
    	
    	}
		
		
		
		
	}
}
