package apiretrieve;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import apiretrieve.Database;

public class User {
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String DateModified;
	private String DateCreated;
	private int ID;
	private int DeptID;
//	private User usr;
	
	public User()
	{
		this.FirstName = null;
		this.LastName = null;
		this.EmailAddress = null;
		this.DateModified = null;
		this.DateCreated = null;
		this.ID = 0;
		this.DeptID = 0;
	}
	public void setFirstName(String FirstName)
	{
		this.FirstName = FirstName;
	}
	public String getFirstName()
	{
		return this.FirstName;
	}
	public void  setLastName(String LastName)
	{
		this.LastName = LastName;
	}
	public String getLastName()
	{
		return this.LastName;
	}
	public void setEmail(String Email)
	{
		this.EmailAddress = Email;
	}
	public String getEmail()
	{
		return this.EmailAddress;
	}
	public void setModified(String Modified)
	{
		this.DateModified = Modified;
	}
	public Date getDateModified()
	{
		return StringToDate(this.DateModified);
	}
	public void setDateCreated(String Created)
	{
		this.DateCreated = Created;
	}
	public Date getDateCreated()
	{
		return StringToDate(this.DateCreated);
	}
	public void setDeptID(int dept)
	{
		this.DeptID = dept;
	}
	public int getDept()
	{
		return this.DeptID;
	}
	public int getID()
	{
		return this.ID;
	}
	public void setID(int Id)
	{
		this.ID = Id;
	}
	private Date StringToDate(String dateStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public User getUserDb(int id)
	{
		System.out.println("\nGetting user from database ...");
		String sql = "SELECT * FROM Users WHERE ID="+id;
		Database db = new Database();
		ResultSet rs = db.stmtGet(sql);
		try {
//			ID INTERGER ,DeptID INTEGER, FirstName STRING, LastName STRING, DateCreated STRING, DateModified STRING, EmailAddress STRING
			this.setDateCreated(rs.getString("DateCreated"));
			this.setModified(rs.getString("DateModified"));
			this.setEmail(rs.getString("EmailAddress"));
			this.setFirstName(rs.getString("EmailAddress"));
			this.setLastName(rs.getString("EmailAddress"));
			this.setDeptID(rs.getInt("DeptID"));
			this.setID(rs.getInt("ID"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nUser Retrieved "+this.getEmail()+" ...");
		return this;
	}
	public User saveUserDb(User usr)
	{
		System.out.println("\nSaving User to database ...");
//		"CREATE TABLE Users (ID INTERGER ,DeptID INTEGER, FirstName STRING, LastName STRING, DateCreated STRING, DateModified STRING, EmailAddress STRING)"
		String sql = "INSERT INTO Users values('"
				+this.getID()+"','"
				+this.getDept()+"','"
				+this.getFirstName()+"','"
				+this.getLastName()+"','"
				+this.getDateCreated()+"','"
				+this.getDateModified()+"','"
				+this.getEmail()
				+"')";
		Database db = new Database();
//		Connection conn = db.connect();
		db.stmtGetSave(sql);
		System.out.println("\nUSer saved to database "+this.getEmail()+" ...");
		return this;
	}
	public Department getUserDept(int id)
	{
		System.out.println("\nGetting User "+this.getEmail()+" Department ...");
		Department dpt = new Department();
		dpt.getDeptDb(id);
		System.out.println("\nUser : \n"+this.getEmail()
		+"\n Departement :\n"+dpt.getName()+" ...");
		return dpt;
	}
}
