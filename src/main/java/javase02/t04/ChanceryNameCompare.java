package javase02.t04;

import javase02.t03.Chancery;

import java.util.Comparator;

public class ChanceryNameCompare implements Comparator<Chancery> {

    @Override
    public int compare(Chancery o1, Chancery o2) {
        return o1.getItemName().compareTo(o2.getItemName());
    }
}
