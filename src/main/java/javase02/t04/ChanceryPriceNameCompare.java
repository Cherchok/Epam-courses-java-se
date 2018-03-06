package javase02.t04;

import javase02.t03.Chancery;

import java.util.Comparator;

public class ChanceryPriceNameCompare implements Comparator<Chancery> {
    @Override
    public int compare(Chancery o1, Chancery o2) {
        return (new ChanceryPriceCompare()).compare(o1, o2) + (new ChanceryNameCompare()).compare(o1, o2);
    }
}
