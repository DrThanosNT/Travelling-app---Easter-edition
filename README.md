## Travelling-app — Easter Edition
PAPEI Travellers – A console-based travel management application with data storage, itineraries, sightseeing, and restaurant planning.

Table of Contents
About

Getting Started

Prerequisites

Build and Run

Features

Built With

License

About
PAPEI Travellers is a console application that allows users to organize their trips by creating an account and recording the following:

Accommodation details during the trip

Sightseeing locations they wish to visit

Restaurants and recommended routes

Travel budget and expenses

The application uses serialization to store user data, allowing users to resume planning from where they left off in previous sessions.

Getting Started
Prerequisites
Java (version 11 or higher)

A Java IDE such as IntelliJ IDEA or Eclipse

File system access for reading and writing .ser files

Build and Run
Clone or open the project in your preferred IDE

Compile and run the Main class

On first run, a data file is created automatically if it doesn't already exist

Use the console menu to begin managing your trip

Features
Sign Up / Log In: User authentication with password saving

Accommodation: Set travel dates and calculate cost of stay

Sightseeing: Add, view, review, and calculate total cost of visits

Restaurants: Search for, add, and remove restaurant entries

Routes: Create custom routes with multiple stops

Anti-Bot Verification: Basic numeric challenge to prevent automated inputs

Serialization: Automatic saving and loading of user data

Built With
Java SE 11

Object Serialization

Scanner and File I/O

License
This project was developed for educational purposes only.
It is not licensed for commercial use.
