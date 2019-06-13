# Gluon Client Samples

Java and JavaFX samples to run with OpenJDK 11, GraalVM and the Gluon Client plugins for [Maven](https://github.com/gluonhq/client-maven-plugin/) and [Gradle](https://github.com/gluonhq/client-gradle-plugin/).

Set `JAVA_HOME` pointing to Java 11.

**Note**: For now, only Mac OS X and iOS are supported. Therefore, a Mac with MacOS X 10.13.2 or superior, and Xcode 9.2 or superior, available from the Mac App Store, are required.

Check the [documentation](https://docs.gluonhq.com/client) for more details about the plugins and running the following samples.

## Gradle

### HelloWorld, HelloFX, HelloFXML samples

The following tasks apply to Mac OS X, iOS simulator and iOS devices. See each sample for configuration details.

To compile and link:

    ./gradlew clean build nativeCompile nativeLink
    
or

    ./gradlew clean nativeBuild

To run:
    
    ./gradlew nativeRun

## Maven

### HelloWorld, HelloFX, HelloFXML samples

The following tasks apply to Mac OS X, iOS simulator and iOS devices. See each sample for configuration details.

To compile and link:

    mvn clean client:compile client:link
    
or

    mvn clean client:build

To run:

    mvn client:run
