package org.example.service;

import org.example.model.Student;
import org.example.model.StudentGroup;
import org.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupService {
    private StudentGroup studentGroup;

    public StudentGroupService() {
    }

    public StudentGroup createStudentGroup(Teacher t, List<Student> students) {
        this.studentGroup = new StudentGroup(t, students);
        return this.studentGroup;
    }

    public void addStudent(Student student) {
        if (!this.getStudentList().contains(student)) {
            this.getStudentList().add(student);
        }
    }

    public List<Student> getStudentList() {
        return this.studentGroup.getStudentList();
    }

    public Teacher getTeacher() {
        return this.studentGroup.getTeacher();
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    //      дз на семинаре и на сайте отличается
//    public List<Integer> getStudentIdInStudentsGroup(){
//        List<Integer> studentsId = new ArrayList<>();
//        for (Student s: getStudentList()){
//            studentsId.add(s.getStudentId());
//        }
//        return studentsId;
//    }
//
//    public int getTeacherIdInStudentsGroup(){
//        return this.studentGroup.getTeacher().getTeacherId();
//    }


}
