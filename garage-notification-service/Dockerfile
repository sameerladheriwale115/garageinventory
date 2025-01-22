FROM amazoncorretto:17-alpine-jdk
MAINTAINER baeldung.com
COPY target/spring-boot-kafka-consumer-example-0.0.1-SNAPSHOT.jar kafka-consumer.jar
ENTRYPOINT ["java","-jar","/kafka-consumer.jar"]