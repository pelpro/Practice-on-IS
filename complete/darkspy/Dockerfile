FROM openjdk:8
RUN mkdir darkspy
COPY target/darkspy-0.1.0.jar /darkspy
WORKDIR /darkspy
CMD ["java", "-jar", "darkspy-0.1.0.jar"]
