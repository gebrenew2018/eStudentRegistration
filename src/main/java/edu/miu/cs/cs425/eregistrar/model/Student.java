package edu.miu.cs.cs425.eregistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    @NotBlank(message = "Student Number is required!")
    private String studentNumber;
//    @NotBlank(message = "First Name is required!")
    private String firstName;
    private String middleName;
//    @NotBlank(message = "Last Name is required!")
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private float cGpa;
//    @NotBlank(message = "This is required!")
    private boolean isInternational;

    public Student() {
        super();
    }

    public Student(String studentNumber, String firstName,
                   String middleName, String lastName, LocalDate enrollmentDate,
                   float cGpa, boolean isInternational) {
        this.studentNumber=studentNumber;
        this.cGpa=cGpa;
        this.isInternational=isInternational;
        this.firstName=firstName;
        this.lastName=lastName;
        this.middleName=middleName;
        this.enrollmentDate=enrollmentDate;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setcGpa(float cGpa) {
        this.cGpa = cGpa;
    }

    public void setIsInternational(boolean international) {
        isInternational = international;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public float getcGpa() {
        return cGpa;
    }

    public boolean getIsInternational() {
        return isInternational;
    }
}
