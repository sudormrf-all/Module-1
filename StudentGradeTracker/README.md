# Student Grade Tracker

## Description
Student Grade Tracker is a Java console application that allows a user to manage student grade records. The program supports adding students, entering grades, viewing averages, removing students, saving records to a file, and loading records from a file.

## Purpose of the Software
The purpose of this project is to demonstrate core Java programming concepts through a practical application. It was designed to meet the CSE 310 Java module requirements by using variables, expressions, conditionals, loops, functions, classes, a Java Collection Framework structure, and file input and output.

## Features
- Add a student
- Add a grade to an existing student
- Display all students with grade counts and averages
- Display a class summary
- Remove a student
- Save records to a text file
- Load records from a text file

## Java Concepts Demonstrated
- Variables and expressions
- Conditionals
- Loops
- Functions (methods)
- Classes and objects
- Java Collection Framework using `ArrayList`
- File reading and writing

## Development Environment
- Java / OpenJDK
- Visual Studio Code or any editor with terminal support
- Command line using `javac` and `java`

## Running the Program
1. Open a terminal in the project folder.
2. Compile the program:
   ```bash
   javac *.java
   ```
3. Run the program:
   ```bash
   java Main
   ```
4. Follow the menu prompts.

## File Used by the Program
The application stores saved data in a file named `students.txt`.

## Project Structure
- `Main.java` handles the program menu and user interaction.
- `Student.java` defines the student object and grade calculations.
- `GradeBook.java` manages the list of students using `ArrayList`.
- `FileManager.java` handles saving and loading student data.

## Demonstration Video
Video URL: 

## GitHub Repository
Repository URL: 

## Useful Websites
- https://docs.oracle.com/en/java/
- https://www.w3schools.com/java/
- https://www.geeksforgeeks.org/file-handling-in-java/

## Future Work
- Add letter-grade conversion
- Allow updating an existing grade entry
- Sort students by average or name
- Add support for individual assignment categories