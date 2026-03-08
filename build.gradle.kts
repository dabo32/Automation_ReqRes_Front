plugins {
    id("java")
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.2.8"
}

group = "com.saucedemo.automation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val serenityVersion = "4.2.8"
val cucumberVersion = "7.20.1"
val junitVersion = "5.11.3"
val restAssuredVersion = "5.5.0"
val lombokVersion = "1.18.34"

dependencies {
    //Serenity BDD & Screenplay
    testImplementation("net.serenity-bdd:serenity-core:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-junit5:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityVersion")
    //Cucumber
    testImplementation("net.serenity-bdd:serenity-cucumber:$serenityVersion")
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    //JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    //Lombok
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("file.encoding", "UTF-8")
}

serenity {
    reports = listOf("html")
}