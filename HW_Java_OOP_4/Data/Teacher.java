package org.example.data;

import java.util.Objects;

public class Teacher extends User implements Comparable<Teacher>{
    private Long teacherId;
    public Teacher(String firstName, String secondName, String patronymic, String dateOfBirth,Long teacherId) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "teacherId=" + teacherId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherId, teacher.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId);
    }

    @Override
    public int compareTo(Teacher o) {
        return this.getTeacherId().compareTo(o.getTeacherId());
    }
}
