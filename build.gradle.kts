plugins {
    id("java")
    id("idea")
}

group = "io.github.wxrlock.item.builders"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.elmakers.com/repository/")
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}