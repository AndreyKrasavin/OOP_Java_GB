package org.example.Data;

public class Teacher extends User{
    private Long teacherId;

    public Teacher(String firstName, String secondName, String patronymic, String dateOfBirth, Long teacherId) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "teacherId=" + teacherId +
                '}';
    }
}
