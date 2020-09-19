
This is simple spring boot application aimed to provide basic demo of flyway can be integrated. 
```
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres  -p 5432:5432 -v `pwd`:/flyway-demo postgres

docker exec -ti postgres psql -U postgres -f flyway-demo/src/main/resources/db/bootstrap.sql

```