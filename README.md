## UniTech Application

### Endpoints

#### Create User

````
  
POST /api/unitech/users 
Host: localhost:8080
Content-Type: application/json
{
  "name": "string",
  "password": "string",
  "pin": "string",
  "surname": "string"
}
````

#### Authentication 

````
  
POST /api/unitech/authentications
Host: localhost:8080
Content-Type: application/json
Authorization: Basic base64(username:password)
{
  "password": "string",
  "pinCode": "string"
}

````


#### Create Account

````
  
POST /api/unitech/accounts
Host: localhost:8080
Content-Type: application/json
{
  "description": "string"
}

````

#### Get Account

````
GET /api/unitech/accounts/user/{pinCode}
Host: localhost:8080
Content-Type: application/json
[
  {
    "accountNumber": "string",
    "active": true,
    "amount": 0,
    "description": "string",
    "id": 0
  }
]
````


#### Transfer API
````
  
POST /api/unitech/transfers
Host: localhost:8080
Content-Type: application/json

{
  "amount": 0,
  "receiverAccountNumber": "string",
  "senderAccountNumber": "string",
  "senderMessage": "string"
}

````




#### Currency rates API

````
 
POST /api/unitech/currency-exchange/from/{from}/to/{to}
Host: localhost:8080
Content-Type: application/json

{
  "result": 0
}

````
