# Gurus Car Management System - README

Welcome to the Gurus Car Management System! This system provides a comprehensive solution for managing vehicles, employees, attendance, and vehicle rental/sale records. It consists of two dashboards: an Admin Dashboard and an Employee Dashboard. This README file will guide you through the setup and usage of the application.

## Features

- **Admin Dashboard:**
  - Add employees to the system.
  - Mark attendance for employees
  - View Analytics

- **Employee Dashboard:**
  - Rent out vehicles to customers
  - Check Available cars for Rent.
  - Add Cars for Rent and Sale
  - Sell Cars to Customers
  - Add New Customer
  - Lodge Customer Complaints
  - Add maintenance records for cars

## Technologies Used

The Vehicle Management System is built using the following technologies:

- Programming Language: JAVA - platform: JDK 1.8
- Framework: JAVA Swing
- Database: MySQL
- Other Dependencies: jcalender-1.4 and MySQL connector

## Installation

Follow the steps below to set up and run the Vehicle Management System on your local machine:

1. Clone the repository from GitHub:

   ```shell
   git clone https://github.com/maheenncodes/GURUSCarManagementSystem.git

2. Configure the database:
 - Create a new database 'management' for the application using MySQL Workbench
 - Update the database connection details in the configuration files.
 - Add the following MySQL script to your database file

    ```sql
    CREATE TABLE CarTbl (
      RegNum VARCHAR(100) PRIMARY KEY,
      Brand VARCHAR(100) NOT NULL,
      Model VARCHAR(100) NOT NULL,
      Status VARCHAR(100) NOT NULL,
      Price INT NOT NULL
    );
    
    CREATE TABLE RentCars (
      RegNum VARCHAR(100) PRIMARY KEY,
      Brand VARCHAR(100) NOT NULL,
      Model VARCHAR(100) NOT NULL,
      BookingStatus VARCHAR(100) NOT NULL,
      BookingPrice INT NOT NULL
    );
    
    CREATE TABLE Customers (
      CusName VARCHAR(100) NOT NULL,
      CNIC VARCHAR(100) NOT NULL,
      Address VARCHAR(100) NOT NULL,
      Phone VARCHAR(100) NOT NULL,
      PRIMARY KEY (CusName, CNIC)
    );
    
    CREATE TABLE Employees (
      EmpName VARCHAR(100) NOT NULL,
      CNIC VARCHAR(100) NOT NULL,
      Designation VARCHAR(100) NOT NULL,
      Salary INT NOT NULL,
      LisenceNo VARCHAR(100) DEFAULT NULL,
      PRIMARY KEY (EmpName, CNIC)
    );
    
    CREATE TABLE Complaint (
      CusName VARCHAR(100),
      BookingDate VARCHAR(100) NOT NULL,
      RegNo VARCHAR(100) NOT NULL,
      DriverName VARCHAR(100) NOT NULL,
      Complaint_ VARCHAR(100) NOT NULL,
      INDEX cus_name (CusName),
      INDEX driver_name (DriverName),
      FOREIGN KEY (CusName) REFERENCES Customers (CusName) ON DELETE SET NULL ON UPDATE CASCADE,
      FOREIGN KEY (DriverName) REFERENCES Employees (EmpName) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    CREATE TABLE Attendence (
      EmpName VARCHAR(100) NOT NULL,
      Designation VARCHAR(100) NOT NULL,
      Date_ VARCHAR(100) NOT NULL,
      Status VARCHAR(100),
      PRIMARY KEY (EmpName, Date_)
    );
    
    CREATE TABLE login (
      username VARCHAR(50),
      passwords VARCHAR(50)
    );
    
    CREATE TABLE MaintainRec (
      RegNo VARCHAR(100) PRIMARY KEY,
      LastMaintained VARCHAR(100),
      NextMaintain VARCHAR(100) NOT NULL
    );
    
    INSERT INTO login (username, passwords) VALUES ('Taimoor', '1234');
    INSERT INTO login (username, passwords) VALUES ('t', '1234');
    INSERT INTO login (username, passwords, mail, type, pnum) VALUES ('t', '1234', 't@gmail.com', 'Admin', '3000');
    
    INSERT INTO Attendence (EmpName, Designation, Date_, Status) VALUES ('fizza', 'driver', '06-12-2022', 'Absent');
    INSERT INTO Attendence (EmpName, Designation, Date_, Status) VALUES ('Maheen', 'driver', '06-12-2022', 'Present');

This concludes the SQL script for setting up the database tables and inserting initial data. Feel free to modify or expand upon this script as per your project requirements.
      
  
## Usage

**Admin Dashboard:**

1. Login to the admin account by signing up
2. Use the dashboard to add employees, mark attendance, view records.

**Employee Dashboard:**

1. Login to the employee account by signing up
2. Use the dashboard to rent out vehicles and add vehicle sale records, add customers, lodge complaints.

## Contributing

Contributions to the Vehicle Management System are welcome! If you find any bugs or have suggestions for improvements, please open an issue on the GitHub repository. You can also submit pull requests with your proposed changes.

When contributing, please adhere to the project's code of conduct and follow the guidelines for contributing specified in the repository.

## License

The Gurus Car Management System is released under the  MIT License. See the [MIT License](LICENSE) file for more details.

## Contact

If you have any questions or need further assistance, feel free to contact the project maintainer:

- **Name:** Maheen
- **Email:** maheen0104@gmail.com

Thank you for using the Gurus Car Management System! We hope it proves to be a valuable tool for managing your vehicles and employee records.
