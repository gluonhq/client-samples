# Gluon Client HelloWorld using Gradle

This is the most basic sample for running Java on a client that run with OpenJDK 11, GraalVM and the 
[Gluon Client plugin](https://github.com/gluonhq/client-gradle-plugin/)  for Gradle.

**Requirements**

For now, Linux, Mac OS X and iOS platforms are supported.
 
To develop and deploy native applications on Mac or iOS platforms, a Mac with macOS X 10.13.2 or superior, and Xcode 9.2 or superior, available from the Mac App Store, are required.

As well, for now only JDK 11 is supported. Any JDK 11 distribution that doesn't bundle JavaFX is valid, like:

- [OpenJDK 11.0.2](https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz)
- [AdoptOpenJDK 11.0.3](https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.3%2B7/OpenJDK11U-jdk_x64_mac_hotspot_11.0.3_7.tar.gz) 

Once downloaded and installed, don't forget to set `JAVA_HOME` pointing to that JDK.

**Documentation**

Check the [documentation](https://docs.gluonhq.com/client) for more details about the plugins and running the following samples.

## Run on Linux or Mac OS X

To compile and link:

    ./gradlew nativeBuild
    
This task performs 3 steps: 

* compile the Java source code into Java bytecode (done by the subtask `build`)
* compile the Java bytecode to native code (done by the subtask `nativeCompile`)
* link the native code with dependencies and required VM code into an executable (done by the subtask `nativeLink`)

Alternatively, if you prefer to do those steps one by one, you can run

    ./gradlew build nativeCompile nativeLink

To run the generated executable:
    
    ./gradlew nativeRun

## Run on iOS

Before you can use the plugin for deploying to iOS devices, you need to have `llvm` in your path. You can download llvm for 
mac <a href="http://releases.llvm.org/6.0.0/clang+llvm-6.0.0-x86_64-apple-darwin.tar.xz">here</a>.

The only required change in the `build.gradle` is providing the optional `target` property in the `gluonClient` configuration inside the `build.gradle` file:

```
gluonClient {
    target = "ios"
}
```

Now, perform the same steps described above:

    ./gradlew nativeBuild
    
and connect an iOS device to deploy and launch:
    
    ./gradlew nativeRun

**Note**: This is an app without a UI. For an app showing a UI, have a look at the HelloFX sample. When running the HelloWorld application, the `Hello, World` is printed on `System.err` which is shown at the console where you initiated `./gradlew nativeRun`

**Note**: Since all java bytecode is translated to native code, the compilation step can take a long time, and it requires a fair amount of memory.

**Note**: In order to deploy apps to an iOS device, you need a valid iOS provisioning profile, as explained in the [documentation](https://docs.gluonhq.com/client/#_ios_deployment).

## Run on iOS simulator

If you want to run on the iPhone Simulator, you can do so by setting the `target` property in the `gluonClient` configuration to `ios-sim`:
```
gluonClient {
    target = "ios-sim"
}
```

and run the steps:

    ./gradlew nativeBuild nativeRun
