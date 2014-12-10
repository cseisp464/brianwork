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
 * Servlet implementation class Organizations
 */

public class Organizations{
	private String uname, orgname, orgadd;
	private JDBCHelper db;
	
	public void addOrg(String organizationName, String organizationAddress, String username) throws IOException, NoSuchAlgorithmException{
		uname = username;
		orgname = organizationName;
		orgadd = organizationAddress;
		
		if(orgname.isEmpty()){
			orgname = "Unknown";
		}
		if(orgadd.isEmpty()){
			orgadd = "Unknown";
		}
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(uname);
		param.add(orgname);
		param.add(orgadd);
		
		String query_string = "INSERT INTO org values (default, ?, ?, ?)";
		
		connectDB();
		
		int result = db.updateDB(query_string, param);
		
		if(result>0){
			System.out.println("Successfully added info");
		}else{
			System.out.println("oops! something went wrong");
		}

		closeDB();

	}
	
	
	private void connectDB(){
		// Testing Database Connection using the JDBC Helper class
		db = new JDBCHelper("cse.unl.edu", "brezac", "brezac", "Redoran1!");
	}
	
	private void closeDB(){
		db.closeDBConnection();
	}
	
	
}
