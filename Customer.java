/* RoboMQ
 * Abhishek Khandelwal
 * 23-01-2020
 * Day-4-Assignment
 * JDBC
 */

package DataBase;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Customer {

       Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement pre;
	   ResultSet res;
	   String fname;
	   String lname;
	   String address;
	   String email;
	   
	   
	   public Customer()
	   {
		   try {
			   

		        //Creating the connection 
		       Class.forName("com.mysql.jdbc.Driver");
		       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","A889026a");
		       System.out.println("Connected");
		       
		     //STEP 4: Execute a query
		       System.out.println("Creating database...");
		       stmt = conn.createStatement();
		       
	
		    //   String sql = "CREATE DATABASE Customer";
		       //stmt.executeUpdate(sql);
		       System.out.println("Database created successfully...");
		       
		   	// just creating query object in JRE 
				CallableStatement stat = conn.prepareCall("create table customers (customer_id int(11) AUTO_INCREMENT PRIMARY KEY, fname varchar(100), lname varchar(100), address varchar(100), email varchar(100))");
				// this statement will fire your query to the database. false ==table created
							boolean result=stat.execute();
							if(!result)
								System.out.println("Table Created....");
							else
								System.out.println("Table Not Created....");
					       
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
    }
	   
	public void insert() 
	{
	   try
	   {
		   
		   //Entering the data 
		   Scanner sc = new Scanner(System.in);
		   System.out.println("Enter First Name: \n");
		   fname = sc.next();
		   System.out.println("Enter Last Name: \n");
		   lname = sc.next();
		   System.out.println("Enter Address: \n");
		   address = sc.next();
		   System.out.println("Enter Email: \n");
		   email = sc.next();
		   
		   
	       //Inserting data using SQL query
		   pre = conn.prepareStatement("insert into customers(fname,lname,address,email) values(?,?,?,?)");
		   pre.setString(1, fname);
		   pre.setString(2, lname);
		   pre.setString(3, address);
		   pre.setString(4, email);
		   
		   int ra = pre.executeUpdate();
		   if(ra > 0)
			   System.out.println("Customer details are successfully entered...");
		   else
			   System.out.println("Customer details are not enter..");
		   pre.close();
		  
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	}
	
	
	void update()
	{
	  	
		try
		   {
			   
			   stmt = conn.createStatement();
			   
		       //Updating data using SQL query
		       String sql = "UPDATE customers SET fname = ? WHERE customer_id = ?)";
		       pre.setString(1,"Ghanu");
		       
		       
		       pre.executeUpdate(sql);
		   } 
		catch(Exception e)
		     {
		    	 e.printStackTrace();   
		     }
	  }
	
	void delete()
	{
		try
		{
		       //Delete data using SQL query
			pre=conn.prepareStatement("delete from customers where customer_id=?");
			pre.setInt(2,10);
			
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Record Deleted...");
			else
				System.out.println("Record has not Deleted...");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	 }
	void printdata()
	{
		try
		{
		       //Printing data using SQL query
			String sql = "SELECT * FROM customers";
		    ResultSet rs = stmt.executeQuery(sql);

		     while(rs.next())
		       {
		          //Retrieve by column name
		    	  int customer_id = rs.getInt("customer_id");
		          String fname  = rs.getString("fname");
		          String lname = rs.getString("lname");
		          String address = rs.getString("address");
		          String email = rs.getString("email");

		          //Display values
		          System.out.println("customer_id: "+ customer_id);
		          System.out.print("fname: " + fname);
		          System.out.print(", lname: " + lname);
		          System.out.print(", address: " + address);
		          System.out.println(", email: " + email);
		       }
		       rs.close();
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
	}

}
