# Spring #

## What is Spring Framework? ##

Spring Framework is a Java platform that provides comprehensive infrastructure support for developing Java applications. Spring handles the infrastructure so you can focus on your application.

Spring enables you to build applications from “plain old Java objects” (POJOs) and to apply enterprise services non-invasively to POJOs. This capability applies to the Java SE programming model and to full and partial Java EE.

Examples of how you, as an application developer, can use the Spring platform advantage:

- Make a Java method execute in a database transaction without having to deal with transaction APIs.

- Make a local Java method a remote procedure without having to deal with remote APIs.

- Make a local Java method a management operation without having to deal with JMX APIs.

- Make a local Java method a message handler without having to deal with JMS APIs.

### Spring Framework Modules ###
![modules Spring](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/images/spring-overview.png)

## Dependency Injection ##

Dependency Injection is a software design pattern that implements Inversion of Control for resolving dependencies. The pattern allows the removal of hard-coded dependencies and makes it possible to change them, whether at runtime or compile-time.

### Constructor Injection ###

Constructor injection is the most common way to implement DI. It is used when the class cannot function without the dependency. It is also the safest way to perform DI. The downside is that it makes the class harder to test, as it requires a mock object to be injected during testing.

example:

```java
public class TextEditor {
   private SpellChecker spellChecker;

   public TextEditor(SpellChecker spellChecker) {
      System.out.println("Inside TextEditor constructor." );
      this.spellChecker = spellChecker;
   }
   // a setter method to inject the dependency.
   public void setSpellChecker(SpellChecker spellChecker) {
      System.out.println("Inside setSpellChecker." );
      this.spellChecker = spellChecker;
   }
   // a getter method to return spellChecker
   public SpellChecker getSpellChecker() {
      return spellChecker;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}
```

### Setter Injection ###

Setter injection is used when the class can function without the dependency. The downside is that it makes the class harder to test, as it requires a mock object to be injected during testing.

example:

```java
public class TextEditor {
   private SpellChecker spellChecker;

   public TextEditor() {
      System.out.println("Inside TextEditor constructor." );
   }
   // a setter method to inject the dependency.
   public void setSpellChecker(SpellChecker spellChecker) {
      System.out.println("Inside setSpellChecker." );
      this.spellChecker = spellChecker;
   }
   // a getter method to return spellChecker
   public SpellChecker getSpellChecker() {
      return spellChecker;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}
```

### Field Injection ###

Field injection is used when the class cannot function without the dependency. It is also the safest way to perform DI. The downside is that it makes the class harder to test, as it requires a mock object to be injected during testing.

example:

```java
public class TextEditor {
   @Autowired
   private SpellChecker spellChecker;

   public TextEditor() {
      System.out.println("Inside TextEditor constructor." );
   }
   // a setter method to inject the dependency.
   public void setSpellChecker(SpellChecker spellChecker) {
      System.out.println("Inside setSpellChecker." );
      this.spellChecker = spellChecker;
   }
   // a getter method to return spellChecker
   public SpellChecker getSpellChecker() {
      return spellChecker;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}
```

## Spring Boot ##

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.

### Spring Boot Features ###

- Create stand-alone Spring applications

- Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)

- Provide opinionated 'starter' POMs to simplify your Maven configuration

- Automatically configure Spring and 3rd party libraries whenever possible

- Provide production-ready features such as metrics, health checks and externalized configuration

- Absolutely no code generation and no requirement for XML configuration

### Spring Boot Starter Projects ###

Spring Boot provides a number of ‘starters’ for you to use in your application. Starters are a set of convenient dependency descriptors that you can include in your application. You get a one-stop-shop for all the Spring and related technology that you need, without having to hunt through sample code and copy paste loads of dependency descriptors.

### Dependency in pom.xml ###

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## Spring Boot Annotations ##

### @SpringBootApplication ###

The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:

```java
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### @RestController ###

The @RestController annotation is a convenience annotation that combines @Controller and @ResponseBody – which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.

### @RequestMapping ###

The @RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

### @GetMapping ###

The @GetMapping annotation is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET) and provides more specific mapping.

### @PostMapping ###

The @PostMapping annotation is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST) and provides more specific mapping.

### @PutMapping ###

The @PutMapping annotation is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT) and provides more specific mapping.

### @PatchMapping ###

The @PatchMapping annotation is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PATCH) and provides more specific mapping.

### @DeleteMapping ###

The @DeleteMapping annotation is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE) and provides more specific mapping.

### @RequestParam ###

The @RequestParam annotation binds a method parameter to a web request parameter. The @RequestParam annotation can also be used to bind a query parameter to a method parameter.

### @PathVariable ###

The @PathVariable annotation binds a method parameter to a URI template variable. It can also be used to bind a method parameter to the URI path.

### @RequestBody ###

The @RequestBody annotation binds the HTTP request body to a transfer or domain object, enabling automatic deserialization of the inbound HTTP request body onto a Java object.

### @ResponseBody ###

The @ResponseBody annotation can be used to bind a method return value to the web response body. It is generally used in combination with @RequestMapping.

### @Controller ###

The @Controller annotation is a specialization of the @Component annotation with similar use and functionality. The primary difference is that the @Controller is a stereotype and its use is to mark classes at the presentation layer, so that Spring can recognize them as such when handling incoming web requests.

### @Component ###

The @Component annotation is a generic stereotype for any Spring-managed component. It is a convenience annotation that is itself annotated with @Component, @Repository, @Service, and @Controller.

### @Repository ###

The @Repository annotation is a specialization of the @Component annotation with similar use and functionality. The primary difference is that the @Repository is a stereotype and its use is to mark classes at the persistence layer, so that Spring can recognize them as such when scanning for Spring Data repositories.

### @Service ###

The @Service annotation is a specialization of the @Component annotation with similar use and functionality. The primary difference is that the @Service is a stereotype and its use is to mark classes at the service layer, so that Spring can recognize them as such when scanning for Spring Data repositories.

### @Configuration ###

The @Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

### @Bean ###

The @Bean annotation tells Spring that a method annotated with @Bean will return an object that should be registered as a bean in the Spring application context. The @Bean annotation can be used in configuration classes as well as regular @Component classes.

### @Autowired ###

The @Autowired annotation can be used to autowire bean on the setter method, constructor, a property or methods with arbitrary names and/or multiple arguments.

### @Qualifier ###

The @Qualifier annotation is used to eliminate the confusion which autowired bean to inject when multiple candidates are available. It is used in conjunction with the @Autowired annotation.

### @Primary ###

The @Primary annotation tells Spring to use this bean when multiple candidates are available. It should be used only when we are sure about this bean. It should not be used for regular classpath scanning.

### @Profile ###

The @Profile annotation is used to declare beans that will be created only when a specific profile is active. It is used in conjunction with the @Configuration annotation.

### @ComponentScan ###

The @ComponentScan annotation is used to tell Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.

### @EnableAutoConfiguration ###

The @EnableAutoConfiguration annotation tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

### @SpringBootConfiguration ###

The @SpringBootConfiguration annotation is a convenience annotation that adds all of the following:

- @Configuration

- @EnableAutoConfiguration

- @ComponentScan

### @SpringBootApplication ###

The @SpringBootApplication annotation is a convenience annotation that adds all of the following:

- @Configuration

- @EnableAutoConfiguration

- @ComponentScan

- @SpringBootConfiguration

