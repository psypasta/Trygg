package jdbcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		Connection myCon = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to the database
			
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "max", "1994max");
			
			// 2. Create a prepared statement
			
			myStmt = myCon.prepareStatement("select * from employees where salary > ? and department=?");
			
			// 3. Set the parameters
			
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			// 4. Execute SQL query
			
			myRs = myStmt.executeQuery();			
			
			// 4. Display result set
			
			display(myRs);
			
			// re use prepared statement
			
			System.out.println("");
			
			// 6. Set the parameters
			
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");
			
			// 7. execute SQL query
			
			myRs = myStmt.executeQuery();	
			
			// 8. Display result set
			
			display(myRs);
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}

	}
	
	public static void display(ResultSet rs) {
		try {
			while(rs.next()) {
				System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name") + ", " + rs.getString("salary") + ", " + rs.getString("department"));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}