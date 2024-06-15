# Simple Hibernate JPA System

This project is a simple system built with Hibernate JPA. The system allows users to manage products through a controller. Users can also fetch all suppliers linked to a product and search for products by category.

## Features

- Add new products
- Fetch all suppliers linked to a product
- Search for products by category

## Database Tables

The following tables are used in the system:

### Products

| Column     | Type    | Description       |
|------------|---------|-------------------|
| id         | Long    | Product ID        |
| name       | String  | Product Name      |
| price      | Double  | Product Price     |
| category_id| Long    | Category ID       |

### Category

| Column | Type   | Description     |
|--------|--------|-----------------|
| id     | Long   | Category ID     |
| name   | String | Category Name   |

### Suppliers

| Column | Type   | Description       |
|--------|--------|-------------------|
| id     | Long   | Supplier ID       |
| name   | String | Supplier Name     |

### Product_Supplier

| Column     | Type  | Description         |
|------------|-------|---------------------|
| product_id | Long  | Product ID          |
| supplier_id| Long  | Supplier ID         |

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

- Java 8 or higher
- Maven
- Hibernate JPA

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/CleiltonRocha/av3-poo.git

2. Install the Maven dependences
   ```sh
   mvn install

3. Create a database in MySQL Workbench or other through **database/db_av03.mwb** file.

4. Set up your database connection in src/main/resources/application.properties

5. Run application

## Usage
In this step, you can use [Insomnia](https://insomnia.rest/download) or [Postman](https://www.postman.com/downloads/) for http requests.

### Adding a product
To add a new product, send a POST request to **/api/products/add** with the following JSON body:
NOTE: You can add a category manually to set **category_id**.
```
{
  "name": "Product Name",
  "price": 100.0,
  "category_id": 1
}
```

## Fetching All Suppliers Linked to a Product
To fetch all suppliers linked to a product, send a GET request to **/api/products/{productId}/suppliers**

## Searching for Products by Category
To search for products by category, send a GET request to **api/products/category/{categoryId}**.

















