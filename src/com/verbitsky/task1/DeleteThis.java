package com.verbitsky.task1;

public class DeleteThis {
    public static void main(String[] args) {
        double rebro = 2 * Math.sqrt(2);
        double s = Math.sqrt(3) * rebro * rebro;
        double v = Math.sqrt(2)/12*rebro*rebro*rebro;

        System.out.println("koren iz 3 = " + Math.sqrt(3));
        System.out.println("rebro="+rebro);
        System.out.println("rebro*rebro="+(rebro*rebro));
        System.out.println("s="+s);
        System.out.println("v="+v);


      /* String [] words = new String[4];
        words[0] = "0";
        words[1] = "1";
        words[2] = "2";
        words[3] = "3";
        test1(words);

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        for (int i = 0; i < 11; i += 3) {
            System.out.println(array[i]);
            System.out.println("array i+1 = " + array[i+1]);
            System.out.println("array i+2 = " + array[i + 2]);

        }
*/
    }

    private static void test1(String... words) {
        for (String word : words) {
            System.out.println(word);
        }
    }
}
