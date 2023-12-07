plugins {
    id("java")
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "br.com.dev.ednascimento"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Implementation
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("com.sun.mail:javax.mail:1.6.2")

    // Test
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.assertj:assertj-core:3.21.0")
}

tasks.test {
    useJUnitPlatform()
}