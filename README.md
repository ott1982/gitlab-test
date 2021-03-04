# gitlab-test

```
TEST JAVA MICROSERVICES
Objective:
The main objective of this test is to obtain two Docker images. Each one of them has to
have an endpoint in Swagger.
This test is only for check how do you work, it doesn't have to work (the final endpoints are
invented).
If the docker image don’t build don’t worry, the objective it’s check how do you work with
dockerfile.
Image 1 - Gitlab
When you run the docker image, it must be possible to visit with the browser.
In Swagger has to exist a service controller that has to create a repository at Gitlab: this
repository needs to have two branches (master & develop), and one tag (0.0.1).
You can use the oficial Gitlab API to do this action.
Data:
	- Host: gitlab.localhost.com:9090
Image 2 - Create Build
When you run the docker image, it must be possible to visit with the browser.
In Swagger has to exist a service controller. This service params have to be a ​ bean called
Build​ with this structure:
    – buildId (number)
    – name (string - only letters)
    – pathRepo (string with slashes (\))
    – version (M.m.f)
This service have to validate the Build bean and call another Rest Service.
This app must be created with ​ SpringBoot​ .Data:
	- Enpoint RestService: jenkins.localhost.com
How to send the Test?
Upload the code to ​ your own Github account​ , with this structure:
- Image1
	- src (your code here)
	- Dockerfile
- Image2
	- src (your code here)
	- Dockerfile
If you need to add a Readme file, you can do it.
Send us your github repository when you have uploaded the code.
```

