#FROM --platform=$BUILDPLATFORM gradle:7.3.3-jdk11-alpine AS build
FROM arm64v8/gradle AS build

COPY --chown=gradle:gradle *.kts /build/gradle/src/
WORKDIR /build/gradle/src

RUN gradle clean build --no-daemon > /dev/null 2>&1 || true

COPY --chown=gradle:gradle . /build/gradle/src

RUN gradle clean build --no-daemon


FROM --platform=linux/arm64 mcr.microsoft.com/java/jre:11u13-zulu-alpine

EXPOSE 8080

RUN mkdir /app

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

COPY --from=build /build/gradle/src/build/libs/*.jar /app/spring-boot-app.jar

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-app.jar"]
