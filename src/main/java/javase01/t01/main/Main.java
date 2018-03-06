package javase01.t01.main;

import javase01.t01.logic.Logic;
import javase02.t01.Pen;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        System.out.println(logic.method());

        Pen pen1 = new Pen();
        Pen pen2 = new Pen();

        pen1.setId(100);
        pen2.setId(100);

        System.out.println(pen1.equals(pen2));
        System.out.println(pen1.hashCode());
    }
}
