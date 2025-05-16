# Voucher Pool (Boost Assessment)

This is a simple voucher pool system application built with Java and Spring Boot.

## Prerequisites

Before you begin, ensure you have met the following requirements:
- Java 21 installed on your machine
- Postman for testing purposes

## How about the database?

Don’t worry. for this demo purpose, I’m using an H2 in-memory database.
- H2 is an in-memory database, so it runs entirely in memory
- No setup, no installation, and it executes super fast.
- You don’t need to configure or install a full database server like MySQL or PostgreSQL. It works out of the box with Spring Boot.

## How to open database?

After running the service, you can open it in localhost as per below.

1. Can copy below link:
   ```sh
   http://localhost:8080/h2-console
   
2. Change the JDBC URL to:

   ```sh
   jdbc:h2:mem:voucherpool
   
3. Click connect

## How to Run It Locally

1. **Clone the Repository**

   Open your terminal and run the following command to clone the repository:

   ```sh
   git clone -b main https://github.com/hasifnizam/voucherpool.git

2. Build the Project

   Run the following command to clean and build the project:

   ```sh
   mvn clean install

3. Run the Application

   Navigate to the target folder and run the application using the following command:

   ```sh
   java -jar voucherpool-1.0.0.jar

4. Test with Postman

   Open Postman and import the collection from Voucher Pool.postman_collection. You can start testing the API endpoints as per the collection.
