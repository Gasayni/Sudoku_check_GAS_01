package com.company;
// Приложение запускается со следующим набором параметров:
// q w e r t y u i o
// u . . . . . . . .
// r . . . . . . . .
// w . . . . . . . .
// e . . . . . . . .
// y . . . . . . . .
// t . . . . . . . .
// i . . . . . . . .
// o . . . . . . . .

import java.util.ArrayList;

// Где q, w, e, r, t, y, u, i, o - рандомные целые числа от 1 до 9 в любом порядке.
// Программа проверяет, подходят ли эти числа по правилу игры "Судоку".
public class Main {
    private static final ArrayList<Integer> numbers = new ArrayList<>();
    private static final int[][] masSudoku = new int[9][9];

    static {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
    }

    public static void main(String[] args) {
        prepareRowsMethod(args);
        System.out.println(checkSimilarRows());

        /*for (int i=0; i<masSudoku.length; i++){
            for (int j=i; j<masSudoku.length; j++){
                System.out.print(masSudoku[i][j] + " ");
            }
            System.out.println();
        }*/  // Проверка
    }

    private static void prepareRowsMethod(String[] args) {
        if (args.length != 0) {
            for (int i=0; i < masSudoku.length; i++) {
                for (int j=0; j < masSudoku.length; j++){
                    masSudoku[i][j] = Integer.parseInt(args[i*9+j]);
                }
            }
        }
    }

    private static boolean checkSimilarRows() {
        boolean checkFlag = true;
        int[] sum = new int[9];
        for (int i = 0; i < masSudoku.length; i++) {
            for (int j = 0; j < masSudoku.length; j++) {
                if (numbers.contains(masSudoku[i][j])) {
                    sum[masSudoku[i][j]-1]++;
                }
            }
            for (int j = 0; j < sum.length; j++) {
                if (sum[j]>1){
                    checkFlag = false;
                }
                sum[j] = 0;
            }

        }
        return checkFlag;
    }
}
