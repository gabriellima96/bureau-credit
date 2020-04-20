FROM adoptopenjdk/openjdk11:alpine as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

COPY bureau-credit-gateway-entrypoint.sh /app/bureau-credit-gateway-entrypoint.sh
RUN chmod +x /app/bureau-credit-gateway-entrypoint.sh
