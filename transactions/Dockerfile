FROM adoptopenjdk/openjdk11:alpine
ARG JAR_FILE=/Desafio_4/orange-talents-01-template-transacao/transactions/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]