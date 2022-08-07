#!/bin/sh
mvn clean install
if [ "$?" -ne 0 ]; then
    echo "Maven Clean and build Unsuccessful!"
    exit 1
fi
echo "building docker image"
echo "------------------------------------"
docker build -t devops-assignment .

echo "-------------------------------------"
echo "deployment started  with helm"
echo "-------------------------------------"
helm install devops-assignment-helm helm/devops-assignment-helm

echo "deployment completed"
