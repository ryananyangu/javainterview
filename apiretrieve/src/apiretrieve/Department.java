package apiretrieve;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Department {
	private String Name;
	private String Created;
	private String Modified;
	private String Description;
	private int Id;
	public Department()
	{
		  this.Name = null;
		  this.Created= null;
		  this.Modified= null;
		  this.Description= null;
		  this.Id= 0;
	}
	public String getName()
	{
		return this.Name;
	}
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public Date getCreated() {
		return StringToDate(this.Created);
	}
	public void setCreated(String Created)
	{
		this.Created = Created;
	}
	public Date getModified()
	{
		return StringToDate(this.Modified);
	}
	public void setModified(String Modified)
	{
		this.Modified = Modified;
	}
	public String getDescription() {
		return this.Description;
	}
	public void setDescription(String Description)
	{
		this.Description = Description;
	}
	public int getId()
	{
		return this.Id;
	}
	public void setId(int Id)
	{
		this.Id = Id;
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
	public Department getDeptDb(int id)
	{
		System.out.println("\nGetting Department from database ...");
		String sql = "SELECT * FROM Department WHERE ID="+id;
		Database db = new Database();
		ResultSet rs = db.stmtGet(sql);
		try {
			this.setName(rs.getString(""));
			this.setId(rs.getInt(""));
			this.setDescription(rs.getString(""));
			this.setCreated(rs.getString(""));
			this.setModified(rs.getString(""));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nDepartment retrieved :"+this.getName()+" ...");
		return this;
	}
	public Department setDeptDb()
	{
		System.out.println("\nSaving Department to database ...");
		String sql = "INSERT INTO Department values('"+this.getId()+"', '"+this.getName()+"', '"+this.getDescription()+"', '"+this.getCreated()+"', '"+this.getModified()+"')";
		
		Database db = new Database();
		db.stmtGetSave(sql);
		System.out.println("\nDepartment saved :"+this.getName()+" ...");
		return this;
	}
}
