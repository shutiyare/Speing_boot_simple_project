#!/usr/bash

echo "################### KAMIL SERVER ###################"
#cd backend

echo "cleaning backend"
mvn clean

echo "--------------- packaging app --------------"
mvn package -Dmaven.test.skip=true

echo "running backend of Demo Application"
java -jar ./target/demo-0.0.1-SNAPSHOT.jar