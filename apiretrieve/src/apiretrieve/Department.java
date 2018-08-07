package apiretrieve;
import webservice.Departments;
import webservice.Company_Service;
import webservice.Company;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Department {
	private String Name;
	private String Created;
	private String Modified;
	private String Description;
	private int Id;
	public Department() {
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	public String getModified() {
		return Modified;
	}
	public void setModified(String modified) {
		Modified = modified;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Department(String name, String Created, String Modified,String Description, int Id)
	{
		  this.Name = name;
		  this.Created= Created;
		  this.Modified= Modified;
		  this.Description= Description;
		  this.Id= Id;
	}

	
	public Department getDeptDb(int id)
	{
		System.out.println("\nGetting Department from database ...");
		String sql = "SELECT * FROM Department WHERE ID="+id;
		Database db = new Database();
		ResultSet rs = db.stmtGet(sql);
		Departments department = new Departments();
		try {
			department.setName(rs.getString("name"));
			department.setDepartmentID(rs.getInt("Id"));
			department.setDescription(rs.getString("description"));
			department.setDateCreated(rs.getString("Created"));
			department.setDateModified(rs.getString("Modified"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nDepartment retrieved :"+department.getName()+" ...");
		return this;
	}
	
//	get the list of departments using wsimport stub generation
	public List<Integer> test() {
		List<Integer> availableDpts = new ArrayList<Integer>();
//		list the incoming result somewhere
		List<Departments> departments;
//		name of the service 
		Company_Service company = new Company_Service();
//		name of the service port
		Company company_interface =  company.getCompanyPort();
//		service endpoints extracted from the the serivce port instance
		departments = company_interface.fetchDepartments();
		for (Departments dpt : departments) {
//			System.out.println("\n "+dpt.getDescription()); 
			System.out.println("\nSaving Department to database ...");
			String sql = "INSERT INTO Department values('"+dpt.getDepartmentID()+"', '"+dpt.getName()+"', '"+dpt.getDescription()+"', '"+dpt.getDateCreated()+"', '"+dpt.getDateModified()+"')";
			Database db = new Database();
			db.stmtGetSave(sql);
			System.out.println("\nDepartment saved :"+dpt.getName()+" ...");
			availableDpts.add(dpt.getDepartmentID());
		}
		return availableDpts;
	}
	
}
