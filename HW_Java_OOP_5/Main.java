package org.example;

import org.example.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudent("Aynur","Shamsullin","25.01.1999");
        controller.createStudent("1","2","3");
        controller.createTeacher("Elisa","Thelyh","07.07.2001");

        controller.createStudentGroup();
        controller.printStudentGroup();
    }
}
