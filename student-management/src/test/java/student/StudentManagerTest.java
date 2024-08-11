package test.java.student;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.student.Student;

import java.util.List;

public class StudentManagerTest {

    private StudentManager studentManager;

    @BeforeClass
    public void setUp() {
        Student = new StudentManager();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("John Doe", 85);
        studentManager.addStudent(student);

        List<Student> students = studentManager.getStudents();
        Assert.assertEquals(students.size(), 1);
        Assert.assertEquals(students.get(0).getName(), "John Doe");
        Assert.assertEquals(students.get(0).getGrade(), 85);
    }

    @Test
    public void testFindStudentByName() {
        Student student = new Student("Jane Smith", 90);
        studentManager.addStudent(student);

        Student foundStudent = studentManager.findStudentByName("Jane Smith");
        Assert.assertNotNull(foundStudent);
        Assert.assertEquals(foundStudent.getName(), "Jane Smith");
        Assert.assertEquals(foundStudent.getGrade(), 90);
    }

    @Test
    public void testCalculateAverageGrade() {
        studentManager.addStudent(new Student("Alice", 80));
        studentManager.addStudent(new Student("Bob", 70));
        studentManager.addStudent(new Student("Charlie", 90));

        double average = studentManager.calculateAverageGrade();
        Assert.assertEquals(average, 80.0);
    }
}
