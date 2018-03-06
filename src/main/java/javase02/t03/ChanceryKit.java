package javase02.t03;

import java.util.ArrayList;

public class ChanceryKit {

    public static ArrayList<Chancery> startKit() {
        ArrayList<Chancery> beginnerKit = new ArrayList<>();

        Pen pen = new Pen(10);
        Pencil pencil = new Pencil(11);
        Eraser eraser = new Eraser(2);
        Notebook notebook = new Notebook(1);
        Paints paints = new Paints(1);

        beginnerKit.add(pen);
        beginnerKit.add(pencil);
        beginnerKit.add(eraser);
        beginnerKit.add(notebook);
        beginnerKit.add(paints);

        return beginnerKit;
    }

    public double kitPrice() {
        double price = 0;
        for (Chancery item : startKit()) {
            price += item.price();
        }
        return price;
    }

    public void showItems() {
        int number = 0;
        for (Chancery items : startKit()) {
            number++;
            System.out.println(number + ". " + items.getItemName() + " \"" + items.getBrandName() + "\" "
                    + " - " + items.Sum());
        }
    }
}
