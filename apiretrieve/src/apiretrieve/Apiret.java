package apiretrieve;

import java.util.List;

public class Apiret {
	
	public static void main(String[] args) throws Exception {
		System.out.println("\n SYSTEM EXECUTION STARTING ......\n");
		Database db = new Database();
		db.databaseInit();
		System.out.println("\n Database initialization Complete");
		Department dept = new Department();
		User usr = new User();
		List<Integer> dpts = dept.test();
		for (int i: dpts)
		{
			usr.getUsers(i);
		}
		
		System.out.println("\n System execution Complete");
	}
}
