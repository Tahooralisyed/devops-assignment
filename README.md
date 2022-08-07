# Spring Boot Devops Assignment API

This is test application which will create, show an delete user records. this application uses in memory h2 database.

## to build create docker image and deploy pods in Kubernetes using heml

step1: clone repo https://github.com/Tahooralisyed/devops-assignment.git

step2: go to repo
eg cd devops-assignment 

step3: give permission to build.sh file
eg. chmod +x build.sh

step4: execute the script
eg. ./build.sh (note this will compile,build,create docker image and deploy application to kubernets using helm)

step5: add entry in /etc/hosts
eg. 192.168.99.100 devops-assignment.in 

## To view the prometheus metrics
http://devops-assignment.in/actuator/prometheus

## To view all records
http://devops-assignment.in/show

## To create the new records
http://devops-assignment.in/create?firstName=test&&lastName=test

## To delete the record
http://devops-assignment.in/delete?id=number

