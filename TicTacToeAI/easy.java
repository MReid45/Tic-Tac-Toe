package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.lang.String;

public class easy {

    public void play() {
        Scanner in;
        String[] board;
        String turn;

        in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        populateEmptyBoard(board);

        System.out.println("Welcome to PVE Tic Tac Toe.");
        System.out.println("--------------------------------");
        printBoard(board);
        System.out.println("Player will be X's, you go first:");

        while (winner == null) {
            int numInput;
            try {
                if(turn.equals("X")) {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Invalid input; re-enter slot number:");
                        continue;
                    }
                } else {
                    numInput = easyai();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
            if (board[numInput-1].equals(String.valueOf(numInput))) {
                board[numInput-1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard(board);
                winner = checkWinner(turn, board);
            } else {
                System.out.println("Slot already taken; re-enter slot number:");
                continue;
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }

    private int easyai() {
        int i;
        Random gn = new Random();

        i = gn.nextInt(8) + 1;
        return i;
    }

    static String checkWinner(String turn, String[] board) {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                    //rows
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                    //columns
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                    //diagonals
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                break;
            }
            else if (a == 8) return "draw";
        }

        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }

    private void printBoard(String[] board) {
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("/---|---|---\\");
    }

    static void populateEmptyBoard(String[] board) {
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a+1);
        }
    }
}

