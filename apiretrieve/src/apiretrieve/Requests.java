package apiretrieve;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class Requests {

   @SuppressWarnings("deprecation")
public String postReq(String url, String Action, String body) throws Exception {
	   String data = null;
       String strURL = url;
       // Get SOAP action
       String strSoapAction = Action;
       PostMethod post = new PostMethod(strURL);
       post.setRequestBody(body);
       // consult documentation for your web service
       post.setRequestHeader("SOAPAction", strSoapAction);
       // Get HTTP client
       HttpClient httpclient = new HttpClient();
       // Execute request
       try {
           int result = httpclient.executeMethod(post);
           System.out.println("\nGetting data from soap api ...");
           // Display status code
           System.out.println("\nResponse status code: " + result);
           data = post.getResponseBodyAsString();
           System.out.println("\nData retrieval is complete ...");
       } finally {
           // Release current connection to the connection pool once you are done
           post.releaseConnection();
       }
       return data;
   }
}