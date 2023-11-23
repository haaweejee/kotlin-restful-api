# API Spec

## Authentication

All API must use this authentication

Request :
- Header :
  - X-API-Key : "your secret api key"

## Create Product

Request :

- Method : POST
- Endpoint: `api/products`
- Header:
    - Content-Type: application/json
    - Accept: application/json
- Body:

```json
{
  "id": "string, unique",
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response :

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updateAt": "date"
  }
}
```

## Get Product

Request :

- Method : GET
- Endpoint: `api/products/{id_product}`
- Header:
    - Accept: application/json

Response :

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updateAt": "date"
  }
}
```

## List Product

Request :

- Method : GET
- Endpoint : `api/products`
- Header :
    - Accept: application/json
- Query Param :
    - size : number,
    - page : number

Response :

```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updateAt": "date"
    },
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updateAt": "date"
    }
  ]
}
```

## Update Product

Request :

- Method : PUT
- Endpoint: `api/products/{id_product}`
- Header:
    - Content-Type: application/json
    - Accept: application/json
- Body:

```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response :

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updateAt": "date"
  }
}
```

## Delete Product

Request :

- Method : DELETE
- Endpoint: `api/products/{id_product}`
- Header:
    - Accept: application/json

Response :

```json
{
  "code": "number",
  "status": "string"
}
```