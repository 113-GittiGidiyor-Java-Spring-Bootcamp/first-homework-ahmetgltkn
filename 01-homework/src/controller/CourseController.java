package controller;

import model.Course;
import service.CourseService;

import java.util.List;

public class CourseController {

    private CourseService courseService = new CourseService();

    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }
    public List<Course> findAllCourse(){
        return courseService.findAll();
    }
    public void deleteCourse(int id){
        courseService.deleteFromDatabase(id);
    }
    public void updateCourse(Course course,int id){
        courseService.updateOnDatabase(course,id);
    }
}
