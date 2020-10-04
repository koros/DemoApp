# DemoApp
Restful demo app using Spring Framework

## Cloning the project
```
git clone https://github.com/koros/DemoApp.git
```

## Building the app

The demo project uses maevn build tool so after you clone the project and cd to the folder run

```
mvn clean install
```

The project is configured to use an embeded jetty web server plugin so run
```
mvn jetty:run
```

Navigate to localhost:8080 on your browser just to make sure the web server is up and running
```
http://localhost:8080/
```

To test the transactions api obtain the JWT token by making a `POST` request to http://localhost:8080/authenticate with the following params 
```
{
    "username" : "user", 
    "password" : "password"
}
```
<p>
  <img src="https://kot-ptracker.s3.eu-central-1.amazonaws.com/Screenshot+2020-10-04+at+21.28.31.png" height="280" alt="accessibility text">
</p>

### List transactions API 
Make a `GET` rquest to http://localhost:8080/api/transactions with an optinal parameter of `transaction_id` to filter the transactins by their id

<p>
  <img src="https://kot-ptracker.s3.eu-central-1.amazonaws.com/Screenshot+2020-10-04+at+21.40.31.png" height="280" alt="accessibility text">
</p>

By Transaction Id `GET` http://localhost:8080/api/transactions?transaction_id=e69c0f86-86c8-423b-8fcb-071cbd957997

<p>
  <img src="https://kot-ptracker.s3.eu-central-1.amazonaws.com/bytransaction.png" height="280" alt="accessibility text">
</p>


