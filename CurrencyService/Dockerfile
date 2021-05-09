FROM openjdk:8-jdk-alpine
EXPOSE 8089
RUN mkdir currencyService
COPY target/currency-0.0.1-SNAPSHOT.jar /currencyService
WORKDIR /currencyService
CMD ["java", "-jar", "currency-0.0.1-SNAPSHOT.jar"]
