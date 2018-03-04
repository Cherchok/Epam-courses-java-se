package javase02.t02;

import java.util.ArrayList;

public class ChancerySeller {
    private String name;
    private ArrayList<String> chancery;

    public ChancerySeller(String name) {
        this.name = name;
        chancery = new ArrayList<>();
    }

    public void setItem(String item) {
        chancery.add(item);
    }

    private double getPrice(String item) {
        double price;
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
            default:
                price = 0;
                System.out.println(name + "!!! The item " + item + " is not found");
        }
        return price;
    }

    public void showSellerItems() {
        System.out.println(name + " sold next items: ");
        int number = 0;
        for (String item : chancery) {
            ++number;
            System.out.println(number + ". " + item);
        }
    }

    public void countItemPrice() {
        double totalPrice = 0;
        for (String item : chancery) {
            totalPrice += getPrice(item);
        }
        System.out.print(name + " sold the items for: " + totalPrice + " rubles");
        System.out.println();
    }
}
