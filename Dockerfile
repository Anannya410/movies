#
# Build stage
#
FROM maven:3.9.2-eclipse-temurin-20 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM eclipse-temurin:20-jdk
COPY --from=build /target/movies-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
