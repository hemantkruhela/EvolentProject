# EvolentProject
#Contact me at 9868800007 if any issue to run the application:
This project is devided into the follwoing two project:
1. For UI is contactUI-client
2. For Back end is contactsInfo



<-------------------------Rest Application ---------------------------------------------->

contactsInfo in the eclipse as Maven project.
just run as java application.
it will start running on port 8081:

for the REST api the context is set as below:
	Please use the following link to get the list of the contacts:
	http://localhost:8081/api/contacts
	for individual user
	http://localhost:8081/api/contacts/2





<---------------------------UI Application ----------------------------------------------->
contactUI-client in the visual studio to check the code. 
otherwise it can be run from the command prompt.




The prerequisite to run the ui application, system must have  nodejs, npm,angular.

before start the application, following commands need to be run.
	 To add the bootstrap to the project.
	 Goto -> contactUI-client folder.
	 
			npm install bootstrap jquery --save
	 
	 
	 To enable the cors, poxy has set in proxy.config.json
	 this project will kick start from following command:
	 
	 
			npm start
	 

Once the UI applicattion started, it can be accessible at the following URL:
			
			http://localhost:4200
			
The login screen will be populated:
	Enter the following crediatials:
	userName -> contactInfo
	password-> TestPassword
	
Once, application get logged in, it will open the exiting list of the contacts.
form left most upside menu, new contact can be add.
after add/ update the contact, list will not refresh, it need to refresh again.(it's an known defect :) ).
other options are in list with each contact, which can be perfomed by respected buttons.


2. ContactAPI
	
	