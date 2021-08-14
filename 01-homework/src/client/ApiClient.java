package client;

import controller.CourseController;
import controller.StudentController;
import model.Course;
import model.PermanentInstructor;
import model.Student;
import model.VisitingResearcher;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class ApiClient {

    public static void main(String[] args) {

        Course course1 = new Course("JAVA", "101", 10);
        Course course2 = new Course("C#", "101132", 10312);

        Student student1 = new Student("Ahmet", "Gültekin", LocalDate.of(1997, Month.JANUARY, 6), "Erkek");

        VisitingResearcher visitingResearcher1 = new VisitingResearcher("Koray", "istanbul", 123, "555");

        PermanentInstructor permanentInstructor1 = new PermanentInstructor("Koray", "istanbul", 123, "123");

        course1.getStudents().add(student1);
        permanentInstructor1.getCourses().add(course1);
        visitingResearcher1.getCourses().add(course2);
        course1.setPermanentInstructor(permanentInstructor1);


        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        CourseController courseController = new CourseController();
        courseController.saveCourse(course2);

        StudentController studentController = new StudentController();
        studentController.createStudent(student1);

        try {
            em.getTransaction().begin();
            em.persist(course1);
            em.persist(student1);
            em.persist(visitingResearcher1);
            em.persist(permanentInstructor1);
            em.getTransaction().commit();

            System.out.println("All data persisted");

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }



    }
}
