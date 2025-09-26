# 🛒 E-Commerce Hibernate Application

This project is a simple **E-Commerce backend** built using **Hibernate ORM**.
It demonstrates entity relationships, modular DAO-Service-Controller structure, and **console-based CRUD operations** for managing Users, Addresses, Orders, Products, and Categories.

---

## 🚀 Features

* ✅ **User CRUD** – Full Create, Read, Update, Delete operations.

  * Users identified internally by **ID (PK)**.
  * **Phone Number used as external identifier** in menus and operations.

* ✅ **One-to-One Mapping** – `User ↔ Address` relationship.

  * Multiple addresses supported per user.
  * Cascade and orphan removal handled.

* ✅ **Address CRUD** – Fully implemented with **phone number lookup**.

* ✅ **Order CRUD** – Users can place and manage orders.

  * Linked with user via `@ManyToOne`.

* ✅ **Product CRUD** – Add, update, view, and delete products.

* ✅ **Category CRUD** – Manage categories with relation to products.

* ⚙️ **Hibernate Configuration** using `hibernate.cfg.xml` (no Spring Data JPA).

* 🗂️ **Layered Architecture** –

  * **DAO Layer** → DB operations.
  * **Service Layer** → Business logic.
  * **Controller Layer** → Console-driven menus.

---

## 🛠️ Tech Stack

* ☕ **Java 8+**
* 🏗️ **Hibernate ORM (6.x)**
* 🐬 **MySQL 8+**
* 📦 **Maven** (dependency management)
* 🖥️ **Console-based UI**

---

## 📂 Project Structure

```
src/main/java
├── com.ecommerce.entity     # Entities (User, Address, Order, Product, Category)
├── com.ecommerce.dao        # DAO classes for DB operations
├── com.ecommerce.service    # Service layer
├── com.ecommerce.controller # Console menu controllers
├── com.ecommerce.util       # Hibernate utility (SessionFactory)
└── com.ecommerce.App        # Main entry point
```

---

## ⚡ Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/<username>/<repo-name>.git
cd <repo-name>
```

### 2️⃣ Configure Database

* Create a MySQL database (e.g., `ecommerce_db`).
* Update `hibernate.cfg.xml` with your DB username & password.

### 3️⃣ Build the project

```bash
mvn clean install
```

### 4️⃣ Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.ecommerce.App"
```

---

## 🎯 Purpose

This project is designed for:

* Learning **Hibernate ORM** with practical console menus.
* Practicing **entity relationships** (One-to-One, One-to-Many, Many-to-Many).
* Demonstrating **DAO-Service-Controller pattern** without Spring Boot/JPA.
* Serving as a **starter project** for Hibernate-based applications.

---

## 🧑‍🤝‍🧑 Contributors

| Name                                                          | GitHub         | Role                                          |
| ------------------------------------------------------------- | -------------- | --------------------------------------------- |
| [**Ranjay Devendra Singh**](https://github.com/ranjay24)      | 🐙 `@ranjay24` | Hibernate Associations & Mapping Logic        |
| [**Samarth Deelip Kalegaonkar**](https://github.com/SamK1828) | 🐙 `@SamK1828` | Repository Creator & Full Backend Development |

---

## 🔮 Future Enhancements

* 🛍️ Improve **Order-Product relationship** (One-to-Many mapping).
* 🗃️ Implement **Many-to-Many mapping** for Product & Category with join table.
* 📦 Add **Cart module**.
* 🌐 Expose **REST APIs** for external integrations.
* 🔒 Add **user authentication & roles**.

---

## 📜 License

This project is licensed under the **MIT License** – feel free to use and modify it.

👉 Would you like me to also **add sample console screenshots (like the menus you shared)** into the README so it looks even more professional for GitHub?
