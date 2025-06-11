# 🛒 E-Commerce Product API

This is a simple RESTful E-Commerce API built using **Spring Boot**.  
It allows users to manage **products**, **categories**, and includes **authentication & authorization** using **Spring Security + JWT**.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- MySQL / H2 (Any relational DB)
- Maven

---

## 📦 Features

### ✅ Product Management
- Add a new product
- View all products
- View product by ID
- Update / Delete products *(admin only)*

### ✅ Category Management
- Create a new category
- View all categories
- Assign a product to a category

### ✅ User Authentication
- Register a new user
- Login with username and password
- Role-based access:
  - `ADMIN`: full access to manage products & categories
  - `USER`: can only view products/categories

---

## 🔐 Security

- JWT-based authentication
- Endpoints protected with role-based access using Spring Security
- Passwords are hashed using BCrypt

---

