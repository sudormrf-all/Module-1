import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "students.txt";

    // Starts the program, creates the grade book, and keeps the menu running until the user exits.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeBook gradeBook = new GradeBook();
        boolean running = true;

        System.out.println("====================================");
        System.out.println("      Student Grade Tracker");
        System.out.println("====================================");

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    addStudentFlow(scanner, gradeBook);
                    break;
                case 2:
                    addGradeFlow(scanner, gradeBook);
                    break;
                case 3:
                    gradeBook.displayStudents();
                    break;
                case 4:
                    saveFlow(gradeBook);
                    break;
                case 5:
                    loadFlow(gradeBook);
                    break;
                case 6:
                    removeStudentFlow(scanner, gradeBook);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting program. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 7.");
            }

            System.out.println();
        }

        scanner.close();
    }

    // Displays the main menu options for the user.
    private static void printMenu() {
        System.out.println("Menu");
        System.out.println("1. Add student");
        System.out.println("2. Add grade to student");
        System.out.println("3. View all students");
        System.out.println("4. Save data to file");
        System.out.println("5. Load data from file");
        System.out.println("6. Remove student");
        System.out.println("7. Exit");
    }

    // Handles the user flow for creating and adding a new student record.
    private static void addStudentFlow(Scanner scanner, GradeBook gradeBook) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty.");
            return;
        }

        if (gradeBook.addStudent(name)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("A student with that name already exists.");
        }
    }

    // Handles the user flow for entering a grade for an existing student.
    private static void addGradeFlow(Scanner scanner, GradeBook gradeBook) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        double grade = readDouble(scanner, "Enter grade (0-100): ");

        if (gradeBook.addGradeToStudent(name, grade)) {
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Student not found or grade was outside the valid range.");
        }
    }

    // Handles the user flow for removing a student from the grade book.
    private static void removeStudentFlow(Scanner scanner, GradeBook gradeBook) {
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine().trim();

        if (gradeBook.removeStudent(name)) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Saves all current student records to the file used by the program.
    private static void saveFlow(GradeBook gradeBook) {
        try {
            FileManager.saveStudents(FILE_NAME, gradeBook.getStudents());
            System.out.println("Student data saved to " + FILE_NAME + ".");
        } catch (Exception ex) {
            System.out.println("Error saving file: " + ex.getMessage());
        }
    }

    // Loads student records from the file and replaces the current in-memory list.
    private static void loadFlow(GradeBook gradeBook) {
        try {
            gradeBook.setStudents(FileManager.loadStudents(FILE_NAME));
            System.out.println("Student data loaded from " + FILE_NAME + ".");
        } catch (Exception ex) {
            System.out.println("Error loading file: " + ex.getMessage());
        }
    }

    // Reads a whole number from the user and keeps asking until the input is valid.
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    // Reads a decimal number from the user and keeps asking until the input is valid.
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}