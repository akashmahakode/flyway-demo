This is simple spring boot application aimed to provide basic demo of how flyway can be integrated. 

## Setup Environment

### Clone the repository
Clone the repository from - 
https://github.com/akashmahakode/flyway-demo

### Start Postgres docker container

Go to flyway-demo project directory and run-
```
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres  -p 5432:5432 -v `pwd`:/flyway-demo postgres
```

### Bootstrap database
Bootstrap script below creates required roles(employees_owner and employees_app) and database(employees_db).

```
docker exec -ti postgres psql -U postgres -f flyway-demo/src/main/resources/db/bootstrap.sql
```

### Run Flyway
Go to `flyway-demo` directory and run flyway as follows to create "employees" table.
```
mvn flyway:migrate 
```

#### Connect to database (Optional) to verify the table-
Run
```
docker exec -ti postgres psql -U postgres
```
Connect to employees_db
```
postgres=# \c employees_db
employees_db=# select * from employees ;
```
Created table should look like -
```
employees_db=# select * from employees ;
 emp_id | emp_name | emp_email | emp_phone
--------+----------+-----------+-----------
(0 rows)
```

## Start the application
1. Start the application-
```
mvn spring-boot:run   
```

## cURL requests
### Create and Store Employee
```
curl --request POST \
  --url http://localhost:8080/employees \
  --header 'content-type: application/json' \
  --data '{
	"id":"30",
	"name":"Akash Mahakode",
	"email":"amahakode@hawk.iit.edu",
	"phone":"+0000000"
}'
```

```
employees_db=# select * from employees ;
 emp_id |    emp_name    |       emp_email        | emp_phone
--------+----------------+------------------------+-----------
 30     | Akash Mahakode | amahakode@hawk.iit.edu | +0000000
(1 row)
```

### Retrieve/Load an Employee from DB
```
curl --request GET \
  --url http://localhost:8080/employees/30 
```

Response -
```
{
  "employee_id": "30",
  "employee_name": "Akash Mahakode",
  "employee_email": "amahakode@hawk.iit.edu",
  "employee_phone": "+0000000"
}
```