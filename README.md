# 📌 Team Task Manager (Full-Stack)

A complete full-stack task management application designed to help teams create projects, assign tasks, and track operational progress. The system features a secure **Java Spring Boot REST API** backend, a **MySQL database**, and a clean single-page web interface with role-based access control (**Admin** and **Member**).

---

## 🌐 Live Application Links

* **Live Backend API (Railway):** [https://task-manager-backend-production-16de.up.railway.app](https://task-manager-backend-production-16de.up.railway.app)
* **GitHub Repository:** [Insert your GitHub URL here]
* **Demo Video:** [Insert link to your 2-5 min walkthrough video]

---

## 🚀 Key Features

* **Authentication & Authorization:** Secure signup and login powered by **JSON Web Tokens (JWT)** and password hashing.
* **Role-Based Access Control (RBAC):**
  * **Admins:** Can create, update, and manage tasks for the entire team.
  * **Members:** Can view real-time tasks and track work progress.
* **Database Persistence:** Real-time data storage in a cloud-hosted MySQL database on Railway.
* **Responsive UI Dashboard:** Dynamic interface built using HTML5, Vanilla JavaScript, and styled with Tailwind CSS.

---

## 🛠️ Tech Stack

### Backend & Cloud
* **Language:** Java 17+
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Spring Security)
* **Security:** JWT (JSON Web Tokens) for authentication
* **Database:** MySQL
* **Deployment Platform:** Railway

### Frontend
* **Language:** Vanilla JavaScript (ES6+), HTML5
* **Styling Framework:** Tailwind CSS (via CDN)
* **Host Platform:** GitHub Pages / Netlify

---

## 📐 Project Architecture & Database

The backend architecture follows a clean MVC/layered pattern to separate concerns:
* **Controller Layer:** Exposes REST endpoints and validates incoming payloads.
* **Service Layer:** Handles core business logic and security policies.
* **Repository Layer:** Communicates with the MySQL database using Spring Data JPA.
