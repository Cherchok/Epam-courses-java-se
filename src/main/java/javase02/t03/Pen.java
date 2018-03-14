package javase02.t03;

public class Pen extends Chancery {

    private int count;
    private double price;


    public Pen(int count) {
        this.count = count;
        price = getPrice(getItemName());
    }

    @Override
    public String getItemName() {
        return "Pen";
    }

    @Override
    public int Sum() {
        return this.count;
    }

    @Override
    public String getBrandName() {
        return "Star";
    }

    @Override
    public double price() {
        return price * count;
    }

}
