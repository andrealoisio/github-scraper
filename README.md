# github-scraper Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Packaging and running the application
You will need Docker in order to run this application

The first step is to compile and generate a deployable .jar file, after that you can build and start
the application containers.

### Generating the .jar file
If you have a Java JDK installed you can just run the following command:
```shell script
./mvnw package -Dmaven.test.skip=true
```
If you don't, you can use a Docker image to generate the .jar file
```shell script
docker run -it --rm -v "$HOME/.m2":/root/.m2 -v "$(pwd)":/usr/src/myapp -w /usr/src/myapp openjdk:11 ./mvnw package -Dmaven.test.skip=true
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
> **_NOTE:_**  After using the command above, you may want to delete the .m2 folder from your computer to save some disk space.

### Running the application inside docker containers
After generating the .jar file, run the following command
```shell script
docker-compose up -d
```
This command will start two containers, one for the application and one containing a Postgres database

All the endpoints will be available on http://localhost:8080/q/swagger-ui/

The http://localhost:8080/scrape endpoint is responsible for starting the scraping process, every time you call this endpoint the application will retrieve 100 repositories from Github API and store them on the database as well as the users that own that repositories.


### Stop the applications and removing the volumes used to store data
```shell script
docker-compose down --volumes
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
docker-compose up -d postgres
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
