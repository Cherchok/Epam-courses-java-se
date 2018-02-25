package javase01.t05;

public class Matrix {

    public void lineX(int length, int hight) {

        int[][] array = new int[length][hight];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < hight; j++) {
                if (i == j) {
                    array[i][j] = 1;
                } else if (i == hight - j - 1 || j == length - i - 1) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


}
