package org.example.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flow implements Iterable<StudentGroup>,Comparable<StudentGroup>{
    private List<StudentGroup> studentGroups;

    public Flow(List<StudentGroup> studentGroups) {
        this.studentGroups = new ArrayList<>(studentGroups);
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new FlowIterator(this);
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    @Override
    public String toString() {
        return "Flow" + studentGroups;
    }

    @Override
    public int compareTo(StudentGroup o) {
        return 0;
    }
}
