#Start with a base image containing Java runtime
#FROM openjdk:8-alpine AS multisatge

#RUN mkdir /application
#COPY x4e-backend-*.jar /application/x4e-backend.jar
#RUN adduser -D myuser && chown -R myuser /application
#CMD ["java", "-Xmx512m", "-jar", "/application/x4e-backend.jar"]
#EXPOSE 8080

#FROM alpine:latest
#COPY --from=multisatge /application ./
#RUN adduser -D myuser && chown -R myuser /application
#CMD ["java", "-Xmx512m", "-jar", "/application/x4e-backend.jar"]
#EXPOSE 8080
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/devops-assignment-1.0.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
