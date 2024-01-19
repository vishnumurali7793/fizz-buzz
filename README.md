# fizz-buzz

![Build Status](https://img.shields.io/travis/username/repo.svg)
![Version](https://img.shields.io/badge/version-1.0-blue.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)

## Description
A robust and production-ready Fizz-Buzz REST Server that follows the classic Fizz-Buzz logic.

## Table of Contents
- [Configuration](#configuration)
- [Usage](#usage)
- [License](#license)
- [API Documentation](#apidocumentation)

## Installation
1. Checkout the project into the IDE.
2. Create the schema in MySQL database server using the query from the db_queries.txt file.

## Usage
Endpoint details are provided below.
1. To check the application deployment status: /fizz-buzz/api/v1/status/ - [GET]
2. To generate the string sequence: /fizz-buzz/api/v1/generate-sequence/ - [POST]
3. To check the statistics: /fizz-buzz/statistics - [GET]

## License
This project is licensed under the [MIT License](LICENSE).

## API Documentation
Documentation for the APIs will be available at : http://localhost:8080/fizz-buzz/swagger-ui/index.html
