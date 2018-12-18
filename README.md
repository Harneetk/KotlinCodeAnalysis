# KotlinCodeAnalysis
detekt 

Detekt is a open source and static code analyze tool for the Kotlin programming language. It operates on the abstract syntax tree provided by the Kotlin compiler.

Features
* Code smell analysis for your Kotlin projects
* Complexity report based on logical lines of code, McCabe complexity and amount of code smells
* Highly configurable
* Suppress findings with Kotlin's @Suppress and Java's @SuppressWarnings annotations
* Specify code smell thresholds to break your build
* Code Smell baseline and ignore lists for legacy projects
* Gradle plugin for code analysis via Gradle builds
* Gradle tasks to use local IntelliJ distribution for formatting and inspecting Kotlin code
* SonarQube integration
* Extensible by own rule sets, FileProcessListener's and OutputReport's
* IntelliJ integration

# There are two ways of implementing  Detekt. 
1. With Gradle
2. Using detekt Plugin

# WAY 1 : 
Start with Gradle

 Pre-requisites:
 - Gradle (4.10.2 right now) in the gradle-wrapper.properties file.

Implementation
1 : Add following configuration in your root build.gradle.
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    ext.kotlin_version = '1.3.11'
    repositories {
    google()
    jcenter()
    }
    dependencies {
    classpath 'com.android.tools.build:gradle:3.2.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "io.gitlab.arturbosch.detekt:detekt-formatting:1.0.0.RC8"
           }
           }
           plugins {
           id "io.gitlab.arturbosch.detekt" version "1.0.0.RC8"
           }
           detekt {
           version = "1.0.0.RC8"
           profile("main") {
           input = "$projectDir/app/src/main/java"
           config = "$projectDir/default-detekt-config.yml"
           output = "${project.buildDir}/reports/detekt"
           filters = ".*test.*,.*/resources/.*,.*/tmp/.*"
           }
           }
           allprojects {
           repositories {
           google()
           jcenter()
           }
           }
           task clean(type: Delete) {
           delete rootProject.buildDir
           }

The field # input indicates the directory where your Kotlin files reside.
The field # config indicates the location of the rules files from the second step.
The filed # filters indicate which files should be skipped during the scan, for instance, test files.
The field # output indicates where we want to store the report file that contains all the issues that Detekt founds.
The field # parallel is an optimisation for performance if your project contains more than 200 files.

2 : If you want to change the default behaviour of detekt rules, first generate yourself a detekt configuration file and apply your changes:
./gradlew detektGenerateConfig command

3 : Now we can run 
./gradlew detektCheck

#Reports

# WAY 2 : 
With Detekt Plugin

1/ Install Detekt Plugin from Android Preferences

2/ Enabling the plugin
Once you have installed the plugin, navigate to Settings/Preferences -> Tools -> Detekt. From there you will see the following screen. Warnings will be displayed in each file.

More rule sets can be added/customized

Reference Links :
1. https://arturbosch.github.io/detekt/index.html
2. https://arturbosch.github.io/detekt/complexity.html
3. https://github.com/arturbosch/sonar-kotlin
