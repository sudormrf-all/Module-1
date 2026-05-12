public class Student {
    private String name;
    private int gradeCount;
    private double totalPoints;

    public Student(String name) {
        this.name = name;
        this.gradeCount = 0;
        this.totalPoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getGradeCount() {
        return gradeCount;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        totalPoints += grade;
        gradeCount++;
    }

    public double getAverage() {
        if (gradeCount == 0) {
            return 0;
        }
        return totalPoints / gradeCount;
    }

    public String toFileString() {
        return name + "," + gradeCount + "," + totalPoints;
    }

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