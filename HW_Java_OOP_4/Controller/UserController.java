package org.example.contoller;

import org.example.data.User;

public interface UserController <T extends User>{
    void create(String firstName,String secondName,String patronymic,String dateOfBirth);
}
