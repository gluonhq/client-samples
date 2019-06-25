# Gluon Client Samples

Java and JavaFX samples to run with OpenJDK 11, GraalVM and the Gluon Client plugins for [Maven](https://github.com/gluonhq/client-maven-plugin/) and [Gradle](https://github.com/gluonhq/client-gradle-plugin/).

**Requirements**

For now, Linux, Mac OS X and iOS platforms are supported.
 
To develop and deploy native applications on Mac or iOS platforms, a Mac with macOS X 10.13.2 or superior, and Xcode 9.2 or superior, available from the Mac App Store, are required.

As well, for now only JDK 11 is supported. Any JDK 11 distribution that doesn't bundle JavaFX is valid, like:

- [OpenJDK 11.0.2](https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz)
- [AdoptOpenJDK 11.0.3](https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7/OpenJDK11U-jdk_x64_mac_hotspot_11.0.3_7.tar.gz) 

Once downloaded and installed, don't forget to set `JAVA_HOME` pointing to that JDK.

**Documentation**

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
