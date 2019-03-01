FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar library-management.jar
ENTRYPOINT ["java","-jar","/library-management.jar"]