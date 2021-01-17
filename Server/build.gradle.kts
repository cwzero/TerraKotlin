plugins {
    id("com.bmuschko.docker-java-application") version "6.7.0"
    application
}

dependencies {
    api(project(":Common"))
    api(project(":Database"))
    api(project(":TwitchClient"))

    implementation("io.dropwizard:dropwizard-core:2.0.18")
    implementation("io.dropwizard:dropwizard-db:2.0.18")
    implementation("io.dropwizard:dropwizard-jdbi3:2.0.18")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
}

docker {
    javaApplication {
        baseImage.set("adoptopenjdk/openjdk14:debian")
        images.set(listOf("liquidforte/terra/server:latest"))
    }
}

tasks.create<Copy>("copyConfig") {
    dependsOn(":Server:dockerSyncBuildContext")
    from(file("config.yml"))
    into(file("$buildDir/docker"))
}

tasks.named<com.bmuschko.gradle.docker.tasks.image.Dockerfile>("dockerCreateDockerfile") {
    dependsOn(":Server:copyConfig")
    copyFile("config.yml", "/app/config.yml")
}

application {
    mainClass.set("com.liquidforte.terra.server.MainKt")
}