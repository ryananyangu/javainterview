package apiretrieve;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import apiretrieve.Database;
import webservice.Company;
import webservice.Company_Service;
import webservice.Staff;

public class User {
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String DateModified;
	private String DateCreated;
	private int ID;
	private int DeptID;
	
	public User() {
		
	}
	
	public User(String FirstName, String LastName, String EmailAddress, String DateModified, String DateCreated, int Id, int DeptID)
	{
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.EmailAddress = EmailAddress;
		this.DateModified = DateModified;
		this.DateCreated = DateCreated;
		this.ID = Id;
		this.DeptID = DeptID;
	}
	public Staff getUserDb(int id)
	{
		System.out.println("\nGetting user from database ...");
		String sql = "SELECT * FROM Users WHERE ID="+id;
		Database db = new Database();
		Staff usr = new Staff();
		ResultSet rs = db.stmtGet(sql);
		try {
//			ID INTERGER ,DeptID INTEGER, FirstName STRING, LastName STRING, DateCreated STRING, DateModified STRING, EmailAddress STRING
			usr.setDateCreated(rs.getString("DateCreated"));
			usr.setDateModified(rs.getString("DateModified"));
			usr.setEmailAddress(rs.getString("EmailAddress"));
			usr.setFirstName(rs.getString("EmailAddress"));
			usr.setLastName(rs.getString("EmailAddress"));
			usr.setDepartmentID(rs.getInt("DeptID"));
			usr.setStaffID(rs.getInt("ID"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nUser Retrieved "+usr.getEmailAddress()+" ...");
		return usr;
	}
	
//	using wsimport to retrieve users 
	public void getUsers(int i)
	{
		
		System.out.println("\n New user being added to database");
		List<Staff> staff = null;
		Company_Service company = new Company_Service();
//		name of the service port
		Company company_interface =  company.getCompanyPort();
//		service endpoints extracted from the the serivce port instance
		staff = company_interface.fetchStaff(i);
		for (Staff usr : staff)
		{
			String sql = "INSERT INTO Users values('"
					+usr.getStaffID()+"','"
					+usr.getDepartmentID()+"','"
					+usr.getFirstName()+"','"
					+usr.getLastName()+"','"
					+usr.getDateCreated()+"','"
					+usr.getDateModified()+"','"
					+usr.getEmailAddress()
					+"')";
			Database db = new Database();
			db.stmtGetSave(sql);
			System.out.println("\nUSer saved to database "+usr.getEmailAddress()+" ...");
		}
		
		
	}
}
