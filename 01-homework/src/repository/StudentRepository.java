package repository;

import model.Course;

import java.util.List;

public interface StudentRepository {
    List<Course> findCoursesOfStudent(int var1);
}
