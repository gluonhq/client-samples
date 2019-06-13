# Gluon Client HelloFX using Maven

This is the most basic sample for running JavaFX with FXML on a client with OpenJDK 11, GraalVM and the Gluon 
[Client plugin for Maven](https://github.com/gluonhq/client-maven-plugin/).

We recommend you first start with the [HelloWorld sample](https://github.com/gluonhq/client-samples/tree/master/Maven/HelloWorld) in this repository, if you haven't done it already.

Also, check the [documentation](https://docs.gluonhq.com/client) for more details about the plugin.

**Note**: For now, only Mac OS X and iOS are supported. Therefore, a Mac with MacOS X 10.13.2 or superior, and Xcode 9.2 or superior, available from the Mac App Store, are required.


For all supported platforms, you need to set `JAVA_HOME` pointing to Java 11.

## Run on Mac OS X

To compile and link:

    mvn clean client:build
    
This task performs 3 steps: 

* it will compile the Java source code into Java bytecode (done by the subtask `client:compile`)
* it will compile the Java bytecode to native code (done by the subtask `client:compile`)
* it will link the native code with dependencies and required VM code into an executable (done by the subtask `client:link`)

Alternatively, if you prefer to do those steps one by one, you can run

    mvn clean compile client:compile client:link

To run the generated executable:
    
    mvn client:run

## Run on iOS

Before you can use the plugin for deploying to iOS devices, you need to have `llvm` in your path. You can download llvm for 
Mac OS X <a href="http://releases.llvm.org/6.0.0/clang+llvm-6.0.0-x86_64-apple-darwin.tar.xz">here</a>.

The only required change in the `pom.xml` is providing the optional `target` property in the configuration inside the plugin:
```
<artifactId>client-maven-plugin</artifactId>
<configuration>
    <target>ios</target>
    <mainClass>${mainClassName}</mainClass>
</configuration>
```

Additionally, you need to instruct the application that it will run on iOS. This will be taken care of by the build tools in the 
future, but for now, modify the `main` method in `HelloFX` as follows

```
    public static void main(String[] args) {
        System.setProperty("os.target", "ios");
        System.setProperty("os.name", "iOS");
        System.setProperty("glass.platform", "ios");
        System.setProperty("targetos.name", "iOS");
        launch(args);
    }

```

Apart from this, connect an iOS device and perform the steps described above:

    mvn clean client:build
    mvn client:run

**Note**: Since all java bytecode is translated to native code, the compilation step can take a long time, and it requires a fair amount of memory.

**Note**: In order to deploy apps to an iOS device, you need a valid iOS provisioning profile.

## Run on iOS simulator

If you want to run on the iPhone Simulator, you can do so by setting the `target` property in the plugin's configuration to `ios-sim`:
```
<artifactId>client-maven-plugin</artifactId>
<configuration>
    <target>ios-sim</target>
    <mainClass>${mainClassName}</mainClass>
</configuration>
```

and modify the `main` method in `HelloFX` as follows
    
```
    public static void main(String[] args) {
        System.setProperty("os.target", "ios");
        System.setProperty("os.name", "iOS");
        System.setProperty("glass.platform", "ios");
        System.setProperty("targetos.name", "iOS");
        launch(args);
    }

```