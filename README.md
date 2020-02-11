# moneylion-assessment
## User story:
As Product Manager, I would like to manage users’ accesses to new features via feature switches, i.e. enabling/disabling certain feature based on a user’s email and
feature names).

## Requirements:
`GET /feature?email=XXX&featureName=XXX` 
This endpoint receives email (user’s email) and featureName as request parameters and returns the following response in JSON format.

Example Response:
```javascript
{
"canAccess": true|false (will be true if the user has access to the featureName, otherwise it will be false. default value is false)
}
```

`POST /feature` This endpoint receives the following request in JSON format and returns an empty response with HTTP Status OK (200) when the database is updated
successfully, otherwise returns Http Status Not Modified (304).

Example Request:
```javascript
{
"featureName": "xxx", --(string)
"email": "xxx", --(string) (user's name)
"enable": true|false --(boolean) (uses true to enable a user's access, otherwise uses false)
}
```

## Database connection:
Use H2 embedded DB

## Side notes:
Must use Java 8 and Maven (or Gradle, though Maven is preferable).
Spring-boot framework is highly encouraged. (tips: use start.spring.io to bootstrap your application)

## Few Assumptions:
- For simplicity, all domains (Feature, User, and User Feature) are combined into 1 domain
- Use existing Feature & User, new Feature & new User can't be added, currently only support enabling User Feature.
