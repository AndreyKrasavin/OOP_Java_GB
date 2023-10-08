package org.example.model;

public class Student extends User {
    private int StudentId;

    public Student(String firstName, String lastName, String dateOfBirth, int studentId) {
        super(firstName, lastName, dateOfBirth);
        StudentId = studentId;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Rank: " + this.getClass().getSimpleName() +
                ", StudentId: " + StudentId;
    }
}
