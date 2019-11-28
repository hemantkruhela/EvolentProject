# EvolentProject

This project is devided into the follwoing two project:
1. contactUI-client
	 it is developed using Angular, bootstrap.
	 to add the bootstrap to the project kindly run the following command from contactUI-client folder.
	 
			npm install bootstrap jquery --save
	 
	 
	 To enable the cors, poxy has set in proxy.config.json
	 this project will kick start from following command:
	 npm start
	 

2. ContactAPI
	for the REST api the context is set as below:
	server.servlet.context-path=/api
	
	Please use the following link to get the list of the contacts:
	http://localhost:8081/api/contacts
	for individual user
	http://localhost:8081/api/contacts/2
	