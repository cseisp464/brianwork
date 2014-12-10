package com.cseisp464.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.xml.sax.InputSource;
/**
 * Servlet implementation class Clients
 */

public class Clients{
	private Users user;
	private JDBCHelper db;
	private Organizations org;
	private String path_to_properties_file;
	
	public Clients(Users user, Organizations org){
		setUsers(user);
		setOrg(org);
	}
	
	public Clients(String path){
		// Storing the path to the properties file
		path_to_properties_file = path+"\\WEB-INF\\classes\\users.properties";		
	}

	public Users getUsers(){
		return(user); 
	}
	
	public void setUsers(Users user){
		this.user = user;
	}
	
	public Organizations getOrg(){
		return(org);
	}
	
	public void setOrg(Organizations org){
		this.org = org;
	}
	
	public void addUser(String firstname, String lastname, String emailAddress, String username, String password){
		try {
			user.addUser(firstname, lastname, emailAddress, username, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void authenticateUser(String username, String entered_password){
		try {
			user.authenticateUser(username, entered_password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public boolean checkIfValueExists(String column_name, String value) throws IOException, SQLException{

		boolean status = false;
		
		// List to hold the username 
		ArrayList<Object> param =  new ArrayList<Object>();
		// Adding the username to the list
		param.add(value);
		// Composing the query to check if the user exists
		String query_string = "SELECT * FROM users" + " WHERE " + column_name + " = ? ";
		
		connectDB();
		
		ResultSet rs1 = db.queryDB(query_string, param);

		// Checking if record exists
		if(rs1.next()){
			status = true;
		}
		
		closeDB();
		return status;
		
	}
	
	public void addOrg(String organizationName, String organizationAddress, String username){
		try {
			org.addOrg(organizationName, organizationAddress, username);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void connectDB(){
		// Testing Database Connection using the JDBC Helper class
		db = new JDBCHelper("cse.unl.edu", "spalusa", "spalusa", "Test@464");
	}
	
	 void closeDB(){
		db.closeDBConnection();
	}
}
