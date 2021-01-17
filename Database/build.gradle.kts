dependencies {
    api(project(":Model"))

    implementation("org.jdbi:jdbi3-postgres:3.18.0")
    implementation("org.postgresql:postgresql:42.2.18")
}