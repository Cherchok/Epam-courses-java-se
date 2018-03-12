package javase02.t05;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UniversityTest {

    @Test
    void getGroups() {

        University university = new University();
        Student student1 = new Student("Viktor", "Yurzanov");
        Student student2 = new Student("Ivan", "Ivanov");
        Student student3 = new Student("Peter", "Petrov");
        Student student4 = new Student("Vladimir", "Sidorov");

        Group group1 = new Group(Subjects.MATH);
        Group group2 = new Group(Subjects.BIOLOGY);
        Group group3 = new Group(Subjects.ENGLISH);
        Group group4 = new Group(Subjects.PROGRAMMING);

        group1.addStudent(student1);
        group1.addStudent(student4);
        group2.addStudent(student2);
        group2.addStudent(student3);
        group3.addStudent(student1);
        group3.addStudent(student3);
        group4.addStudent(student1);
        group4.addStudent(student2);
        group4.addStudent(student3);
        group4.addStudent(student4);

        university.addGroup(group1);
        university.addGroup(group2);
        university.addGroup(group3);
        university.addGroup(group4);

        String expected = "[BIOLOGY, PROGRAMMING]";
        String actual = university.getGroups(student2).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void studentMarks() {

        University university = new University();
        Student student1 = new Student("Viktor", "Yurzanov");
        Student student2 = new Student("Ivan", "Ivanov");
        Student student3 = new Student("Peter", "Petrov");
        Student student4 = new Student("Vladimir", "Sidorov");

        Group group1 = new Group(Subjects.MATH);
        Group group2 = new Group(Subjects.BIOLOGY);
        Group group3 = new Group(Subjects.ENGLISH);
        Group group4 = new Group(Subjects.PROGRAMMING);

        group1.addStudent(student1);
        group1.addStudent(student4);
        group2.addStudent(student2);
        group2.addStudent(student3);
        group3.addStudent(student1);
        group3.addStudent(student3);
        group4.addStudent(student1);
        group4.addStudent(student2);
        group4.addStudent(student3);
        group4.addStudent(student4);

        group1.putMark(student1,new Number[]{5.2});
        group1.putMark(student4,new Number[]{4.7});
        group2.putMark(student2,new Number[]{2});
        group2.putMark(student3,new Number[]{4});
        group3.putMark(student1,new Number[]{3});
        group3.putMark(student3,new Number[]{6});
        group4.putMark(student1,new Number[]{4.9});
        group4.putMark(student2,new Number[]{4.7});
        group4.putMark(student3,new Number[]{5.2});
        group4.putMark(student4,new Number[]{4.0});

        university.addGroup(group1);
        university.addGroup(group2);
        university.addGroup(group3);
        university.addGroup(group4);

        university.studentMarks(student1);
        university.studentMarks(student2);
        university.studentMarks(student3);
        university.studentMarks(student4);

    }
}