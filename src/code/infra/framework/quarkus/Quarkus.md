# Quarkus

## What is Quarkus Framework? ##

### Introduction of Quarkus Framework ###

<p>
Quarkus is a Kubernetes Native Java stack tailored for GraalVM & OpenJDK HotSpot, crafted from the best of breed Java libraries and standards.
</p>

It is designed to work with popular Java standards, frameworks and libraries like Eclipse MicroProfile and Spring, as well as Apache Camel, 

Infinispan, Hibernate ORM and many more.
 
It aims to make developing cloud-native applications easier than ever before, and provides a developer-centric experience that is second to none.

It is also designed to make it easy for GraalVM and HotSpot to optimize your application with minimal effort.

### Quarkus Features ###

* Supersonic Subatomic Java
* Container First
* Cloud Native
* Kubernetes Native
* Optimized for GraalVM
* Reactive
* Native Image Ready
* AOT Ready
* Developer Joy

### Quarkus Architecture ###

![imagem](http://www.mastertheboss.com/images/stories/vari/quarkus_extensions.png)


### Dependency in pom.xml ###

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-arc</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-resteasy-reactive</artifactId>
</dependency>

<dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>${quarkus.platform.group-id}</groupId>
        <artifactId>${quarkus.platform.artifact-id}</artifactId>
        <version>${quarkus.platform.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
</dependencyManagement>
```