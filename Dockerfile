## Example 1. Dockerfile:
#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/IoTEnergyMeter-1.0.0.jar
#COPY ${JAR_FILE} IoTEnergyMeter-1.0.0.jar
#ENTRYPOINT ["java","-jar","/IoTEnergyMeter-1.0.0.jar"]

## Example 2. Dockerfile
#FROM openjdk:8-jdk-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#ARG JAR_FILE=target/IoTEnergyMeter-1.0.0.jar
#COPY ${JAR_FILE} IoTEnergyMeter-1.0.0.jar
#ENTRYPOINT ["java","-jar","/IoTEnergyMeter-1.0.0.jar"]

## Default Example. Dockerfile
FROM openjdk:8-jre-alpine
EXPOSE 8081
WORKDIR /api
ARG JAR_FILE=target/IoTEnergyMeter-1.0.0.jar
COPY ${JAR_FILE} IoTEnergyMeter-1.0.0.jar
ENTRYPOINT [ "java", "-jar", "IoTEnergyMeter-1.0.0.jar" ]
