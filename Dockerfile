FROM openjdk:17-jdk-alpine
MAINTAINER fdeible@plslogistics.com
COPY ./target/sandbox-0.0.1-SNAPSHOT.jar sandbox.jar
ENTRYPOINT ["java", "-jar", "/sandbox.jar" ]
