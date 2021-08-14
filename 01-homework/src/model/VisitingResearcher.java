package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class VisitingResearcher extends User {

    private double hourlySalary;
    private String phoneNumber;

    @OneToMany(mappedBy = "visitingResearcher")
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public VisitingResearcher() {
    }

    public VisitingResearcher(String name, String address, double hourlySalary, String phoneNumber) {
        super(name, address);
        this.hourlySalary = hourlySalary;
        this.phoneNumber = phoneNumber;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return Double.compare(that.hourlySalary, hourlySalary) == 0 && phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hourlySalary, phoneNumber);
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
