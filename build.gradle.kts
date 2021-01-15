import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.ben-manes.versions") version "0.36.0"
    kotlin("jvm") version "1.4.30-M1"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        jcenter()
        google()
        maven(url = "https://jitpack.io/")
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))

        testImplementation(platform("org.junit:junit-bom:5.7.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")

        testImplementation(group = "org.mockito", name = "mockito-core", version = "3.7.0")
        testImplementation(group = "org.mockito", name = "mockito-junit-jupiter", version = "3.7.0")

        testImplementation(group = "org.assertj", name = "assertj-core", version = "3.18.1")
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}