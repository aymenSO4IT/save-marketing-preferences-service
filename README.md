
#The application
The application is a springboot application and built on java 8!
To start the application all you need is maven and java. 
You just need to compile it with maven.

#Feature
You are able to save and update marketing preferences.

#Docker
If you would like to user docker please do the following:
Build docker image for service: 
1) docker build -t save-marketing-preferences-service/spring-boot-docker .
2) docker-compose up
After that you should have both mongodb and the spring boot service running.

#Local
mvn spring-boot:run -Dspring-boot.run.profiles=local
(Dont forget to start mongodb on your local computer)

#API
You can see all the API:s and documentation: http://localhost:8080/swagger-ui/#/