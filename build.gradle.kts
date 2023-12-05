plugins {
    id("java")
}

group = "br.com.dev.ednascimento"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.assertj:assertj-core:3.21.0")
}

tasks.test {
    useJUnitPlatform()
}