FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/waiter-0.0.1-SNAPSHOT.jar beer-waiter.jar
CMD java ${JAVA_OPTS} -jar beer-waiter.jar