# AIOPs Hackathon Lab Application

## Overview

The micro-service application which has been designed to facilitate car rental and reservation management.

## Table of Contents

- [Architecture Overview](#architecture-overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Local Development](#local-development)
      - [Setup Database](#setupdatabase)
      - [Backend](#backend)
      - [Frontend](#frontend)
  - [AWS Deployment](#aws-deployment)
      - [Backend](#backend)
      - [Frontend](#frontend)

## Architecture Overview

![AIOps Hackathon Lab Application Architecture Diagram](architecture-documents/AIOps%20Hackathon%20Lab%20Application%20Architecture%20Diagram%20v1.png)

## Getting Started

### Prerequisites

- **Node.js**: [Install Node.js](https://nodejs.org/)
- **Java 8**: [Install Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- **MySQL 8**: [Install MySQL 8](https://dev.mysql.com/downloads/installer/)
- **Apache Maven 3.8.1**: [Install Apache Maven](https://maven.apache.org/download.cgi)

### Local Development

- Clone this repository:
  ```bash
  git clone https://github.com/Milinda96/AIOPs_Hackathon_Lab_Application.git

### Setup Database

When configuring the database, navigate to the `database` folder and execute `car_rental_db.sql` to create the database within your local env.

### Backend

To run the backend, follow these steps:

1. Go to `aiops-hackathon-services`.
2. Navigate to `discovery-service` and run `mvn clean spring-boot:run`.
3. Navigate to `api-gateway` and run `mvn clean spring-boot:run`.
4. Similarly, after navigating to `location-service`, run `mvn clean spring-boot:run`.
5. Go to `car-service` and run `mvn clean spring-boot:run`.
6. Finally, go to `reservation-service` and run `mvn clean spring-boot:run`.

### Frontend

Here, I have a frontend application developed with Angular 11 and Node 16. To start the application, the you need to use the `ng serve` command and navigate to `aiops-hackathon-client` and run the command. The app can be accessed using `http://localhost:4200/#/home`.

### AWS Deployment

### Frontend

### Backend
