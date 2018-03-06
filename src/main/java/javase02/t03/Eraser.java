package javase02.t03;

public class Eraser extends Pen {

    public Eraser(int count) {
        super(count);
    }

    @Override
    public String getItemName() {
        return "Eraser";
    }

    @Override
    public String getBrandName() {
        return "Shadow";
    }
}
