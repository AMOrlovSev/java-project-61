plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

//application {
//    // Входная точка
//    mainClass.set("hexlet.code.App")
//}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
