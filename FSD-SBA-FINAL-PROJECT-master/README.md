# FSD-SBA-FINAL-PROJECT:Project Manager
<h2>Associate Name:Upasak Ganguly Cognizant ID:555194</h2>
<h2>Please refer to the "docs" folder which contain the following sub-folders</h2>
<ol>
	<li>Application_Screenshots : This contains application screenshots of all screens.</li>
	<li>MySQL Script : This contains table design and the DDL commands </li>
	<li>Emma_Coverage_Reports : This contains the junit test cases, emma code coverage report and screenshots.</li>
	<li>Load_Testing_Reports : This contains the screenshots of the jmeter execution on the rest end-point designed</li>
	<li>Docker : This contains the docker commands and screenshots of the project docker image creation and execution.</li>
	<li>Jenkins : This contains the screenshots of the jenkins pipeline creation,execution and the build report</li>
</ol>
<h3>Following are the projects which comprise of the full-stack project:Project Manager</h3>
<ol>
   <li><h4>"projectmanager-server" - The spring boot project using Rest API,hibernate etc running in the back-end </h4></li>
   <li><h4>"projectmanager-web" - The angular project using HTML5,CS3,Bootstrap4 running in the front end</h4></li>
</ol>
<h3>Instructions for cloud lab VM:</h3>
<ul>
	<li>The entire project code base is present in the path C:\Users\Admin\git\FSD-SBA-FINAL-PROJECT\ within the cloud lab VM.</li>
	<li>8.	The full stack projectmanager jar file(post-build) is present in the path C:\Users\Admin\git\FSD-SBA-FINAL-PROJECT\projectmanager-server\target.</li>
	<li>In order to run the application, open a command prompt(cmd.exe),navigate to the jar path mentioned above and run the command:java -jar jarname</li>
	<li>Open a web browser(google chrome) and use the URL:https://localhost:8082 to access the application</li>
</ul>
<h3>Final Build Commands:</h3>
<ul>
<li>Maven: clean install -e [The UI code is build using "frontend-maven-plugin" and is packed inside the JAR artifacts itself. Refer projectmanager-web pom.xml](Command is mvn clean install)</li>
<li>Docker: package docker:build[spotify "docker-maven-plugin" is used to create image in the remote docker. <dockerHost> configuration : pom.xml of projectmanager-server](Command is mvn package docker:build)</li>
</ul>

<h3>Docker Execution Commands:</h3>
<ul>
<li>docker run -p 8090:8085 projectmanager-image:latest	[This commands runs the to start the application container from the docker image]</li>
<li>docker exec -it <container id> sh	[This commands executes the application container from the docker imageto to check whether the below URL's are working in the curl]</li>
</ul>	

<ul>
<li>The docker command to check whether application loaded correctly: curl http://localhost:8082/test</li>
<li>The docker command to check the services: curl http://localhost:8082/api/tasks</li>
<li>The docker command to display UI Home page: curl http://localhost:8082/index.html</li>
</ul>	

<h3>Local Deployment Commands:</h3>
<ul>
<li>Spring boot in projectmanager-server folder: spring-boot:run</li>
<li>Angular ui in web folder of projectmanager-web: npm install -> npm start</li>
</ul>

<h3>Jenkins:</h3>
<ol>
<li>GitHub Branches to build: */fullstack</li>
<li>Jenkins script Path: projectmanager-server/Jenkinsfile</li>
</ol>

<h3>Notes: </h3>
<ol>
<li>The free hosting public MySQL database jdbc:mysql://sql12.freemysqlhosting.net:3306/dbname is usedto access database layer when deployed in docker (instead of setting mysql in docker).</li>
<li>Please refer to the dockerfile, application screenshot document in the repo folder.</li>
<li>Please refer to the mysql script for the database DDL</li>
<li>Before the maven build, please change the port number in envioronment.prod.ts to change the port number in which the jar is gonna get deployed.</li>
</ol>


