package javase02.t05;

public class Mark<M extends Number> {

    private M[] marks;

    public Mark(M[] mark) {
        this.marks = mark;
    }

    public M[] getMark() {
        return marks;
    }

    public void setMark(M[] marks) {
        this.marks = marks;
    }
}
