FROM openjdk:11
WORKDIR /usr/src/app
COPY . .
RUN sh gradlew build
CMD ["java", "-jar", "./build/libs/jwebcrawler-0.0.1-SNAPSHOT.jar"]