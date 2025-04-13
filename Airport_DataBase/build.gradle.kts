plugins {
    kotlin("jvm") version "1.9.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.oracle.database.jdbc:ojdbc11:21.11.0.0")
    implementation("ch.qos.logback:logback-classic:1.4.11")
}

application {
    mainClass.set("MainKt")
}