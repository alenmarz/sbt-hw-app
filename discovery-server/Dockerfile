FROM openjdk:alpine
EXPOSE 8761
RUN mkdir eurekaServer
COPY target/discovery-server-0.0.1-SNAPSHOT.jar /eurekaServer
WORKDIR /eurekaServer
CMD ["java", "-jar", "discovery-server-0.0.1-SNAPSHOT.jar"]
