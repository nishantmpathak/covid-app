
FROM openjdk:14
EXPOSE 8080
ADD target/coronavirus-tracker-0.0.1-SNAPSHOT.jar coronavirus-tracker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/coronavirus-tracker-0.0.1-SNAPSHOT.jar"]
