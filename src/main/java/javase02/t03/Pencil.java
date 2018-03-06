package javase02.t03;

public class Pencil extends Pen {

    public Pencil(int count) {
        super(count);
    }

    @Override
    public String getItemName() {
        return "Pencil";
    }

    @Override
    public String getBrandName() {
        return "Mine";
    }
}
