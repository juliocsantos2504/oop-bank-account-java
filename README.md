# 💳 OOP Bank Account (Java)

This is a simple Java console application that simulates a bank account system with basic operations such as deposit, withdrawal, bill payment, and overdraft management. The project was built with a focus on **Object-Oriented Programming (OOP)** principles and runs entirely in the **command-line interface (CLI)**.

## 📌 Features

- Check account balance
- Check overdraft usage and limit
- Make deposits
- Make withdrawals
- Pay bills (simulated as withdrawals)
- Automatically apply fees when overdraft is used
- Input validation for all financial operations

## 🧠 Business Rules

- The initial deposit is provided by the user when the account is created.
- The overdraft limit is based on the initial deposit amount:
  - If **≤ R$500.00** → fixed overdraft limit of **R$50.00**
  - If **> R$500.00** → overdraft limit is **50% of the initial deposit**
- If the overdraft is used and later covered by a deposit, a **20% fee** is automatically applied based on the used overdraft amount.

## ⚙️ Technologies

- Java 21
- Console-based application (CLI)
- Object-Oriented Programming (OOP)
- Git version control

## 🚀 How to Run

1. **Clone the repository:**

```bash
git clone https://github.com/juliocsantos2504/oop-bank-account-java.git

2. **Compile the Java files:**
javac Main.java BankAccount.java

3. **Run the application:**
java Main


📂 Project Structure

oop-bank-account-java/
├── BankAccount.java   // Class with bank account logic
├── Main.java          // CLI interface for user interaction
└── README.md          // Project documentation

📘 Concepts Applied
Encapsulation

Constructors

Instance methods

Business logic separation

Input validation

Scanner for user input

Control flow using switch and do-while loop

🤝 Contributions
This project was created for educational purposes. Feel free to suggest improvements, open issues, or submit pull requests.

📄 License
This project is open-source and licensed under the MIT License. See the LICENSE file for more details (optional).

Developed with 💻 by Julio C. dos Santos
