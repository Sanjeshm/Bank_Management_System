Problem Statement:

Develop a console-based banking system that allows users to:
-> Create and manage bank accounts
-> Perform transactions such as deposit, withdrawal, and transfer
-> Authenticate users securely using account number and PIN
-> View transaction history using a mini statement

Logic Used:

1. Object-Oriented Design

The system is built using core OOP principles:

~ Account -> Handles balance operations (deposit, withdraw)
~ Customer -> Manages multiple accounts and authentication
~ Bank -> Responsible for account creation and closure
~Transaction -> Executes and records transactions with status and timestamp
~MiniStatement -> Stores and displays transaction history

2. Transaction Handling

Transactions are executed through a dedicated Transaction class to ensure clean separation of logic.
Each transaction contains:

~ Transaction ID
~ Type (Deposit / Withdraw / Transfer)
~ Amount
~ Status (Success / Failed)
~ Timestamp

3. Authentication

Users must enter:
~ Account Number
~ PIN

Access is granted only if credentials match stored account data.

4. Mini Statement Feature

All successful transactions are stored.
generate() method displays complete transaction history.

Steps to Execute the Code:

1. Clone the repository
     git clone https://github.com/Sanjeshm/Bank_Management_System.git
     cd Bank_Management_System

2. Compile the Java files
     javac *.java

3. Run the application
     java Main

4.Usage Flow
  ~ Enter Account Number
  ~ Enter PIN
  ~ Choose from options:
      -> Deposit
      -> Withdraw
      -> Transfer
      -> View Mini Statement
