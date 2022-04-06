package com.company;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        GameDice.game();
        boolean game = true;

        do{
            System.out.println("--------------------");
            System.out.println("Do you want to play one more time? (Y/N)");
            String answer = scanner.nextLine();
            if(answer.equals("Y")){
                GameDice.game();
            }else if(answer.equals("N")){
                System.out.println("See you soon!");
                game = false;
            }
        }while (game);
    }

}


