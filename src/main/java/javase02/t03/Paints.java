package javase02.t03;

public class Paints extends Pen {

    public Paints(int count) {
        super(count);
    }

    @Override
    public String getItemName() {
        return "Paints";
    }

    @Override
    public String getBrandName() {
        return "Rainbow";
    }
}
