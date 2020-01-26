# Gluon Client Samples

Java and JavaFX samples to run with GraalVM and the Gluon Client plugins for [Maven](https://github.com/gluonhq/client-maven-plugin/).

For now only Linux, Mac OS X and iOS platforms are supported. 

## Building and running the samples on Linux and Mac OS X

### Requirements

* Install the Java 11 based GraalVM 19.3.0: download the appropriate Community Edition archive from [https://github.com/oracle/graal/releases](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-19.3.0), and unpack it like you would any other JDK.

* Configure the runtime environment. Set GRAALVM_HOME environment variable to the GraalVM installation directory.

For example:

    export GRAALVM_HOME=/path-to-your-graalvm

On macOS, point the variable to the Home sub-directory:

    export GRAALVM_HOME=/path-to-your-graalvm/Contents/Home

*  Set JAVA_HOME to point to the GraalVM installation directory.

For example:

    export JAVA_HOME=$GRAALVM_HOME

* Install the native-image tool.

Using `gu install`:
    
    ${GRAALVM_HOME}/bin/gu install native-image


### Build using Maven

#### HelloWorld, HelloFX, HelloFXML and HelloGluon samples

The following goals apply to Linux and Mac OS X.

To build the native image:

    mvn clean client:build

To run:

    mvn client:run

or simply run the native executable found in target/client



## Building and running the samples on iOS

### Requirements

* Download this version of Graal VM: https://download2.gluonhq.com/substrate/graalvm/graalvm-svm-darwin-20.0.0-ea+20.zip and unpack it like you would any other JDK. (e.g. in `/opt`)

* Configure the runtime environment. Set `GRAALVM_HOME` environment variable to the GraalVM installation directory.

For example:

    export GRAALVM_HOME=/opt/graalvm-svm-darwin-20.0.0-ea+21


*  Set `JAVA_HOME` to point to the GraalVM installation directory

For example:

    export JAVA_HOME=$GRAALVM_HOME


* Download llvm http://releases.llvm.org/6.0.0/clang+llvm-6.0.0-x86_64-apple-darwin.tar.xz, unpack it and make sure it is found on the `$PATH`.

For example:

    EXPORT PATH=$PATH:/path-to-llvm/clang+llvm-6.0.0-x86_64-apple-darwin/bin

* Install Homebrew if you haven't already. Please refer to https://brew.sh/ for more information.

* Install libusbmuxd

Using brew:

    `brew install --HEAD libusbmuxd

* Install libimobiledevice

Using brew:

    brew install --HEAD libimobiledevice



### Build using Maven

#### HelloWorld, HelloFX, HelloFXML and HelloGluon samples


* Change the target to `ios` (for iOS devices) or `ios-sim` (for the iOS simulator) in the `pom.xml`:

```
<artifactId>client-maven-plugin</artifactId>
<configuration>
    <target>ios</target>
    <mainClass>${mainClassName}</mainClass>
</configuration>
```

* Build the native image

Run:

    mvn clean client:build

* Connect an iOS device and deploy the app:

Run:

    mvn client:run


**Note**: Since all java bytecode is translated to native code, the compilation step can take a long time, and it requires a fair amount of memory.

**Note**: In order to deploy apps to an iOS device, you need a valid iOS provisioning profile, as explained in the [documentation](https://docs.gluonhq.com/client/#_ios_deployment).


## Issues and Contributions ##

Issues can be reported to the [Issue tracker](https://github.com/gluonhq/client-samples/issues)

Contributions can be submitted via [Pull requests](https://github.com/gluonhq/client-samples/pulls), 
providing you have signed the [Gluon Individual Contributor License Agreement (CLA)](https://docs.google.com/forms/d/16aoFTmzs8lZTfiyrEm8YgMqMYaGQl0J8wA0VJE2LCCY) 
(See [What is a CLA and why do I care](https://www.clahub.com/pages/why_cla) in case of doubt).
