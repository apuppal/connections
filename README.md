# connections
Find APIs to find connections between cities and temperatures based on location

Swagger documentation for APIs

## Building Locally

Maven build 3.0+

1. Run maven to download and build the project
    ```
    (On Unix-based)
    ./mvn clean install
    (On Windows)
    mvn clean install
    ```
 2. Verify the unit and integration test cases are executed successfully with no errors.

## Running Locally

1. Execute the below command to run connectionservice locally:
    ```
    (On Unix-based)
    ./ java -jar connections.jar
    (On Windows)
    java -jar connections.jar
        
2. The application is by default launched on port 8080. If you want to run the application on a different port, use the below command:
    ```
    (On Unix-based)
    ./java -jar -Dspring.profiles.active=local -Dserver.port=<port> -Denv=local -Dspring.application.name=ConnectionService
    (On Windows)
    java -jar  -Dspring.profiles.active=local -Dserver.port=<port> -Denv=local -Dspring.application.name=ConnectionService
    ```
3. Verify if the application launched successfully by going to the Swagger page:
    `http://localhost:<port>/swagger-ui.html`
    
