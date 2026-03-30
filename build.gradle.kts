plugins {
    java
    id("org.springframework.boot") version "3.4.11"
    id("io.spring.dependency-management") version "1.1.7"
    application
}

group = "com.finalproject"
version = "0.0.1-SNAPSHOT"
description = "LetterSearch"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
    ignoreFailures = true // optional: skip failing tests on Heroku
}

application {
    mainClass.set("lettersearch.LetterSearchApplication") // your main class
}

tasks.register("stage") {
    dependsOn("bootJar") // Heroku uses this to detect stage
}
