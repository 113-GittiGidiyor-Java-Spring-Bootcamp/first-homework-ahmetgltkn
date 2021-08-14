package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PermanentInstructor extends User {

    private double fixedSalary;
    private String phoneNumber;

    @OneToMany(mappedBy = "permanentInstructor")
    private List<Course> courses = new ArrayList<>();


    public PermanentInstructor(){}


    public PermanentInstructor( String name, String address, double fixedSalary, String phoneNumber) {
        super(name, address);
        this.fixedSalary = fixedSalary;
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
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
        if (!super.equals(o)) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return Double.compare(that.fixedSalary, fixedSalary) == 0 && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fixedSalary, phoneNumber);
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
