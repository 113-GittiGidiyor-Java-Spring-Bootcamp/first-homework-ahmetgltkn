package service;

import model.Course;
import model.Student;
import repository.CrudRepository;
import repository.StudentRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");


    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("From Student", Student.class).getResultList();
    }



    @Override
    public Student findById(int id) {
        return entityManager.createQuery("from Student s where s.id=:studentId",Student.class).setParameter("studentId", id).getSingleResult();
    }

    @Override
    public void saveToDatabase(Student object) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(object);
            this.entityManager.getTransaction().commit();
        } catch (Exception var6) {
            this.entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(this.entityManager);
        }
    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Student object, int id) {

        try {
            this.entityManager.getTransaction().begin();
            Student updatedStudent = entityManager.find(Student.class, id);
            updatedStudent.setAddress(object.getAddress());
            updatedStudent.setName(object.getName());
            updatedStudent.setBirthDate(object.getBirthDate());
            updatedStudent.setGender(object.getGender());
            this.entityManager.merge(updatedStudent);
            this.entityManager.getTransaction().commit();
        } catch (Exception var7) {
            this.entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(this.entityManager);
        }

    }



    @Override
    public List<Course> findCoursesOfStudent(int var1) {
        return findById(var1).getCourses();
    }
}
