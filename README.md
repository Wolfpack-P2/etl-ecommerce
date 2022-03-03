# Alchemy-Wolfpack: E-Commerce ETL

Public Repository for Team Alchemy's Project Boards and Wiki

## Project Description

The purpose of the project is to create an ETL (Extract, Transform, Load) and web application to view and manipulate an E-commerce mock data set from an AWS server. We used Talend to read a CSV file with 1000 entries of mock E-commerce data with some dirty data, cleaned that data, then load it onto an AWS server where it can be accessed from the web application.

## Technologies Used

* DBeaver - version 21.3.5
* IntelliJ - version 2021.3.1
* Java - version 1.8
* Junit - version 4.13.2
* Maven - version 3.8.4
* PostgreSQL - version 42.3.1
* Postman - version 9.14.6
* Spring Boot - version 2.6.3
* Talend - version 8.0.1
* Tomcat - version 9.0.56

## Features

* Login Page
* Registration Page
* Dashboard Page

## Getting Started

* Note: this app will only work with a connection to Amazon Web Services. The application.properties file will need to be edited to work on your device.

1. Open git bash terminal in desired directory and enter the following: 
    git clone https://github.com/Wolfpack-P2/etl-ecommerce.git

2. Open the directory in IntelliJ or other desired Java IDE

3. Make sure that the Maven POM.xml file changes are loaded

4. Edit the application.properties file to your specifications

5. Run EtlECommerceApplication using Spring and then go to http://localhost:8080/ETL-E-Commerce/ to test web app


## Contributers

* Abdul Alim
* James Benjamin
* Jacob Coffin
* Zahtae Mouzone
* Nathan Pierce
* Yasin Yardimoglu
