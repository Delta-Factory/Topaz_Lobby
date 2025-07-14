plugins {
    id("java")
    kotlin("jvm") version "2.1.10"
    id("com.gradleup.shadow") version("8.3.0")
}

val minestomVersion: String by project

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.gradleup.shadow")

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    dependencies {
        compileOnly("net.minestom:minestom-snapshots:$minestomVersion")
        compileOnly("delta.cion.api:topaz_api:0.0.0-DEV")
    }

    repositories {
        mavenCentral()
    }
}