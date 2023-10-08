package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.model.Type;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    List<User> users;
    public DataService() {
        this.users = new ArrayList<>();
    }

    public void create(String firstName, String secondName, String dateOfBirth, Type type){
        int id = getFreeId(type);
        if (Type.STUDENT == type){
            Student student = new Student(firstName,secondName,dateOfBirth,id);
            users.add(student);
        }
        if (Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName,secondName,dateOfBirth,id);
            users.add(teacher);
        }
    }

    private int getFreeId(Type type){

        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for(User user:users){
            if (user instanceof Teacher && !itsStudent){
                lastId = ((Teacher)user).getTeacherId() + 1;
            }
            if (user instanceof Student && itsStudent){
                lastId = ((Student)user).getStudentId() + 1;
            }
        }
        return lastId;
    }

    public User getUserById(Type type,int id){
        boolean itsStudent = Type.STUDENT == type;
        for (User user:users){
            if (user instanceof Teacher && !itsStudent && ((Teacher)user).getTeacherId() == id){
                return user;
            }
            if (user instanceof Student && itsStudent && ((Student)user).getStudentId() == id){
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Student> getAllStudent(){
        List<Student> result = new ArrayList<>();
        for (User u: users){
            if (u instanceof Student){
                result.add((Student)u);
            }
        }
        return result;
    }

    public Teacher getTeacher(){
        for (User u : users){
            if (u instanceof Teacher){
                return (Teacher)u;
            }
        }
        return null;
    }
}
