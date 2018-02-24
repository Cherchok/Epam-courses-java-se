package javase01.t03;

public class Ffunction {

    public void Ffunk(double a, double b, double step){
        double f;

        for (double x = a; x <= b ; x+=step) {

            f = Math.tan(2*x) -3;
            System.out.println("x = " + x + " F(x) = "+f);
        }
    }
}
