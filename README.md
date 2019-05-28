# Gluon Client Samples

Java and JavaFX samples to run with OpenJDK 11, GraalVM and the Gluon Client plugins for [Maven](https://github.com/gluonhq/client-maven-plugin/) and [Gradle](https://github.com/gluonhq/client-gradle-plugin/).

Set `JAVA_HOME` pointing to Java 11.

**Note**: For now, only Mac OS X is supported.

## Gradle

### HelloWorld, HelloFX, HelloFXML samples

To compile and link:

    ./gradlew clean build nativeCompile nativeLink
    
or

    ./gradlew clean nativeBuild

To run:
    
    ./gradlew nativeRun

## Maven

### HelloWorld, HelloFX, HelloFXML samples

To compile and link:

    mvn clean client:compile client:link
    
or

    mvn clean client:build

To run:

    mvn client:run
