dependencies {
    api(project(":Model"))

    implementation("io.github.openfeign:feign-core:11.0")
    implementation("io.github.openfeign:feign-jackson:11.0")
    implementation("io.github.openfeign:feign-httpclient:11.0")
    implementation("io.github.openfeign:feign-reactive-wrappers:11.0")
    implementation("io.github.openfeign:feign-slf4j:11.0")
    implementation("io.github.openfeign:feign-jaxrs2:11.0")
    testImplementation("io.github.openfeign:feign-mock:11.0")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")

    implementation("org.glassfish.jersey.core:jersey-client:2.33")
    implementation("org.glassfish.jersey.inject:jersey-hk2:2.33")
}