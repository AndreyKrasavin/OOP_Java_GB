package org.example.service;

import org.example.data.Student;

import java.util.List;

public class StudentService implements UserService<Student>{

    private List<Student> students;
    private int studentId;
    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, String dateOfBirth) {
        Long countMaxId = 0L;
        for (Student student: students){
            if (student.getStudentId() > countMaxId){
                countMaxId = student.getStudentId();
            }
        }
        countMaxId++;
        Student student = new Student(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        students.add(student);
    }
}
