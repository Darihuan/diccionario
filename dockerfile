FROM openjdk:11
MAINTAINER darihuan.web
VOLUME /tmp
EXPOSE 8080
ADD target/Diccionario-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]