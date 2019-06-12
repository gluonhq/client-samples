# Gluon Client HelloWorld using Gradle

This is the most basic sample for running Java and JavaFX samples on a client that run with OpenJDK 11, GraalVM and the Gluon 
Client plugin for [Gradle](https://github.com/gluonhq/client-gradle-plugin/).

Set `JAVA_HOME` pointing to Java 11.

**Note**: For now, only Mac OS X and iOS are supported. Therefore, a Mac with MacOS X 10.13.2 or superior, and Xcode 9.2 or superior, available from the Mac App Store, are required.

Check the [documentation](https://docs.gluonhq.com/client) for more details about the plugins and running the following samples.

## Run on Mac OS X

To compile and link:

    ./gradlew clean nativeBuild
    
This task performs 3 steps: 
* it will compile the Java source code into Java bytecode (done by the subtask `build`)
* it will compile the Java bytecode to native code (done by the subtask `nativeCompile`)
* it will link the native code with dependencies and required VM code into an executable (done by the subtask `nativeLink`)

Alternatively, if you prefer to do those steps one by one, you can run

    ./gradlew clean build nativeCompile nativeLink

To run the generated executable:
    
    ./gradlew nativeRun

## Run on iOS

Before you can use the plugin for deploying to iOS devices, you need to have `llvm` in your path. You can download llvm for 
mac <a href="http://releases.llvm.org/6.0.0/clang+llvm-6.0.0-x86_64-apple-darwin.tar.xz">here</a>.

The only required change in the 'build.gradle' is providing the optional `target` property in the `gluonClient` configuration inside the `build.gradle` file:
```
gluonClient {
    target = "ios"
}
```

Apart from this, connect an iOS device and perform the steps described above:
    ./gradlew clean nativeBuild
    ./gradlew nativeRun

** Note **: This is an app without a UI. For an app showing a UI, have a look at the HelloFX sample. When running the HelloWorld application, the `Hello, World` is printed on `System.err` which is shown at the console where you initiated `./gradlew nativeRun`

** Note **: Since all java bytecode is translated to native code, the compilation step can take a long time, and it requires a fair amount of memory.

** Note **: In order to deploy apps to an iOS device, you need a valid iOS provisioning profile.

