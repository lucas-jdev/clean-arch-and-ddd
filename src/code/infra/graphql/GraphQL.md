# 6.GraphQL📔 #

## 6.1 What is GraphQL? ##

GraphQL is a query language for APIs and a runtime for fulfilling those queries with your existing data. GraphQL provides a complete and understandable description of the data in your API, gives clients the power to ask for exactly what they need and nothing more, makes it easier to evolve APIs over time, and enables powerful developer tools.

### 6.1.1 GraphQL Architecture ###

![GraphQL Architecture](https://www.imaginarycloud.com/blog/content/images/2021/03/GraphQL_architecture.png)


## 6.2 GraphQL Example ##

The following example shows a GraphQL query and response.

### 6.2.1 Request ###

```http
GET /graphql?query={users{id}} HTTP/1.1
Host: localhost:8080
```

### 6.2.2 Response ###

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
  "data": {
    "users": [
      {
        "id": "5bb65b51-32dc-41a5-a283-118c02111e14"
      },
      {
        "id": "354a48b1-e7b8-498f-9986-a337031fa7db"
      }
    ]
  }
}
```

## 6.3 GraphQL Example with Error ##

The following example shows a GraphQL query and response with error.

### 6.3.1 Request ###

```http
GET /graphql?query={users{id}} HTTP/1.1
Host: localhost:8080
```

### 6.3.2 Response ###

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
  "errors": [
    {
      "message": "Cannot query field \"id\" on type \"User\".",
      "locations": [
        {
          "line": 1,
          "column": 9
        }
      ]
    }
  ]
}
```

