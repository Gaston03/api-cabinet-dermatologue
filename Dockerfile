#
# Build stage
#
# FROM maven:3-adoptopenjdk AS build
# WORKDIR /app
# COPY . /app/
# RUN mvn clean package

#
# Package stage
#
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]