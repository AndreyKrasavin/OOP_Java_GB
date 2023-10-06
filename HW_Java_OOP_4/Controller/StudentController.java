package org.example.contoller;

import org.example.data.Student;
import org.example.service.StudentService;
import org.example.view.StudentView;

public class StudentController implements UserController<Student>{
    StudentService studentService = new StudentService();
    StudentView studentView = new StudentView();
    @Override
    public void create(String firstName, String secondName, String patronymic, String dateOfBirth) {
        studentService.create(firstName,secondName,patronymic,dateOfBirth);
        studentView.sendOnConsole(studentService.getAll());
    }
}
