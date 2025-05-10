# Spring Boot Shell

Bare bones project that can be used as a starter for apps that want to use the following:
- Spring Boot
- REST Controllers
- Liquibase
- PostgreSQL


** TODO: Add a few endpoints and give instructions on how to hit them with Postman.

## Running
Create a new database named `springBootShellDb` and grant a db user named `springBootShell` r/w access to the database.

Build and run the project using the following commands
```
> mvn clean install
> mvn spring-boot:run
```

The first time you run, Liquibase should add the `Person` table to your database (and the `databasechangelog` and `databasechangelocklog` tables). The web app should now be started on localhost:8080. Use pgAdmin (or your favorite tool for touching the db) to insert a few records into the `Person` table. Then navigate your browser to http://localhost:8080/api/person to see a JSON string of your `Person` records