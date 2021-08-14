package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private double courseCredit;

    public Course() {
    }

    public Course( String courseName, String courseCode, double courseCredit) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
    }

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    private VisitingResearcher visitingResearcher;

    public VisitingResearcher getVisitingResearcher() {
        return visitingResearcher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public PermanentInstructor getPermanentInstructor() {
        return permanentInstructor;
    }

    public void setPermanentInstructor(PermanentInstructor permanentInstructor) {
        this.permanentInstructor = permanentInstructor;
    }

    public void setVisitingResearcher(VisitingResearcher visitingResearcher) {
        this.visitingResearcher = visitingResearcher;
    }

    @ManyToOne
    private PermanentInstructor permanentInstructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Double.compare(course.courseCredit, courseCredit) == 0 && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseCode, courseCredit);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseCredit=" + courseCredit +
                '}';
    }
}
