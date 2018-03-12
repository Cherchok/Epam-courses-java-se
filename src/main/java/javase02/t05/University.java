package javase02.t05;

import java.util.LinkedHashSet;
import java.util.Set;

public class University {
    private Set<Group> groups;

    public University() {
        groups = new LinkedHashSet<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public Set<Group> getGroups(Student student) {
        Set<Group> targetGroup = new LinkedHashSet<>();
        for (Group g : groups) {
            if (g.getStudents().contains(student)) {
                targetGroup.add(g);
            }
        }
        return targetGroup;
    }

    public void studentMarks(Student student) {
        Set<Group> groups = getGroups(student);
        System.out.println(student.getName() + " " + student.getSurname() + " results:");
        for (Group g : groups) {
            if (g.getStudents().contains(student)) {
                if (g.getSubjects().name().equals("MATH") || g.getSubjects().name().equals("PROGRAMMING")) {
                    Double[] mark = new Double[g.getMark(student).length];
                    for (int i = 0; i < mark.length; i++) {
                        mark[i] = (Double) g.getMark(student)[i];
                    }
                    System.out.print(g.getSubjects().name() + " : ");
                    for (Double dMark : mark) {
                        System.out.print(dMark + "  ");
                        System.out.println();
                    }
                } else {
                    Integer[] mark = new Integer[g.getMark(student).length];
                    for (int i = 0; i < mark.length; i++) {
                        mark[i] = (Integer) g.getMark(student)[i];
                    }
                    System.out.print(g.getSubjects().name() + " : ");
                    for (Integer iMark : mark) {
                        System.out.print(iMark + " ");
                        System.out.println();
                    }
                }

            }
        }
        System.out.println();
    }
}
