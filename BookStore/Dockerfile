FROM maven:3.6.3-jdk-11 AS build
COPY /BookStore/src /home/app/src
COPY /BookStore/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
FROM openjdk:11
COPY --from=build /home/app/target/BookStore-0.0.1-SNAPSHOT.jar /usr/src/myapp/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/myapp/demo.jar"]