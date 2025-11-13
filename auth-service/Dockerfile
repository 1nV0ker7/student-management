# Use the base Image from the repo which uses JDK 21
FROM maven:3.9.9-eclipse-temurin-21 AS builder
# Specify a working directory in a container
WORKDIR /app
# Add dependencies from the pom.xml file to the /app folder
COPY pom.xml .
# Cache the dependencies if there are no changes everytime the container is ran
RUN mvn dependency:go-offline -B
# Copy source code to the image
COPY src ./src
# Package everything into a JAR
RUN mvn clean package

# Instructions to RUN this built code
FROM eclipse-temurin:21-jdk-alpine AS runner
#
WORKDIR /app

COPY --from=builder ./app/target/auth-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4005

ENTRYPOINT ["java", "-jar", "app.jar"]

