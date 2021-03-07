# Image 1 - Gitlab

When you run the docker image, it must be possible to visit with the browser.

In Swagger has to exist a service controller that has to create a repository at Gitlab: this
repository needs to have two branches (master & develop), and one tag (0.0.1).

You can use the oficial Gitlab API to do this action.

Data:
	- Host: gitlab.localhost.com:9090

------------

# Requirements

## Build

* Java 11 SDK.
* Gradle 6.8.1 (included wrapper to project).
* Docker.

## Run

* Docker.

## Use

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

* Callback to GitLab is not running.

# Appendix

## Run GitLab instance

Execute following command:

```sh
-docker run --rm --init -it -p 443:443 -p 80:80 -p 22:22 \
--v /tmp/gitlab/config:/etc/gitlab \
--v /tmp/gitlab/logs:/var/log/gitlab \
--v /tmp/gitlab/data:/var/opt/gitlab \
-gitlab/gitlab-ce:13.9.1-ce.0
```