# AIOPs Hackathon Lab Application

## Overview

The micro-service based application which has been designed to facilitate car rental and reservation management.

## Table of Contents

- [Architecture Overview](#architecture-overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Local Development](#local-development)
      - [Setup Database](#setupdatabase)
      - [Backend](#backend)
      - [Frontend](#frontend)
  - [AWS Deployment](#aws-deployment)
      - [Prerequisites](#prerequisites)
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

---

### Local Development

- Clone this repository:
  ```bash
  git clone https://github.com/Milinda96/AIOPs_Hackathon_Lab_Application.git

#### Setup Database

When configuring the database, navigate to the `database` folder and execute `car_rental_db.sql` to create the database within your local env.

#### Backend

To run the backend, follow these steps:

1. Go to `aiops-hackathon-services`.
2. Navigate to `discovery-service` and run `mvn clean spring-boot:run`.
3. Navigate to `api-gateway` and run `mvn clean spring-boot:run`.
4. Similarly, after navigating to `location-service`, run `mvn clean spring-boot:run`.
5. Go to `car-service` and run `mvn clean spring-boot:run`.
6. Finally, go to `reservation-service` and run `mvn clean spring-boot:run`.

#### Frontend

Here, I have a frontend application developed with Angular 11 and Node 16. To start the application, the you need to use the `ng serve` command and navigate to `aiops-hackathon-client` and run the command. The app can be accessed using `http://localhost:4200/#/home`.

---

### AWS Deployment

#### Prerequisites

#### Access to EC2 via Putty

To access an AWS EC2 instance using PuTTY on Windows, you need to convert the private key file from the .pem format to PuTTY's .ppk format and then use PuTTY to establish an SSH connection. Here are the steps:

Step 1: Convert .pem Key to .ppk Format

1. Download and install PuTTY if you haven't already. You can get it from the PuTTY website.
2.	Launch PuTTYgen, which comes with PuTTY, and click the "Load" button.
3.	In the file dialog, select your .pem private key file.
4.	Click "Open."
5.	PuTTYgen will prompt you to convert the key into PuTTY's own format. Click the "Save private key" button.
6.	Save the key in .ppk format.

Step 2: Configure PuTTY

1.	Launch PuTTY.
2.	In the "Session" category, enter your EC2 instance's public IP address or DNS hostname in the "Host Name (or IP address)" field.
3.	In the "Connection" > "Data" category, enter the username used for your EC2 instance. For Ubuntu 20.4, the username is typically ubuntu. For other distributions, check the official documentation for the correct username.
4.	In the "Connection" > "SSH" > "Auth" category, click the "Browse" button and select the .ppk private key file you created earlier.
5.	Optionally, you can save this configuration for future use by entering a name in the "Saved Sessions" field and clicking the "Save" button.
6.	Click "Open" to initiate the SSH connection.

Step 3: Connect to EC2 Instance

1. PuTTY will use the private key to authenticate, and if everything is configured correctly, it should establish a connection to your EC2 instance.
2. Once connected, you can use the terminal provided by PuTTY to interact with your EC2 instance as if you were using SSH from a Linux terminal.

#### Configure Environment

1.	Update the system packages: Ensure that your instance is up to date by running the following commands:
`sudo apt update`
2.	Install necessary software: Install Java, MySQL and Apache Httpd Server.

#### Java 8
#### Installing OpenJDK 8

1. You can install it by typing the following commands:
`sudo apt update`
`sudo apt install openjdk-8-jdk`

2. Verify the installation by checking the Java version:
`java -version`

#### Frontend

#### Backend
