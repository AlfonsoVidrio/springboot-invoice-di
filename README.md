# springboot-id-invoice

This is an example project to understand and practice dependency injection in Spring Boot. Using the Spring Boot framework, the project simulates the creation of an invoice with clients, products, and items, managed through dependency injection and automatic bean configuration. The goal is to understand how Spring handles dependency injection and how to configure beans using the appropriate annotations. The application has a single endpoint: `GET /api/invoice/show`, which returns a JSON object with the invoice details, including the client, description, and items.

## Usage

- The application starts a web server on the default port (8080).
- You can access the REST API at the following URL:

  ```plaintext
  http://localhost:8080/api/invoice/show
