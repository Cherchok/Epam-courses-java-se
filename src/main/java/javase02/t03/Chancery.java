package javase02.t03;

public abstract class Chancery {


    double getPrice(String item) {
        double price = 0;
        switch (item) {
            case "Pen":
                price = 20.50;
                break;
            case "Pencil":
                price = 15.60;
                break;
            case "Sticks":
                price = 37.20;
                break;
            case "Notebook":
                price = 70.0;
                break;
            case "Paints":
                price = 108.0;
                break;
            case "Eraser":
                price = 13.50;
                break;
        }
        return price;
    }

    public abstract String getItemName();

    public abstract int Sum();

    public abstract String getBrandName();

    public abstract double price();

    @Override
    public String toString() {
        return getItemName()+"-"+price();
    }
}
