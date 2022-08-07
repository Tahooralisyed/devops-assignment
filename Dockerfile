#Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/devops-assignment-1.0.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
