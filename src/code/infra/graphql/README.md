# Documentation of GraphQL

## What is GraphQL?

GraphQL is a query language for APIs and a runtime for fulfilling those queries with your existing data. GraphQL provides a complete and understandable description of the data in your API, gives clients the power to ask for exactly what they need and nothing more, makes it easier to evolve APIs over time, and enables powerful developer tools.

## GraphQL Architecture

![GraphQL Architecture](https://www.imaginarycloud.com/blog/content/images/2021/03/GraphQL_architecture.png)

## GraphQL Example

The following example shows a GraphQL query and response.

### Request

```http
GET /graphql?query={users{id}} HTTP/1.1
Host: localhost:8080
```

### Response

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
        "id": "354a48b1-e7b8-498f-9986-a337031fa7db
      }
    ]
  }
}
```

## GraphQL Example with Error

The following example shows a GraphQL query and response with error.

### Request

```http
GET /graphql?query={users{id}} HTTP/1.1
Host: localhost:8080
```

### Response

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
## [Routes](/src/code/infra/graphql/routes.md)