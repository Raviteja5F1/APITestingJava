#Project Name: REST Assured API Automation Project with Cucumber Framework

## Description

This project is an example of API automation using REST Assured library with Cucumber framework.

## Features

- Get all the products from fakestore API
- Insert products using post API
- Update products using PUT API
- Delete products using delete API

## Requirements

- Java Development Kit (JDK) 8 or higher
- Maven
- Cucumber
- REST Assured
- Intelij


## Setup Instructions

1. Clone the repository:
   ```bash
   git clone "https://github.com/Raviteja5F1/APITestingJava.git"


-> Navigate to the project directory:

   cd your-project

-> Install dependencies:
	
	mvn clean install

## Project structure

├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── Features
│       │       └── Feature files
│       │       └── Pages
│		│		└── Runner
│		│		└── Step definitions
│		│		└── Utility
│       └── resources
├── target
├── pom.xml
└── README.md



Usage
To run the API tests, execute the following command:

mvn test

Test Scenarios:

GET:
1.Verify the get api for products
2.Verify the rate of the first product
3.Verify the category of the first product
4.Print the titles for products of get api

POST:
1. Validate post API product works correctly
2. Validate post API product response body works correctly
3. Validate post API product response code if we pass price value as string

PUT: 
1. Validate PUT product API status code works correctly
2. Validate PUT product API status code works correctly with characters

DELETE:
1. Validate Delete product API status code works correctly
2. Validate Delete product API status code works correctly with characters



Reporting:
In progress