package org.example.Data;

import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student> {
    private List<Student> studentList;
    private Teacher teacher;

    public StudentGroup(Teacher teacher, List<Student> studentList) {
        this.studentList = studentList;
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "\nStudentGroup:" +
                "\nStudents:" + studentList +
                ",\nTeacher: " + teacher +
                '\n';
    }

    @Override
    public StudentGroupIterator iterator() {
        return new StudentGroupIterator(this);
    }
}
