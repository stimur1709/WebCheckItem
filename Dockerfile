FROM eclipse-temurin:17-jdk-jammy
FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
CMD ["java", "-jar", "target/WebCheckItems-1.0.jar"]
