package org.example.view;

import org.example.data.User;

import java.util.List;

public interface UserView <T extends User>{
    public void sendOnConsole(List<T> users);
}
