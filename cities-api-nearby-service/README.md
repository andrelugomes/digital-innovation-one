# Cities API

Calculate distance between cities and find cities by radius

## Requirements

* Linux
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI
* Travis CLI

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)
* [Cube @>](https://www.postgresql.org/docs/current/cube.html)
* [Cube Tutorial](https://www.postgresqltutorial.com/postgresql-cube/)

+ earth_distance(earth, earth)	return float8	
Returns the great circle distance between two points on the surface of the Earth.
+ ll_to_earth(float8, float8) return earth	
Returns the location of a point on the surface of the Earth given its latitude (argument 1) and longitude (argument 2) in degrees.
+ earth_box(earth, float8)	return cube	
Returns a box suitable for an indexed search using the cube @> operator for points within a given great circle distance of a location. Some points in this box are further than the specified great circle distance from the location, so a second check using earth_distance should be included in the query.

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Query Earth Distance

lat_lon as Point data type
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

### Query Earth Box

+ 30000 is the radius

Get a Cube
```roomsql
SELECT earth_box(ll_to_earth(-21.95840072631836, -47.98820114135742), 30000) as cube;
```
The Cube contains? (ll_to_earth) 
```roomsql
SELECT earth_box(ll_to_earth(-21.95840072631836, -47.98820114135742), 30000) @> ll_to_earth(-21.95840072631836, -47.98820114135742) as contains;
```

All Cities Where The Cube contains ll_to_earth
```roomsql
SELECT cidade.id, cidade.nome, cidade.lat_lon 
FROM cidade 
WHERE earth_box(ll_to_earth(-21.95840072631836, -47.98820114135742), 30000) @> ll_to_earth(cidade.lat_lon[0],cidade.lat_lon[1]);
```

### Query Earth Box by Radius

```roomsql
SELECT cidade.id, cidade.nome, cidade.lat_lon 
FROM cidade 
WHERE earth_box(ll_to_earth(-21.95840072631836, -47.98820114135742), 30000) @> ll_to_earth(cidade.lat_lon[0],cidade.lat_lon[1]) 
AND earth_distance(ll_to_earth(-21.95840072631836, -47.98820114135742), ll_to_earth(cidade.lat_lon[0],cidade.lat_lon[1])) < 30000;
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
* [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## Heroku

* [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)

```shell script
heroku create dio-cities-api --addons=heroku-postgresql
```

## Code Quality

### PMD

+ https://pmd.github.io/pmd-6.8.0/index.html

### Checkstyle

+ https://checkstyle.org/

+ https://checkstyle.org/google_style.html

+ http://google.github.io/styleguide/javaguide.html

```shell script
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```

## InMemory Database Testing

+ http://www.h2database.com/html/features.html


## Migrations

+ https://flywaydb.org/

## CI

### Travis
+ https://github.com/travis-ci/travis.rb#readme

+ https://docs.travis-ci.com/user/tutorial/

#### extra

+ https://docs.travis-ci.com/user/conditional-builds-stages-jobs/
+ https://docs.travis-ci.com/user/deployment-v2/conditional

+ [Heroku Deployment](https://docs.travis-ci.com/user/deployment/heroku/)
