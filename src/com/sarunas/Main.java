package com.sarunas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] board = gameBoard();
        while (true) {
            char[][] boardX = enterX(board);
            if (checkingWinner(boardX)) {
                break;
            }
            char[][] boardY = enterY(board);
            if (checkingWinner(boardY)) {
                break;
            }
        }
    }


    public static char[][] gameBoard() {
        String input = "         ";
        System.out.println("---------");
        System.out.println("|" + " " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " " + "|");
        System.out.println("|" + " " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " " + "|");
        System.out.println("|" + " " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " " + "|");
        System.out.println("---------");


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

        return board;

    }

    public static char[][] enterX(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        boolean flagX = true;
        while (flagX) {

            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println("> " + x + " " + y);
                scanner.nextLine();
                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates: ");
                } else if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates: ");
                } else {
                    board[x - 1][y - 1] = 'X';
                    flagX = false;
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

        return board;
    }

    public static char[][] enterY(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        boolean flagO = true;
        while (flagO) {
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println("> " + x + " " + y);
                scanner.nextLine();
                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates: ");
                } else if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates: ");
                } else {
                    board[x - 1][y - 1] = 'O';
                    flagO = false;
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

        return board;
    }


    public static boolean checkingWinner(char[][] board) {
        char[][] winner = {{board[0][0], board[0][1], board[0][2]},
                {board[1][0], board[1][1], board[1][2]},
                {board[2][0], board[2][1], board[2][2]},
                {board[0][0], board[1][0], board[2][0]},
                {board[0][1], board[1][1], board[2][1]},
                {board[0][2], board[1][2], board[2][2]},
                {board[0][0], board[1][1], board[2][2]},
                {board[0][2], board[1][1], board[2][0]}};

        int x = 0;
        int o = 0;
        for (char[] ii : board) {
            for (char i : ii) {
                if (i == 'X') {
                    x++;
                } else if (i == 'O') {
                    o++;
                }
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
                return true;
            } else if (imposible) {
                System.out.println("Impossible");
            } else if (xWin) {
                System.out.println("X wins");
                return true;
            } else if (oWin) {
                System.out.println("O wins");
                return true;
            }
        }
        return false;
    }
}
