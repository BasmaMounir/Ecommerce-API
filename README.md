# 🛒 E-Commerce Product API

This is a simple and clean RESTful API for an E-Commerce system built using **Spring Boot**.  
It allows users to manage **products**, **categories**, and includes **authentication & authorization** using **Spring Security + JWT**.  

## 🔧 Technologies Used

- 💻 Java 17  
- ⚙️ Spring Boot  
- 🌐 Spring Web  
- 🗃️ Spring Data JPA  
- 🛡️ Spring Security  
- 🔐 JWT (JSON Web Token)  
- 🐬 MySQL / 🧪 H2 (Any relational DB)  
- 📦 Maven  

---

## 📦 Features

### ✅ Product Management
- ➕ Add a new product  
- 👀 View all products  


### ✅ Category Management
- ➕ Create a new category  
- 👀 View all categories  
- 🔗 Assign a product to a category  

### ✅ User Authentication
- 📝 Register a new user  
- 🔐 Login with username & password  
- 🔒 **Role-based Access Control (RBAC)**  
  - 👑 **ADMIN**: Full access to manage products & categories  
  - 🙋‍♀️ **USER**: Can only view products & categories  

---

## 🔐 Security

- ✅ JWT-based authentication system  
- ✅ Endpoints protected using **Spring Security**  
- ✅ Passwords hashed securely using **BCrypt**  

---

## 💳 Cart Feature (New!)

- ➕ Add product to cart  
- 🛒 View cart items  

---

## ⚠️ Exception Handling

Handled all possible exceptions with clean and meaningful error messages for a better developer experience 💬  
Includes:
- 🔍 Resource not found  
- ❌ Bad request  
- 🔐 Unauthorized access  

---

## 🖼️ Screenshots

### 🔐 Authentication
<img src="https://github.com/user-attachments/assets/827dd0f3-8deb-4f8f-912c-bdd7a4468ced" width="400"/>
<img src="https://github.com/user-attachments/assets/0fff7d96-c017-4607-94a4-45ab14d0cf44" width="400"/>

### 🛒 Product Management
<img src="https://github.com/user-attachments/assets/19a6578c-b82c-4d0b-b38d-f2dfd84ae409" width="400"/>


### 📂 Category Management
<img src="https://github.com/user-attachments/assets/27c515d7-bcd3-4361-9bf5-ca9050e1c0ae" width="400"/>

### 🛒 Cart
<img src="https://github.com/user-attachments/assets/c86b4f00-2257-48c6-abdd-626951f05ebb" width="400"/>

### ❌ Exceptions
<img src="https://github.com/user-attachments/assets/102adb83-b4e6-4d9a-a4a9-29fbb5787a95" width="400"/>

<img src="https://github.com/user-attachments/assets/b20f5504-d056-4221-9d08-77860b20e171" width="400"/>

---

## 🚀 Getting Started

1. Clone the repository  
```bash
git clone https://github.com/BasmaMounir/SimpleEcommerce-API.git
