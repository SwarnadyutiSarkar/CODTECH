package main.java.student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public double calculateAverageGrade() {
        if (students.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return (double) total / students.size();
    }

    public List<Student> getStudents() {
        return students;
    }
}
