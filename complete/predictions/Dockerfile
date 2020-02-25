FROM openjdk:8
RUN mkdir predictions
COPY target/predictions-0.1.0.jar /predictions
RUN ls
WORKDIR /predictions
CMD ["java", "-jar", "predictions-0.1.0.jar"]
