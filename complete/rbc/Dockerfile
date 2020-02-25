FROM openjdk:8
RUN mkdir rbc
COPY target/rbc-0.1.0.jar /rbc
WORKDIR /rbc
CMD ["java", "-jar", "rbc-0.1.0.jar"]
