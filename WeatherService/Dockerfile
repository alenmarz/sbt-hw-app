FROM openjdk:alpine
EXPOSE 8088
RUN mkdir weatherService
COPY target/weather-0.0.1-SNAPSHOT.jar /weatherService
WORKDIR /weatherService
CMD ["java", "-jar", "weather-0.0.1-SNAPSHOT.jar"]
