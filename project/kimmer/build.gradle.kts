plugins {
    kotlin("jvm") version "1.6.10"
}

group = "org.babyfish.graphql.provider"
version = "0.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.6.0")
}