#get jdk base image, allows running of java applications
FROM openjdk:latest
#copy generated jar into container file system
COPY ./target/countries-3.0.0-jar-with-dependencies.jar /tmp
#set working directory of container
WORKDIR /tmp
#runs java program on start of container
ENTRYPOINT ["java", "-jar", "countries-3.0.0-jar-with-dependencies.jar"]