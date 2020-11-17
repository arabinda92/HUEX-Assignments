FROM gradle:6.5.0-jdk11 as builder
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} HUEX_assignments.jar
ENTRYPOINT ["java","-jar","/HUEX_assignments.jar"]