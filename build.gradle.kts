
repositories {
    mavenCentral()
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

group = "com.github.christophpickl"
version = "1.0"

dependencies {
    compileOnly(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    testImplementation("org.testng:testng:${Versions.testng}")  {
        exclude("junit", "junit")
    }
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:${Versions.assertk}")
}

gradlePlugin {
    plugins {
        create("linkCheckerPlugin") {
            id = "com.github.christophpickl.link-checker"
            implementationClass = "com.github.christophpickl.linkchecker.LinkChecker"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.christophpickl"
            artifactId = "link-checker"
            version = "1.0"

            from(components["java"])
        }
    }
}
