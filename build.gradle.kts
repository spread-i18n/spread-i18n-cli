import org.gradle.jvm.tasks.Jar
plugins {
    kotlin("jvm") version "1.4.21"
}

group = "com.andro.spreadi18ncli"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.andro.spreadi18ncore:spread-i18n-core:1.0-SNAPSHOT")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
    testImplementation("org.assertj:assertj-core:3.22.0")
    testImplementation("io.mockk:mockk:1.10.5")
}


tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "com/andro/spreadi18ncli/Main"
    }
    from(configurations.runtimeClasspath.get().map({ if (it.isDirectory) it else zipTree(it) }))
}

/*
tasks.register("build") {
    dependsOn(gradle.includedBuild("../spread-i18n-core").task(":spread-i18n-core:build"))
}*/