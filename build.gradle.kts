
repositories {
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(gradleKotlinDsl())
//    implementation(kotlin("stdlib-jdk8"))
//    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    testImplementation("org.testng:testng:7.6.0")  {
        exclude("junit", "junit")
        testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.24")
    }
}

gradlePlugin {
    plugins {
        create("link-checker") {
            id = "link-checker"
            implementationClass = "com.github.christophpickl.linkchecker.LinkChecker"
        }
    }
}

// tests
// DependencyUpdatesTask
