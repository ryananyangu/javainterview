SOAP API RETRIEVE
JAVA VERSION USED : 1.8
EXTERNAL LIBRARIES:
	+ /apiretrieve/libs/commons-codec-1.11.jar
	+ /apiretrieve/libs/commons-logging-1.2.jar
	+ /apiretrieve/libs/http-core-4.1.jar
	+ /apiretrieve/libs/org.apache.commons.httpclient.jar
	+ /apiretrieve/libs/sqlite-jdbc-3.23.1.jar
CLASSES
	+ Database => This handles all database initialization, Schema setup, Creation and Retrieval of information from the db
	+ Department => This is for setting up the department and operations associated with it
	+ User => Setting up the user and operations associated with it
	+ Requests => Handling the Soap requests to the web service 
	+ Apiret => this is the main class for execution
RUNNING APPLICATION:
	+ The executable version of the application is on the root folder 
	+ Name appexec.jar
	
RUNNING THE APPLICATION MAVEN:
	+ mvn exec:java -Dexec.mainClass="apiretrieve.Apiret"
possible maven issue solution
	- find ~/.m2  -name "*.lastUpdated" -exec grep -q "Could not transfer" {} \; -print -exec rm {} \;