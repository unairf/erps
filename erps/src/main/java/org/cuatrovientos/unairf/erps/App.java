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
	private static void deleteAll() throws IOException, SQLException {
		
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		String deleteSql = "delete from friends";
		statement.executeUpdate(deleteSql);
		showMenu();
		showMenu();
	}
	private static void delete() throws IOException, SQLException {
		int id;
		System.out.println("What ID do you want to delete?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		id = Integer.parseInt(reader.readLine());
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		String deleteSql = "delete from friends where id=" + id;
		statement.executeUpdate(deleteSql);
		showMenu();
	}
	private static void modify() throws IOException, SQLException {
		String newName = "";
		int id = 0;
		System.out.println("What number are you looking for?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		id = Integer.parseInt(reader.readLine());
		System.out.println("Enter the new name: ");
		newName = reader.readLine();
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		String updateSql = "update friends set name='" + newName + "',id=" + id + " where id=" + id;
		statement.executeUpdate(updateSql);
		showMenu();
	}
	private static void insert() throws IOException, SQLException {
		// TODO Auto-generated method stub
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input a number: ");
		String line1 = reader.readLine();
		int id = Integer.parseInt(line1);
		System.out.println("Input a name: ");
		String line2 = reader.readLine();
		String insertSql = "insert into friends values(" + id + ",\"" + line2 + "\")";
		statement.executeUpdate(insertSql);
		//This should be done by following next method, it will be implemented in the future
		//PreparedStatement preparedStatement =
			//	connection.prepareStatement("insert into friends values (?,?)");
		//preparedStatement.setInt(1,7);
		//preparedStatement.setString(2, "Endika");
		//preparedStatement.addBatch();
		
		showMenu();
	}
	private static void showAll() throws IOException, SQLException {
		System.out.println("Showing all");
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		
		Statement statement = connection.createStatement();
		String select = "select * from friends order by name desc";
		ResultSet resultSet = statement.executeQuery(select);
		while (resultSet.next()) {
			//System.out.print("ID: " + resultSet.getString(1));
			//System.out.println(" Name: " + resultSet.getString(2));
			System.out.print("ID: " + resultSet.getInt("id"));
			System.out.println(" Name: " + resultSet.getString("name"));
		}
		
		
		showMenu();
	}
	public static void showMenu() throws IOException {
		//System.out.println("0. Create database(can be selected once)");
    	System.out.println( "1. Show all registers" );
		System.out.println( "2. Insert new registers" );
		System.out.println( "3. Modify register" );
		System.out.println( "4. Delete register" );
		System.out.println( "5. Delete all registers" );
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
    		System.out.println("Bye!");
    		break;
    	case 1: 
    		showAll();
    	//	System.out.println("Showed all");
    		break;
    	case 2: 
    		insert();
    		//System.out.println("Inserted");
    		break;
    	case 3:
    		modify();
    	//	System.out.println("Modifying");
    		break;
    	case 4:
    		delete();
    	//	System.out.println("Deleting");
    		break;
    	case 5:
    		deleteAll();
    	//	System.out.println("Deleting all");
    		break;
    	
    	}
		
		
		
		
	}
}
