package com.sarunas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Enter cells: " + input);
        System.out.println("---------");
        System.out.println("|" + " " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " " + "|");
        System.out.println("|" + " " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " " + "|");
        System.out.println("|" + " " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " " + "|");
        System.out.println("---------");

        char[][] winner = {{input.charAt(0), input.charAt(1), input.charAt(2)},
                {input.charAt(3), input.charAt(4), input.charAt(5)},
                {input.charAt(6), input.charAt(7), input.charAt(8)},
                {input.charAt(0), input.charAt(3), input.charAt(6)},
                {input.charAt(1), input.charAt(4), input.charAt(7)},
                {input.charAt(2), input.charAt(5), input.charAt(8)},
                {input.charAt(0), input.charAt(4), input.charAt(8)},
                {input.charAt(2), input.charAt(4), input.charAt(6)}};

        char[][] board = new char[3][3];
        board[0][0] = input.charAt(0);
        board[0][1] = input.charAt(1);
        board[0][2] = input.charAt(2);
        board[1][0] = input.charAt(3);
        board[1][1] = input.charAt(4);
        board[1][2] = input.charAt(5);
        board[2][0] = input.charAt(6);
        board[2][1] = input.charAt(7);
        board[2][2] = input.charAt(8);

        System.out.println("Enter the coordinates: ");
        boolean flag = true;
        while (flag) {

            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine();
                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates: ");
                } else if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates: ");
                } else {
                    board[x - 1][y - 1] = 'X';
                    flag = false;
                }
            } else {
                System.out.println("You should enter number!");
                scanner.nextLine();
            }
        }

        System.out.println("---------");
        System.out.println("|" + " " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " " + "|");
        System.out.println("|" + " " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " " + "|");
        System.out.println("|" + " " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " " + "|");
        System.out.println("---------");


//        int x = 0;
//        int o = 0;
//        String[] tictoc = input.split("");
//        for (String i : tictoc) {
//            if (i.contains("X")) {
//                x++;
//            } else if (i.contains("O")) {
//                o++;
//            }
//        }
//        if (Math.abs(x - o) > 1) {
//            System.out.println("Impossible");
//        } else {
//            boolean imposible = false;
//            int pos = 0;
//            boolean noWin = false;
//            boolean xWin = false;
//            boolean oWin = false;
//            for (int i = 0; i < winner.length; i++) {
//                int countX = 0;
//                int countO = 0;
//                for (int j = 0; j < winner[i].length; j++) {
//                    if (winner[i][j] == 'X') {
//                        countX++;
//                        pos++;
//                        if (countX == 3) {
//                            xWin = true;
//                        }
//                    } else if (winner[i][j] == 'O') {
//                        countO++;
//                        pos++;
//                        if (countO == 3) {
//                            oWin = true;
//                        }
//                    }
//                }
//            }
//            if (!oWin && !xWin) {
//                noWin = true;
//            } else if (xWin && oWin) {
//                imposible = true;
//            }
//
//            if (noWin && pos == 24) {
//                System.out.println("Draw");
//            } else if (imposible) {
//                System.out.println("Impossible");
//            } else if (noWin && pos < 24) {
//                System.out.println("Game not finished");
//            } else if (xWin) {
//                System.out.println("X wins");
//            } else if (oWin) {
//                System.out.println("O wins");
//            }
//        }
    }
}
