package apiretrieve;
// imports to extract the xml from the document
//import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
// end of imports
//custom classes
import apiretrieve.Department;
import apiretrieve.Database;
import apiretrieve.User;


public class Apiret {
	
	private ArrayList<Integer>  getDepts()
	{
		String body = "<soapenv:Envelope xmlns:soapenv=\""
				+ "http://schemas.xmlsoap.org/soap/envelope/\""
				+ " xmlns:web=\"http://WebService/\""
				+ "><soapenv:Header/><soapenv:Body> "
				+ "<web:fetchDepartments/></soapenv:Body>\n" + 
				"</soapenv:Envelope>";
		Requests http = new Requests();
		String url = "https://beep2.cellulant.com:9001/assessments/Company";
		ArrayList<Integer> num = new ArrayList<Integer>();
		try {
			String response = http.postReq(url, "",body);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	        line below parse the function from requests
	        Document doc = dBuilder.parse(new InputSource(new StringReader(response)));
	        doc.getDocumentElement().normalize();
	        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        NodeList nList = doc.getElementsByTagName("return");
	        System.out.println("\nData Extraction and Saving of Department data Commence ...");
	        for (int temp = 0; temp < nList.getLength(); temp++) { 
		           Node nNode = nList.item(temp);
		           Department dept = new Department();
		           
		           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		              Element eElement = (Element) nNode;
		              dept.setId(Integer.parseInt(eElement.getElementsByTagName("departmentID").item(0).getTextContent()));
		              dept.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
		              dept.setModified(eElement.getElementsByTagName("dateModified").item(0).getTextContent());
		              dept.setCreated(eElement.getElementsByTagName("dateCreated").item(0).getTextContent());
		              dept.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
		              dept.setDeptDb();
		              num.add(dept.getId());

		           }
			}
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	private int getUsers(ArrayList<Integer> dpts)
	{
		for (int i = 0; i < dpts.toArray().length; i++) {
			String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebService/\">"
					+ "<soapenv:Header/>"
					+ "<soapenv:Body>"
					+ "<web:fetchStaff><departmentID>"+dpts.get(i)+"</departmentID>"
							+ "</web:fetchStaff>"
							+ "</soapenv:Body>"
							+ "</soapenv:Envelope>";
			Requests http = new Requests();
			String url = "https://beep2.cellulant.com:9001/assessments/Company";
			try {
				String response = http.postReq(url, "",body);
		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//		        line below parse the function from requests
		        Document doc = dBuilder.parse(new InputSource(new StringReader(response)));
		        doc.getDocumentElement().normalize();
		        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		        NodeList nList = doc.getElementsByTagName("return");
		        System.out.println("\nData Extraction and Saving of User data Commence ...");
		        for (int temp = 0; temp < nList.getLength(); temp++) { 
			           Node nNode = nList.item(temp);
			           User usr = new User();
			           
			           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			              Element eElement = (Element) nNode;
			              usr.setID(Integer.parseInt(eElement.getElementsByTagName("staffID").item(0).getTextContent()));
			              usr.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
			              usr.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
			              usr.setEmail(eElement.getElementsByTagName("emailAddress").item(0).getTextContent());
			              usr.setDateCreated(eElement.getElementsByTagName("dateCreated").item(0).getTextContent());
			              usr.setModified(eElement.getElementsByTagName("dateModified").item(0).getTextContent());
			              usr.setDeptID(Integer.parseInt(eElement.getElementsByTagName("departmentID").item(0).getTextContent()));
			              usr.saveUserDb(usr);	              
			           }
			        }

				// TODO: handle exception
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
	//	initiate the database
		System.out.println("\nSYSTEM EXECUTION STARTING ......\n");
		Database db = new Database();
		db.databaseInit();
		Apiret apiroot = new Apiret();
		ArrayList<Integer> dpts= apiroot.getDepts();
		apiroot.getUsers(dpts);
		System.out.println("\nSYSTEM EXECUTION END ......\n");

        
	}
}
