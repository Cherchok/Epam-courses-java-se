package javase02.t03;

import java.util.ArrayList;

public class ChanceryKit {

    private ArrayList<Chancery> startKit() {
        ArrayList<Chancery> beginnerKit = new ArrayList<>();

        Pen pen = new Pen("Pen", "Rainbow");
        pen.addItem();
        pen.addItem();
        pen.addItem();

        Pencil pencil = new Pencil("Pencil", "Darkness");
        pencil.addItem();
        pencil.addItem();
        pencil.addItem();
        pencil.addItem();

        Eraser eraser = new Eraser("Eraser", "Shadow");
        eraser.addItem();

        Notebook notebook = new Notebook("Notebook", "Nature");
        notebook.addItem();

        Paints paints = new Paints("Paints", "Sunset");
        paints.addItem();

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
