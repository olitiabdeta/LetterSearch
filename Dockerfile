FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY . .

RUN ./gradlew bootJar --no-daemon -x test \
  -Dorg.gradle.jvmargs="-Xmx512m -XX:MaxMetaspaceSize=256m"

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]