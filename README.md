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
