# Image 2 - Create Build

When you run the docker image, it must be possible to visit with the browser.

In Swagger has to exist a service controller. This service params have to be a  bean called

Build with this structure:
	– buildId (number).
	– name (string - only letters).
	– pathRepo (string with slashes (\)).
	– version (M.m.f).
	
This service have to validate the Build bean and call another Rest Service.

This app must be created with  SpringBoot .

Data:
	- Enpoint RestService: jenkins.localhost.com

------------

# Requirements

## Build

* Java 11 SDK.
* Gradle 6.8.1 (included wrapper to project).
* Docker.

## Run

* Docker.

# Use

* Web browser (checked with Chrome).

# Build

Execute next commands:

```
gradle clean build
docker build -t demo .
```

# Run

Execute next commands:

```
docker run --rm --init -it -p 8080:8080 demo
```

*make* can be used for make it all.

Ctrl+C finishes the execution (--detach mode is available in docker run).

# Use

Swagger UI is configured into Rest API. 

* [Swagger](http://localhost:8080/v2/api-docs) (it suggests Postman using).
* [Swagger UI](http://localhost:8080/swagger-ui.html).

# Notes

* Callback to Jenkins is not running.