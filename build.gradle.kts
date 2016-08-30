/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tsuharesu Luciel
 */
buildscript {
    repositories {
        gradleScriptKotlin()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

apply {
    plugin("kotlin")
    plugin<MavenPlugin>()
}

repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib"))
    compile(kotlinModule("test"))

    testCompile("junit:junit:4.12")
}

// ------ MAVEN -----
group = "com.github.tsuharesu"
version = "0.6"