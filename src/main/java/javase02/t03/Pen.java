package javase02.t03;

public class Pen extends Chancery {

    private String item;
    private String brandName;
    private int count;
    private double price;

    public Pen(String item, String brandName) {
        this.item = item;
        this.brandName = brandName;
        price = getPrice(item);
    }


    public void addItem() {
        count++;
    }

    @Override
    public String getItemName() {
        return this.item;
    }

    @Override
    public int Sum() {
        return this.count;
    }

    @Override
    public String getBrandName() {
        return this.brandName;
    }

    @Override
    public double price() {
        return price * count;
    }
}
