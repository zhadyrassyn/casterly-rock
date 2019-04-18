FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR '/app'
COPY build/libs/*.jar /app/casterly-rock-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/casterly-rock-api.jar"]



