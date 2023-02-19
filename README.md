# Project

## Description

This project is a study of clean architecture, with the objective of learning and applying the concepts of clean architecture in a project.

## Technologies

<div style="text-align:center">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    <img src="https://img.shields.io/badge/Quarkus-FF5722?style=for-the-badge&logo=quarkus&logoColor=white"/>
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
    <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white"/>
    <img src="https://img.shields.io/badge/GraphQL-E10098?style=for-the-badge&logo=graphql&logoColor=white"/>
    <img src="https://img.shields.io/badge/Rest-7ED957?style=for-the-badge&logo=rest&logoColor=white"/>
    <!-- <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/> -->
    <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"/>
    <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=github&logoColor=white"/>
    
</div>

## Requirements

* [Java 17][link java 17]

[link java 17]: https://www.oracle.com/java/technologies/javase-jdk17-downloads.html


## How to run

if you want to run the project, you need to have the following tools installed on your machine:

1. Install the jdk.

2. Clone the project:

    ```bash
    git clone https://github.com/lucas-jdev/clean-arch-and-ddd
    ```
3. Open project in your terminal.

4. Run the following command:

    ```bash
    javac Main.java
    java Main
    ```

finished, the project is running 😁.

> if your framework is spring, the port is 8083, but if it is quarkus, the port is 8080.

## Architecture

The project is divided into 3 layers, the `domain`, `application` and `infra` layers. The `domain` layer is responsible for the business rules, the `application` layer is responsible for the application rules and the `infra` layer is responsible for the infrastructure rules.

<div style="text-align:center">

![Architecture](/arch.png)

</div>

# Documentations

## Documentations in Project

* [Quarkus in the Project][link quarkus]
* [Routes API](/src/code/infra/rest/routes.md)
* [Spring in the Project][link spring]

## Documentation in Web

* [Docker](https://www.docker.com/)
* [GraphQL](https://graphql.org/)
* [Git](https://git-scm.com/)
* [Github](https://github.com/)
* [Quarkus](https://quarkus.io/)
* [Spring](https://spring.io/)
<!-- * [Swagger](https://swagger.io/) -->
<!-- * [Postman](https://www.postman.com/) -->

<!-- summary -->
[link quarkus]: /src/code/infra/framework/quarkus/README.md
[link spring]:/src/code/infra/framework/spring/README.md

# Contributing

If you want to contribute to the project, you can do it by following the steps below:

1. Fork the project.
2. Create a new branch with your changes: `git checkout -b my-feature`
3. Save your changes and create a commit message telling you what you did: `git commit -m "feature: My new feature"`
4. Submit your changes: `git push origin my-feature`

After the merge of your pull request is done, you can delete your branch.

# Author

* [Lucas Jdev][link linkedin]

[link linkedin]: https://www.linkedin.com/in/lucas-fernandes-bb5b401ba/

# License

This project is under the Apache License 2.0. See the [LICENSE](/LICENSE) file for more details.