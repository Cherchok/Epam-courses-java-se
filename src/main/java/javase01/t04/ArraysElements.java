package javase01.t04;

import java.util.Scanner;

public class ArraysElements {

    public double maxSumOfTwo(int numbOfEl) {

        double[] array = new double[numbOfEl];

        if (array.length % 2 != 0) {
            array = new double[numbOfEl + 1];
        }

        if (array.length == 0) {
            array = new double[numbOfEl + 2];
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Fill the Array:");

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextDouble();

            System.out.println("array[" + i + "]= " + array[i]);
        }

        double max = array[0] + array[1];

        for (int i = 0; i <= array.length - 1; i += 2) {

            double temp = array[i] + array[i + 1];

            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}
