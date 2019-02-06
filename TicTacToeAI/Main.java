package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String i;
        do {
            System.out.println("Please choose a difficulty to play on or input exit to exit.");
            i = scan.nextLine();
            if(i.equals("easy") | i.equals("EASY")) {
                easy game = new easy();
                game.play();
            } else if(i.equals("medium") | i.equals("MEDIUM")) {
                medium game = new medium();
                game.play();
            } else if(i.equals("hard") | i.equals("HARD")) {
                hard game = new hard();
                game.play();
            } else if(i.equals("exit") | i.equals("EXIT")) {
                System.out.println("Thank you for playing!");
            } else {
                System.out.println("Not a valid input.");
            }
        } while(!exit(i));
    }

    private static boolean exit(String i) {
        if(i.equals("exit") | i.equals("EXIT")) {
            return true;
        } else {
            return false;
        }
    }
}
