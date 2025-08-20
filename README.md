# 🛒 E-Commerce Hibernate Application

This project is a simple **E-Commerce backend** built using **Hibernate** to demonstrate ORM concepts, entity relationships, and CRUD operations. It showcases step-by-step implementation of Hibernate mappings with a modular DAO structure.

---

## 🚀 Features

- ✅ **User CRUD** – Create, Read, Update, Delete operations for `User` entity.  
- ✅ **One-to-One Mapping** – `User ↔ Address` relationship with cascade and orphan removal support.  
- ⏳ **Upcoming** – One-to-Many (`User ↔ Orders`).  
- ⏳ **Upcoming** – Many-to-Many (`Product ↔ Category`).  
- ⚙️ **Hibernate Configuration** using `hibernate.cfg.xml` (no Spring Data JPA).  
- 🗂️ **DAO Layer** for clean database interaction.  

---

## 🛠️ Tech Stack

- ☕ **Java 8+**  
- 🏗️ **Hibernate ORM**  
- 🐬 **MySQL** (adaptable to other RDBMS)  
- 📦 **Maven** (dependency management)  

---

## 📂 Project Structure

```

src/main/java
├── com.ecommerce.model   # Entities (User, Address, Order, Product, Category)
├── com.ecommerce.dao     # DAO classes for DB operations
├── com.ecommerce.util    # Hibernate utility (SessionFactory)
└── com.ecommerce.App     # Main entry point

````

---

## ⚡ Getting Started

Follow these steps to run the project locally:

### 1️⃣ Clone the repository
```bash
git clone https://github.com/<username>/<repo-name>.git
cd <repo-name>
````

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

* Learning **Hibernate ORM** from scratch.
* Practicing **entity relationships** (One-to-One, One-to-Many, Many-to-Many).
* Demonstrating **CRUD operations without Spring Data JPA**.
* Serving as a **starter template** for Hibernate-based applications.

---

## 🧑‍🤝‍🧑 Contributors

A huge thanks to the amazing contributors of this project ❤️

| Name                                                              | GitHub                  | Role                                       |
| ----------------------------------------------------------------- | ----------------------- | ------------------------------------------ |
| [**Ranjay Devendra Singh**](https://github.com/ranjay24)          | 🐙 `@ranjay24`          | Hibernate Associations Creator |
| [**Samarth Deelip Kalegaonkar**](https://github.com/SamK1828) | 🐙 `@SamK1828` | Repository Creator & Backend Developer            |

---

## 🔮 Future Enhancements

* 🛍️ Implement **One-to-Many mapping** for Orders.
* 🗃️ Implement **Many-to-Many mapping** for Product & Category.
* 🔑 Add **Authentication & Authorization**.
* 🌐 Expose **REST APIs** for external integrations.
* 📊 Add **unit tests with JUnit & Mockito**.

---

## 📜 License

This project is licensed under the **MIT License** – feel free to use and modify it.
