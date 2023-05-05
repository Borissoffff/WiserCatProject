## Backend

### How to Run?

1. Clone the project: `git clone <project-url>`
2. Open the project in your IDE
3. Run the main method in the `WiserCatProjectApplication` class. Path: `src/main/java/com/example/wisercatproject/WiserCatProjectApplication.java`
4. Make sure the application is running on localhost on port 8080

### Description

The application uses several models: `User`, `Pet`, `PetType`, `FurColor`, and `Origin`. The database tables for these models are already created and filled with data using Liquibase XML files. For inserting data into the "origin" table, Liquibase uses the "countries.csv" file to correctly insert information about all world countries. You can find the models in the "model" package and the Liquibase scripts in the "resources" folder.

ERD of database:

![ERD](src/main/resources/static/wisercat-2023-05-05_11-46.png)

The server side is divided into layers:
1. Data access layer (repositories)
2. Business logic layer (services)
3. Application layer (controllers)

To easily get and send data from the server side to the client side and vice versa, the project includes DTOs and Object Mappers. This helps limit the information received on the client side (the user does not need to have ids of pet type or pet origin).  
<br />
When the user sends "PUT" or "POST" requests to the back-end, the application uses Hibernate Validator to validate the application models constraints.
