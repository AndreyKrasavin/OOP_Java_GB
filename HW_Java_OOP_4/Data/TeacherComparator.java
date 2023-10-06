package org.example.data;

public class TeacherComparator extends UserComparator<Teacher>{
    @Override
    public int compare(Teacher o1, Teacher o2) {
        int resultOfComparing = o1.getSecondName().compareTo(o2.getSecondName());
        if (resultOfComparing == 0) {
            resultOfComparing = o1.getFirstName().compareTo(o2.getFirstName());
            if (resultOfComparing == 0) {
                resultOfComparing = o1.getPatronymic().compareTo(o2.getPatronymic());
                if (resultOfComparing == 0) {
                    return o1.getTeacherId().compareTo(o2.getTeacherId());
                }
            }
        } else {
            return resultOfComparing;
        }
        return resultOfComparing;
    }
    }
