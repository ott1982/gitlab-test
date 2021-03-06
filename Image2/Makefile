run:
	gradle clean build
	docker build -t demo .
	docker run --rm --init -it -p 8080:8080 demo