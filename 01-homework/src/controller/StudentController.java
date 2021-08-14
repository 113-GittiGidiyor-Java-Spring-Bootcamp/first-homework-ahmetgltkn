package controller;

import model.Course;
import model.Student;
import service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public StudentController() {
    }

    public Student getStudent(int id) {
        return studentService.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    public void createStudent(Student student) {
        studentService.saveToDatabase(student);
    }

    public void updateStudent(Student student, int id) {
        studentService.updateOnDatabase(student, id);
    }

    public void deleteStudent(int id) {
        studentService.deleteFromDatabase(id);
    }

    public List<Course> getCoursesOfStudent(int studentId) {
        return studentService.findCoursesOfStudent(studentId);
    }
}
