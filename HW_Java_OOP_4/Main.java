package org.example;

import org.example.contoller.TeacherController;
import org.example.service.TeacherService;
import org.example.view.TeacherView;

public class Main {
    public static void main(String[] args) {
        TeacherController tController = new TeacherController();
        tController.create("Liza","Tselyh","Alexandrovna","07.07.2001");
        tController.create("Aynur","Shamsullin","Damirovich","25.01.1999");
//        tController.showAll();
        tController.editTeacher();
        tController.showAll();

    }
}
