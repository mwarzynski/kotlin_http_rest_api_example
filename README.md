## Why

I've decided to learn how much work it is to create rather simple REST API using Kotlin and Spring. Java has a full-grown
production-ready ecosystem which allows to develop functionalities really fast. This projects is purely to try it out.

There is always a problem with learning how to structure the code in the new technologies. I have this problem here too.
Maybe I will describe my line of thinking in the GitHub Pages. Such a content has a lot of potential. I would love to read
articles about what patterns people used as the lines of code in the project (significantly) increased. If you have some,
feel free to share them via email.

## What

REST HTTP server which provides rather simple functionality of creating _users_ and _courses_.

#### People:
 - `GET /people`
 - `GET /people/{id}`
 - `POST /people`
 - `PUT /people/{id}`
 - `DELETE /people/{id}`
#### Courses:
 - `GET /courses`
 - `GET /courses/{id}`
 - `POST /courses`
 - `PUT /courses/{id}`
 - `DELETE /courses/{id}`
 - `POST /courses/{id}/student/{personId}`
 - `DELETE /courses/{id}/student/{personId}`

## How to run

```
# Use docker to start dependencies.
docker-compose up -d
# Run application.
gradle build
gradle bootRun
```
