FROM openjdk:8-jdk-alpine
ADD target/assignment3.jar assignment3.jar
ENTRYPOINT ["java", "-jar", "assignment3.jar"]