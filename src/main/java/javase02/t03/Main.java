package javase02.t03;

public class Main {

    public static void main(String[] args) {
        ChanceryKit chanceryKit = new ChanceryKit();
        chanceryKit.showItems();
        System.out.println();
        System.out.println("Total price: " + chanceryKit.kitPrice() + "$");

    }
}
