package org.example.controller;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.model.Type;
import org.example.model.User;
import org.example.service.DataService;
import org.example.service.StudentGroupService;
import org.example.view.StudentGroupView;
import org.example.view.StudentView;

import java.util.List;

public class Controller {
    DataService dataService = new DataService();
    StudentView studentView = new StudentView();
    StudentGroupView studentGroupView = new StudentGroupView();
    StudentGroupService studentGroupService = new StudentGroupService();

    public void createStudent(String firstName, String secondName, String dateOfBirth){
        dataService.create(firstName,secondName,dateOfBirth,Type.STUDENT);
    }
    public void createTeacher(String firstName, String secondName, String dateOfBirth){
        dataService.create(firstName,secondName,dateOfBirth,Type.TEACHER);
    }
    public void getAllStudents(){
        List<Student> students = dataService.getAllStudent();
        for (Student s: students){
            studentView.printOnConsole(s);
        }
    }

    public void printStudentGroup(){
        studentGroupView.printStudentGroup(studentGroupService.getStudentGroup());
    }
    public void createStudentGroup(){
        studentGroupService.createStudentGroup(dataService.getTeacher(),dataService.getAllStudent());
    }
//      дз на семинаре и на сайте отличается
//    public List<Integer> getStudentsIdListInStudentsGroup(){
//        return studentGroupService.getStudentIdInStudentsGroup();
//    }
//
//    public int getTeacherIdInStudentsGroup(){
//        return studentGroupService.getTeacherIdInStudentsGroup();
//    }
}
