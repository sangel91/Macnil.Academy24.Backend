FROM openjdk:11-jdk AS dev
WORKDIR /home/academy
# Istall environment dependencies
RUN apt update && apt install git && apt install dos2unix
RUN apt install make
COPY ./.mvn ./.mvn
COPY ./mvnw ./pom.xml ./
RUN dos2unix ./mvnw
RUN ./mvnw dependency:go-offline -B

FROM openjdk:11-jdk AS build
WORKDIR /home/academy
RUN apt update && apt install dos2unix
# Install dependencies
COPY ./.mvn ./.mvn
COPY ./mvnw ./pom.xml ./
RUN dos2unix ./mvnw
RUN ./mvnw dependency:go-offline -B
# Package
COPY ./src ./src
RUN ./mvnw package -Dmaven.test.skip=true

FROM openjdk:11-jdk AS production
WORKDIR /home/academy
COPY --from=build /home/gtfleet/target ./
CMD ["java","-jar","./academy-0.0.1-SNAPSHOT.jar"]
