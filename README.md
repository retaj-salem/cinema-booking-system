<div align="center">

# 🎬 Cinema Booking System

**A Java application demonstrating Object-Oriented Programming through a cinema booking scenario**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-1a1a2e?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

</div>

---

## 📖 About the Project

Cinema Booking System is a group project that models a cinema: it manages **shows** (regular movies and IMAX), **customers**, and **bookings**. The main goal is to apply core OOP concepts in a realistic scenario.

## ✨ Features

- 🎥 Two kinds of shows: `MovieShow` and `ImaxShow`
- 👤 Customers who can make several bookings
- 🎟️ Booking, returning, and cancelling a booking, with status tracking
- 💰 Fine calculation and payment for late returns
- 🔎 Find a show by ID (throws a custom exception if it doesn't exist)
- 🔤 Sort shows by title
- ⚠️ Error handling for unavailable shows and missing customers

## 🧠 OOP Concepts Used

| Concept | Where |
|---------|-------|
| **Abstract class** | `Show` is the base class with an abstract `displayDetails()` |
| **Inheritance** | `MovieShow` and `ImaxShow` extend `Show` |
| **Interface** | `Borrowable` is implemented by both show types |
| **Polymorphism** | Each show type implements `displayDetails()` in its own way |
| **Custom exception** | `ShowNotFoundException` |
| **Comparable** | `Show` and `Customer` can be sorted |
| **Cloneable** | `Customer` supports `clone()` |
| **equals / hashCode** | Implemented in `Show` and `Customer` |
| **Encapsulation** | Private fields with getters and setters |

## 🗂️ Project Structure

```
GroupProject/
├── pom.xml
└── src/main/java/GroupProject/
    ├── CinemaApp.java               # Main class with test scenarios
    ├── Cinema.java                  # Manages shows, customers, and bookings
    ├── Show.java                    # Abstract base class
    ├── MovieShow.java               # Regular movie show
    ├── ImaxShow.java                # IMAX show
    ├── Borrowable.java              # Interface (checkOut / checkIn)
    ├── Booking.java                 # A booking with status and fine
    ├── Customer.java                # Customer and their bookings
    └── ShowNotFoundException.java   # Custom exception
```

## 🚀 Getting Started

### Requirements
- JDK 23 (the version set in `pom.xml`; change `maven.compiler.release` if you use another version)
- Maven, or open the project in NetBeans / IntelliJ

### Run
Open the project as a Maven project and run the `CinemaApp` class. It runs several tests and prints the results in the console (bookings, equals, clone, and error cases).

## 🔮 Future Work

- A graphical interface (JavaFX)
- Save data to files or a database
- Seat selection map
- Payment and ticket printing

---

<div align="center">

Made with ❤️ at Umm Al-Qura University

</div>
