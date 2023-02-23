package dk.tec.jaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBTool 
{
	private Connection con;
	private Statement stmt;
	
	String connectionString = 
			"jdbc:sqlserver://localhost:1433;databaseName=ApiDB;encrypt=true;trustServerCertificate=true;";
	
	

	private void connect() 
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionString, "sa", "1234");
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public Elev getElevById(int id) 
	{
		connect();
		Elev elev = new Elev();
		
		String selectStr = "Select * from Elev where Id = " + id;
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			if(result.next())
			{
				elev.setId(result.getInt("Id"));
				elev.setName(result.getString("Name"));
				elev.setJob(result.getString("Job"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elev;
	}
	
	


	public List<Elev> getAllElev(){
		
		return null;
	}
	
	
}
