import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Student> students;

    public GradeBook() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean addStudent(String name) {
        if (findStudent(name) != null) {
            return false;
        }

        students.add(new Student(name));
        return true;
    }

    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

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

    public boolean removeStudent(String name) {
        Student student = findStudent(name);
        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

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