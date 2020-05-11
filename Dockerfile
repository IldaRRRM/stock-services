FROM maven:3.6.3-jdk-11 AS build
ENV PROJECT_DIR=/app
RUN mkdir $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY pom.xml $PROJECT_DIR
COPY achive $PROJECT_DIR/achive
COPY auth $PROJECT_DIR/auth

RUN mvn -e -B clean install -DskipTests

ADD auth/auth-impl/target/auth-impl-1.0.0-SNAPSHOT.jar $PROJECT_DIR/auth/auth-impl/target/

VOLUME /app/auth/auth-impl/target

ENTRYPOINT ["echo", "everything is good"]