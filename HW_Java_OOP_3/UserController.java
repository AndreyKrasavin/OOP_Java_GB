package org.example.Contoller;

import org.example.Data.*;
import org.example.Service.DataService;
import org.example.Service.FlowService;
import org.example.Service.StudentGroupService;
import org.example.View.UserView;

import java.util.List;

public class UserController {

    private final DataService dataService = new DataService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final UserView userView = new UserView();
    private final FlowService flowService = new FlowService();

    public void createStudent(String firstName, String secondName, String patronymic, String dateOfBirth){
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        List<User> userList = dataService.getUsers();
        userView.sendOnConsole(userList);
    }

    public void createStudentGroup(Teacher teacher, List<Student> students){
        studentGroupService.createStudentGroup(teacher, students);
        userView.sendOnConsoleUserGroup(studentGroupService.getStudentGroup());
    }

    public void createFlow(List<StudentGroup> groups){
        flowService.createFlow(groups);
        userView.sendOnConsoleFlow(flowService.getFlow());
    }
    public Student getStudentInStudentGroup(String firstName, String secondName){
        return studentGroupService.getStudentFromStudentGroup(firstName, secondName);
    }

    public List<Student> getSortedListStudentFromStudentGroup(){
        return studentGroupService.getSortedStudentGroup();
    }

    public List<Student> getSortedListByFIOStudentFromStudentGroup(){
        return studentGroupService.getSortedByFIOStudentGroup();
    }

    public List<Flow> getSortedFlowsByGroupCount(List<Flow> flows){
        return flowService.getSortedFlowsByGroupCount(flows);
    }
}
