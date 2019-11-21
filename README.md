# Gluon Client Samples

Java and JavaFX samples to run with GraalVM and the Gluon Client plugins for [Maven](https://github.com/gluonhq/client-maven-plugin/).

## Requirements

For now only Linux and Mac OS X are supported.

* Install GraalVM 19.3.0 or later if you haven’t already. 
 * Download the appropriate Community Edition archive from [https://github.com/oracle/graal/releases](https://github.com/oracle/graal/releases), and unpack it like you would any other JDK.
* Configure the runtime environment. Set GRAALVM_HOME environment variable to the GraalVM installation directory, for example:

    `export GRAALVM_HOME=/path-to-your-graalvm`

    On macOS, point the variable to the Home sub-directory:

    `export GRAALVM_HOME=/path-to-your-graalvm/Contents/Home`

* Install the native-image tool using gu install:

   `${GRAALVM_HOME}/bin/gu install native-image`   

* Optionally also set `JAVA_HOME` pointing to your GraalVM installation.

    `export JAVA_HOME=$GRAALVM_HOME`


## Build using Maven

### HelloWorld, HelloFX, HelloFXML and HelloGluon samples

The following tasks apply to Linux and Mac OS X. See each sample for configuration details.

To compile and link:

    mvn clean client:compile client:link
    
or

    mvn clean client:build

To run:

    mvn client:run

or simply run the native binary found in target/
