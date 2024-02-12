FROM openjdk:latest
COPY ./target/countries-1.0.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "countries-1.0.0-jar-with-dependencies.jar"]