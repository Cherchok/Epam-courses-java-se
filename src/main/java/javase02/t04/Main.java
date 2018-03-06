package javase02.t04;

import javase02.t03.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Chancery> chanceries = ChanceryKit.startKit();
        System.out.println();
        System.out.println("Price sort");
        System.out.println("Before : " + chanceries);
        chanceries.sort(new ChanceryPriceCompare());
        System.out.println("After  : " + chanceries);
        System.out.println();
        System.out.println("Name sort");
        System.out.println("Before : " + chanceries);
        chanceries.sort(new ChanceryNameCompare());
        System.out.println("After  : " + chanceries);

        ArrayList<Chancery> namePriceList = new ArrayList<>();
        namePriceList.add(new Pen(4));
        namePriceList.add(new Pencil(2));
        namePriceList.add(new Eraser(3));
        namePriceList.add(new Paints(1));
        namePriceList.add(new Notebook(1));
        System.out.println();
        System.out.println("Name and price sort");
        System.out.println("Before : " + namePriceList);
        namePriceList.sort(new ChanceryPriceNameCompare());
        System.out.println("After  : " + namePriceList);
    }
}
