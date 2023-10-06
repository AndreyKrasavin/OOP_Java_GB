package org.example.view;

import org.example.data.Teacher;

import java.util.List;

public class TeacherView implements UserView<Teacher> {
    @Override
    public void sendOnConsole(List<Teacher> users) {
        for(Teacher t: users){
            System.out.println(t.toString());
        }
    }
}
