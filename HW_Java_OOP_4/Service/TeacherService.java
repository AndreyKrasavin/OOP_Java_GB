TeacherService.javapackage org.example.service;


import org.example.data.Student;
import org.example.data.Teacher;
import org.example.data.TeacherComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TeacherService implements UserService<Teacher> {
    List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, String dateOfBirth) {
        Long countMaxId = 0L;

            for (Teacher t : teachers) {
                if (t.getTeacherId() > countMaxId) {
                    countMaxId = t.getTeacherId();
                }
            }

        countMaxId++;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        teachers.add(teacher);
    }

    public Teacher select(Long teacherId) {
        Teacher t = null;
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId().equals(teacherId)) {
                t = teacher;
            }
        }
        if (t == null) {
            System.out.printf("Teacher with ID: %d not found.", teacherId);
        }
        return t;
    }


    public void editTeacher() {
        System.out.println("-----You entered to the teacher editor-----");
        int editField;
        long teacherId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select teacher by ID: ");
        teacherId = sc.nextLong();
        Teacher t = select(teacherId);
        System.out.println(t.toString());
        System.out.println("""
                Select field to be edited:
                1 - first name
                2 - second name
                3 - patronymic
                4 - date of birth
                """);
        editField = sc.nextInt();
        int teacherIndexInList = teachers.indexOf(t);
        System.out.println("Enter field value: ");
        String newFieldValue = sc.next();
        switch (editField) {
            case 1 -> t.setFirstName(newFieldValue);
            case 2 -> t.setSecondName(newFieldValue);
            case 3 -> t.setPatronymic(newFieldValue);
            case 4 -> t.setDateOfBirth(newFieldValue);
            default -> System.out.println("Wrong field.Closing editor...");
        }
        teachers.set(teacherIndexInList,t);
    }
}
