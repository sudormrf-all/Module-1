import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Student> students;

    // Creates a grade book and initializes the student collection.
    public GradeBook() {
        students = new ArrayList<>();
    }

    // Returns the current list of students in the grade book.
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Replaces the current student list with a new list, usually after loading from a file.
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // Adds a new student if a student with the same name does not already exist.
    public boolean addStudent(String name) {
        if (findStudent(name) != null) {
            return false;
        }

        students.add(new Student(name));
        return true;
    }

    // Searches for a student by name and returns the matching object if found.
    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // Adds a grade to the selected student if the student exists and the grade is valid.
    public boolean addGradeToStudent(String name, double grade) {
        Student student = findStudent(name);
        if (student == null) {
            return false;
        }

        try {
            student.addGrade(grade);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    // Removes a student from the grade book if the student exists.
    public boolean removeStudent(String name) {
        Student student = findStudent(name);
        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    // Displays all student records and prints a summary of the class average.
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double totalAverage = 0;

        System.out.println("Student Records");
        System.out.println("------------------------------------------");
        for (Student student : students) {
            System.out.println(student);
            totalAverage += student.getAverage();
        }
        System.out.println("------------------------------------------");
        System.out.printf("Total Students: %d%n", students.size());
        System.out.printf("Class Average of Student Averages: %.2f%n", totalAverage / students.size());
    }
}