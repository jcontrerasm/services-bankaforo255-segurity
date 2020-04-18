Microservice Security
=====

**Stack del proyecto:**

* Spring Boot
* MySQL
* Kafka
* Docker

## Pre-Requisitos

* Tener java configurado.
* Tener docker y docker-compose instalados.
* En MySQL, crear una base de datos llamada **`db_security`**.

## Ejecución del proyecto en local

* Levantar los servicios externos ejecutando **`make up`** en linux y **`docker-compose up`** en windows.
* Obtener token: **` Tipo POST - http://localhost:8010/oauth/token`**.

~~~
Form URL Encoded
----------------------------------
username: admin
password: 12345
grant_type: password

Basic Auth
----------------------------------
username: webAngular
password: 123456

Header
----------------------------------
Content-Type: application/x-www-form-urlencoded
~~~
