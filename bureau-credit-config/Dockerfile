FROM adoptopenjdk/openjdk11:alpine as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

ENTRYPOINT ["java","-jar","/app/target/bureau-credit-config-0.0.1-SNAPSHOT.jar"]

EXPOSE 8888