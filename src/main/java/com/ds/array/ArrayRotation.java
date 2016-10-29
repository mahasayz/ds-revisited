package com.ds.array;

/**
 * Created by Mahbub on 10/29/2016.
 */
public class ArrayRotation {

    public static void rotateBy90(int[][] array) {
        int n = array.length;

        for (int layer=0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i=first; i<last; i++) {
                int offset = i - first;

                // save top
                int top = array[first][i];
                // left -> top
                array[first][i] = array[last - offset][first];
                // bottom -> left
                array[last - offset][first] = array[last][last - offset];
                // right -> bottom
                array[last][last - offset] = array[i][last];
                // top -> right
                array[i][last] = top;
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int i=0; i<array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[4][4];

        // fill array
        int counter = 1;
        for (int i=0; i<test.length; i++)
            for (int j=0; j<test[i].length; j++) {
                test[i][j] = counter++;
            }

        System.out.println("BEFORE");
        printArray(test);
        rotateBy90(test);
        System.out.println("AFTER");
        printArray(test);
    }

}
