package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {

		// Get DRiver from Mysql jar and register this in driver manager
		Driver driverRef = new Driver();

		// Step 1: Register the DRiver
		DriverManager.registerDriver(driverRef);

		// Step 2: Get the connection with driver - provide DB name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");

		// Step 3: issue create statement
		Statement state = con.createStatement();

		// step 4: execute the query - provide table name
		String query = "insert into sampletable values('Jack',5,'california');";
		int result = state.executeUpdate(query);
		
		//validate
		if(result==1)
		{
			System.out.println("data added");
		}
		else
		{
			System.out.println("data not added");
		}

		ResultSet res = state.executeQuery("select * from sampletable;");
		while(res.next())
		{
			System.out.println(res.getString(1));
		}
		
		//Step 5: close the db
		con.close();
	}

}
