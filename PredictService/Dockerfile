FROM openjdk:alpine
EXPOSE 8090
RUN mkdir predictService
COPY target/predict-0.0.1-SNAPSHOT.jar /predictService
WORKDIR /predictService
CMD ["java", "-jar", "predict-0.0.1-SNAPSHOT.jar"]
