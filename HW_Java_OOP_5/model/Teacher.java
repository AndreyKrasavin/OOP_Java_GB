package org.example.model;

public class Teacher extends User{
    private int teacherId;

    public Teacher(String firstName, String lastName, String dateOfBirth, int teacherId) {
        super(firstName, lastName, dateOfBirth);
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", Rank: " + this.getClass().getSimpleName() +
                ", TeacherId: " + teacherId;
    }
}
