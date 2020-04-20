#!/bin/sh
while ! nc -z config 8888 ; do
    echo "Esperando o microservice bureau-credit-config iniciar"
    sleep 3
done
while ! nc -z server 8761 ; do
    echo "Esperando o microservice bureau-credit-server iniciar"
    sleep 3
done

java -jar /app/target/bureau-credit-base-b-0.0.1-SNAPSHOT.jar
