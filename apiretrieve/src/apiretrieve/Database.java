package apiretrieve;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	public Connection connect()
	{
	      try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      Connection connection = null;
	      try
	      {
	         // create a database connection
	         connection = DriverManager.getConnection("jdbc:sqlite:database.db");
	      }catch(SQLException e){  System.err.println(e.getMessage()); }       
//		      finally {         
//		            try {
//		                  if(connection != null)
//		                     connection.close();
//		                  }
//		            catch(SQLException e) {  // Use SQLException class instead.          
//		               System.err.println(e); 
//		             }
//		      }
	      return connection;
	}
	public boolean connectionClose()
	{
		if (this.connect() != null)
		{
			try {
				this.connect().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
//				e.printStackTrace();
			}
		}else {
			return true;
		}
		return true;
	}
	public boolean databaseInit()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
			Statement statement = conn.createStatement();
	         statement.setQueryTimeout(30);  // set timeout to 30 sec.
//	         statement.getResultSet();
	         
//	         create the database tables
	         statement.execute("DROP TABLE IF EXISTS Department");
	         statement.execute("CREATE TABLE Department (Id INTEGER, name STRING, description STRING, Created STRING, Modified STRING)");
	         
	         statement.execute("DROP TABLE IF EXISTS Users");
	         statement.execute("CREATE TABLE Users (ID INTERGER ,DeptID INTEGER, FirstName STRING, LastName STRING, DateCreated STRING, DateModified STRING, EmailAddress STRING)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public int stmtGetSave(String sql)
	{

		int response = 0;
		try {
			Connection con = this.connect();
			Statement stmnt = con.createStatement();

			response = stmnt.executeUpdate(sql);

		} catch (SQLException e) {
//			this.connectionClose(con);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connectionClose();
		return response;
	}
	public ResultSet stmtGet(String sql)
	{
		ResultSet rs = null;
		Connection con = this.connect();
		try {
			Statement stmnt = con.createStatement();
				rs = stmnt.executeQuery(sql);
		} catch (SQLException e) {
			this.connectionClose();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connectionClose();
		return rs;
	}
}
