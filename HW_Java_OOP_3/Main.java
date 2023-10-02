package org.example;

import org.example.Contoller.UserController;
import org.example.Data.Flow;
import org.example.Data.Student;
import org.example.Data.StudentGroup;
import org.example.Data.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();

        Student student1 = new Student("Ivanov", "Ivan", "Ivanovich", "21.01.1997", 15L);
        Student student2 = new Student("Borisov", "Boris", "Borisovich", "11.08.1999", 11L);
        Student student3 = new Student("Maximov", "Maxim", "Maximovich", "09.11.2000", 19L);
        Student student4 = new Student("Alexeev", "Alex", "Alexeevich", "25.01.1999", 1L);
        StudentGroup group1 = new StudentGroup(new Teacher("1", "2", "3", "4", 999L), List.of((new Student("7", "8", "9", "10", 1L)), student2, student3));

        StudentGroup group2 = new StudentGroup(new Teacher("21", "41", "612", "213213", 2L), List.of(student3, student4));

        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(group1);
        studentGroups.add(group1);
        studentGroups.add(group1);

        List<StudentGroup> studentGroups1 = new ArrayList<>();
        studentGroups1.add(group2);
        studentGroups1.add(group1);
        Flow flow = new Flow(studentGroups);
        Flow flow1 = new Flow(studentGroups1);

        List<Flow> flows = List.of(flow,flow1);
        flows = userController.getSortedFlowsByGroupCount(flows);
        for (Flow groups : flows) {
            System.out.println(groups);
        }
    }
}
