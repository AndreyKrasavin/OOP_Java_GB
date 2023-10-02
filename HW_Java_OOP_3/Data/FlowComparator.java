package org.example.Data;

import java.util.Comparator;

public class FlowComparator implements Comparator<Flow> {
    @Override
    public int compare(Flow o1, Flow o2) {
        return o1.getStudentGroups().size() - o2.getStudentGroups().size();
    }
}
