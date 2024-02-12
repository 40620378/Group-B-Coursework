FROM openjdk:latest
COPY ./target/countries-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "countries-0.1.0.2-jar-with-dependencies.jar"]