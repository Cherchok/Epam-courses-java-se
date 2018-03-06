package javase02.t04;

import javase02.t03.Chancery;

import java.util.Comparator;


public class ChanceryPriceCompare implements Comparator<Chancery> {


    @Override
    public int compare(Chancery o1, Chancery o2) {
        return (int) (o1.price() - o2.price());
    }
}
