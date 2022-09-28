FROM openjdk:17
COPY target/dinning_hall-0.0.1-SNAPSHOT.jar dinning_hall.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/dinning_hall.jar"]