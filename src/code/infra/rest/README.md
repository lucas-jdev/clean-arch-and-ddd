# Documentation for the REST API

## What is REST?

REST stands for REpresentational State Transfer. It is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other. REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server.

## REST architecture

REST is an architectural style for designing networked applications. It is commonly used to create interactive applications that use Web services. A Web service that follows these guidelines is called RESTful.

RESTful Web services allow the requesting systems to access and manipulate textual representations of Web resources by using a uniform and predefined set of stateless operations. These operations are often referred to as HTTP verbs.

![REST architecture](https://www.astera.com/wp-content/uploads/2020/01/rest.png)

## RESTful Web services

A RESTful Web service is a service that:

* Is identified by a URI
* Uses HTTP methods to implement the operations
* Uses a standard data format (e.g., JSON or XML)
* Returns standard HTTP status codes

## HTTP methods

The HTTP methods are used to implement the operations of a RESTful Web service. The following table lists the most common HTTP methods:

| Method | Description |
| --- | --- |
| GET | Retrieves a representation of the resource at the specified URI. The response might be a representation of the resource or a representation of a message about the resource. |
| POST | Creates a new resource at the specified URI. |
| PATCH | Updates the resource at the specified URI |
| PUT | Updates an existing resource at the specified URI. |
| DELETE | Deletes the resource at the specified URI. |

## HTTP status codes

The HTTP status codes are used to indicate the success or failure of an HTTP request. The following table lists the most common HTTP status codes:

| Code | Description |
| --- | --- |
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 405 | Method Not Allowed |
| 500 | Internal Server Error |

## RESTful Web services example

The following example shows a RESTful Web service that uses the HTTP methods and status codes described in the previous sections.

### Request

```http
GET /users/5bb65b51-32dc-41a5-a283-118c02111e14 HTTP/1.1
Host: localhost:8080
```

### Response

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": "5bb65b51-32dc-41a5-a283-118c02111e14",
  "username": "lucas_jdev",
  "email": "lucas.jdev@gmail.com"
}
```

## RESTful Web services example with error

The following example shows a RESTful Web service that uses the HTTP methods and status codes described in the previous sections.

### Request

```http
GET /users/5bb65b51-32dc-41a5-a283-118c02111e14 HTTP/1.1
Host: localhost:8080
```

### Response

```http
HTTP/1.1 404 Not Found
Content-Type: application/json

{
  "message": "User not found"
}
```

## [Routes](/src/code/infra/rest/routes.md)

