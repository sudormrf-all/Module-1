import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
    public static void saveStudents(String fileName, ArrayList<Student> students) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Student student : students) {
            writer.write(student.toFileString());
            writer.newLine();
        }

        writer.close();
    }

    public static ArrayList<Student> loadStudents(String fileName) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                students.add(Student.fromFileString(line));
            }
        }

        reader.close();
        return students;
    }
}