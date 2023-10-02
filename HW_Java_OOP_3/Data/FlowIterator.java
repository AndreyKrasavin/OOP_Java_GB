package org.example.Data;

import java.util.Iterator;
import java.util.List;

public class FlowIterator implements Iterator<StudentGroup> {
    private int count;
    private final List<StudentGroup> studentGroups;

    public FlowIterator(Flow flow) {
        this.count = 0;
        this.studentGroups = flow.getStudentGroups();
    }

    @Override
    public boolean hasNext() {
        return count < studentGroups.size() - 1;
    }

    @Override
    public StudentGroup next() {
        if (!hasNext()) {
            return null;
        }
        count++;
        return studentGroups.get(count);
    }
}
