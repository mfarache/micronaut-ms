FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/billing-0.0.1-SNAPSHOT.jar beer-billing.jar
CMD java ${JAVA_OPTS} -jar beer-billing.jar