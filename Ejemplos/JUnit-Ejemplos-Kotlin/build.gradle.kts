import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
}

group = "es.joseluisgs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
     testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/com.diogonunes/JColor
    // implementation("com.diogonunes:JColor:5.5.1")
    // testImplementation(platform("org.junit:junit-bom:5.9.1"))
    // testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}