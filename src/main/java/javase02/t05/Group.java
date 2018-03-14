package javase02.t05;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Group {

    private Set<Student> students;
    private Subjects subject;
    private Map<Student, Mark> marks;


    @SuppressWarnings("WeakerAccess")
    public Group(Subjects subject) {
        this.subject = subject;
        students = new LinkedHashSet<>();
        marks = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Subjects getSubjects() {
        return subject;
    }

    @Override
    public String toString() {
        return subject.name();
    }

    public void putMark(Student student, Number[] studMark) {
        if (students.contains(student)) {
            if (subject.name().equals("MATH") || subject.name().equals("PROGRAMMING")) {
             Double[] mark1 = new Double[studMark.length];
                for (int i = 0; i <studMark.length ; i++) {
                    mark1[i]=(Double)studMark[i];
                }
                marks.put(student, new Mark<>(mark1));
            }else{
                Integer[] mark1 = new Integer[studMark.length];
                for (int i = 0; i <studMark.length ; i++) {
                    mark1[i]=(Integer) studMark[i];
                }
                marks.put(student,new Mark<>(mark1));
            }
        }
    }

    public Number[] getMark(Student student){
        if(marks.containsKey(student)){
            return marks.get(student).getMark();
        }else
        throw new RuntimeException("No marks "+student.getName()+" "+student.getSurname());
    }
}
