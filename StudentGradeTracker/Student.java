public class Student {
    private String name;
    private int gradeCount;
    private double totalPoints;

    // Creates a student object with a name and initializes grade tracking values.
    public Student(String name) {
        this.name = name;
        this.gradeCount = 0;
        this.totalPoints = 0;
    }

    // Returns the student's name.
    public String getName() {
        return name;
    }

    // Returns the number of grades entered for this student.
    public int getGradeCount() {
        return gradeCount;
    }

    // Returns the total number of grade points accumulated by this student.
    public double getTotalPoints() {
        return totalPoints;
    }

    // Adds one grade to the student and updates the running total and count.
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        totalPoints += grade;
        gradeCount++;
    }

    // Calculates and returns the student's average grade.
    public double getAverage() {
        if (gradeCount == 0) {
            return 0;
        }
        return totalPoints / gradeCount;
    }

    // Converts the student object into a text line that can be saved to a file.
    public String toFileString() {
        return name + "," + gradeCount + "," + totalPoints;
    }

    // Rebuilds a student object from a line that was read from the file.
    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid student record in file.");
        }

        Student student = new Student(parts[0]);
        student.gradeCount = Integer.parseInt(parts[1]);
        student.totalPoints = Double.parseDouble(parts[2]);
        return student;
    }

    // Returns a formatted string that displays the student's current record.
    @Override
    public String toString() {
        return String.format(
            "Name: %s | Grades Entered: %d | Average: %.2f",
            name,
            gradeCount,
            getAverage()
        );
    }
}