package javase02.t02;

public class Main {
    public static void main(String[] args) {

        ChancerySeller seller1 = new ChancerySeller("Ivan");
        ChancerySeller seller2 = new ChancerySeller("Petr");

        seller1.setItem("Pen");
        seller1.setItem("Pencil");
        seller1.setItem("Sticks");
        seller1.setItem("Notebook");
        seller1.setItem("Paints");
        seller1.setItem("Eraser");
        seller1.countItemPrice();
        seller1.showSellerItems();

        System.out.println();

        seller2.setItem("Pen");
        seller2.setItem("Pen");
        seller2.setItem("Pen");
        seller2.setItem("Pen");
        seller2.setItem("Pen");
        seller2.setItem("Pork");
        seller2.countItemPrice();


    }
}
