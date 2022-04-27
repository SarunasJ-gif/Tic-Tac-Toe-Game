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

        int x = 0;
        int o = 0;
        String[] tictoc = input.split("");
        for (String i : tictoc) {
            if (i.contains("X")) {
                x++;
            } else if (i.contains("O")) {
                o++;
            }
        }
        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
        } else {
            boolean imposible = false;
            int pos = 0;
            boolean noWin = false;
            boolean xWin = false;
            boolean oWin = false;
            for (int i = 0; i < winner.length; i++) {
                int countX = 0;
                int countO = 0;
                for (int j = 0; j < winner[i].length; j++) {
                    if (winner[i][j] == 'X') {
                        countX++;
                        pos++;
                        if (countX == 3) {
                            xWin = true;
                        }
                    } else if (winner[i][j] == 'O') {
                        countO++;
                        pos++;
                        if (countO == 3) {
                            oWin = true;
                        }
                    }
                }
            }
            if (!oWin && !xWin) {
                noWin = true;
            } else if (xWin && oWin) {
                imposible = true;
            }

            if (noWin && pos == 24) {
                System.out.println("Draw");
            } else if (imposible) {
                System.out.println("Impossible");
            } else if (noWin && pos < 24) {
                System.out.println("Game not finished");
            } else if (xWin) {
                System.out.println("X wins");
            } else if (oWin) {
                System.out.println("O wins");
            }
        }
    }
}
