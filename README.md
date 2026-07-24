# 🏦 Bank Management System

A full-stack **Bank Management System** developed using **Spring Boot**, **React.js**, **MySQL**, 
and **JWT Authentication**. The application enables users to securely manage bank accounts and perform 
banking operations through a modern web interface.

## 🚀 Features

* 🔐 User Registration & Login
* 🔑 JWT Authentication & Authorization
* 👤 Secure User Dashboard
* 💳 Create Bank Account
* 💰 Deposit Money
* 💸 Withdraw Money
* 📊 Check Account Balance
* 📜 View Transaction History
* 🌐 RESTful API Architecture
* 🎨 Responsive React Frontend

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT Authentication
* Maven

### Frontend

* React.js
* Axios
* HTML5
* CSS3
* JavaScript

### Database

* MySQL

### Tools

* Eclipse / STS
* VS Code
* Postman
* Git & GitHub

---

## 📂 Project Structure

```
Bank_Management_System
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── security/
│   └── config/
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── services/
│   │   ├── pages/
│   │   └── App.js
│
└── README.md
```

---

## 🔑 Modules

### Authentication

* User Registration
* User Login
* JWT Token Generation
* Secure API Access

### Account Management

* Create Account
* View Account Details
* Check Balance

### Transactions

* Deposit Amount
* Withdraw Amount
* Transaction History

---



## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/ObulReddy01/Bank_Management_System.git
```

```bash
cd Bank_Management_System
```

---

### Backend Setup

1. Configure MySQL database.
2. Update `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

Backend runs at:

```
http://localhost:8080
```

---

### Frontend Setup

Navigate to frontend folder:

```bash
cd bank-ui
```

Install dependencies:

```bash
npm install
```

Start React application:

```bash
npm start
```

Frontend runs at:

```
http://localhost:3000
```

---

## 📡 API Endpoints

### Authentication

| Method | Endpoint         |
| ------ | ---------------- |
| POST   | `/auth/register` |
| POST   | `/auth/login`    |

### Accounts

| Method | Endpoint                     |
| ------ | ---------------------------- |
| POST   | `/api/accounts/create`       |
| GET    | `/api/accounts/{id}`         |
| GET    | `/api/accounts/balance/{id}` |

### Transactions

| Method | Endpoint                          |
| ------ | --------------------------------- |
| POST   | `/api/accounts/deposit`           |
| POST   | `/api/accounts/withdraw`          |
| GET    | `/api/accounts/transactions/{id}` |

---

## 🔒 Security

* Spring Security
* JWT Authentication
* Password Encryption
* Protected REST APIs
* Role-Based Authorization (Extensible)

---

## 📈 Future Enhancements

* Money Transfer Between Accounts
* Email Notifications
* Admin Dashboard
* Account Statement PDF
* Loan Management
* Fixed Deposits
* Mobile Responsive UI
* Docker Deployment
* CI/CD Pipeline

---

## 👨‍💻 Author

**Obul Reddy**

GitHub: **https://github.com/ObulReddy01**

---

## ⭐ Support

If you found this project helpful, please consider giving it a **⭐ Star** on GitHub.
