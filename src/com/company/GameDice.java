package com.company;
import exception.InvalidNumberException;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameDice {
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    public GameDice() {

    }

    static List<Integer> userPredicate = new ArrayList<>();
    static List<Integer> userDice = new ArrayList<>();
    static List<Integer> userResult = new ArrayList<>();

    static List<Integer> computerPredicate = new ArrayList<>();
    static List<Integer> computerDice = new ArrayList<>();

    static List<Integer> computerResult = new ArrayList<>();

    static void game() {
        int input = 0;
        int count = 0;
        int count2 = 3;
        boolean bol = true;
        int userSum = 0;
        int compSum = 0;
        do{
            try{
                System.out.print("Predict amount of points from 2-12: ");

                input = scanner.nextInt();
                userPredicate.add(input);
                if(input < 2 | input > 12){
                    throw new InvalidNumberException("You entered invalid number " + input);
                }

                Dices1 dicesM = new Dices1();
                int dices1 = rollTheDice();
                int dices2 = rollTheDice();
                int sum = dices1 + dices2;

                //Cheating
                Scanner scanner = new Scanner(System.in);
                System.out.println("Do you want to cheat? [Y/N]");
                System.out.println("If you fail, you will lost 10 points");
                String decision = scanner.nextLine();
                if(decision.equals("N")){
                    System.out.println("User doesn't cheated");
                }else if(decision.equals("Y")){
                    System.out.println("User tried to cheat");
                    bol =getChanceFirstRound(count2);
                    if(bol){
                        sum = input;
                        System.out.println("User successfully cheated");
                    }else {
                        userSum-=10;
                        System.out.println("User lost 10 points");
                    }
                }



                System.out.println("User rolls the dices...");

                dicesM.rollTheDice(dices1);
                dicesM.rollTheDice(dices2);

//                int sum = dices1 + dices2;
                userDice.add(sum);
                System.out.println("On the dice fell " + sum + " points.");
                System.out.print("Result is: ");
                int points = amountSum(sum,input);//Math.abs
                userResult.add(points);
                System.out.println(points + " points");//Final Points
                System.out.println("----------------------------------");


                System.out.println("Computer rolls the dices...");
                int computerNum = computerNumber();
                computerPredicate.add(computerNum);
                int roll3 = rollTheDice();
                int roll4 = rollTheDice();
                dicesM.rollTheDice(roll3);
                dicesM.rollTheDice(roll4);
                int sum3 = roll3+roll4;
                computerDice.add(sum3);

                System.out.println("On the dice fell " + sum3 + " points.");
                System.out.print("Result is: ");
                int pointsC = amountSum(sum3,computerNum);//Math.abs
                computerResult.add(pointsC);
                System.out.println(pointsC + " points");//Final Points Comp
                System.out.println("----------------------------------");


                System.out.println("----------Current score-----------\n"+
                "User: "+ points + " points \n"+
                "Computer: " +pointsC + " points");
                if(points > pointsC){
                    int remainUser = points - pointsC;
                    System.out.println("User is ahead by " + remainUser + " points.");
                }else if (pointsC > points){
                    int remainComp = pointsC - points;
                    System.out.println("Computer is ahead by " + remainComp + " points.");

                }


            } catch (InvalidNumberException e) {
                System.err.println(e.getMessage());
            }
            count++;
            count2+=2;
        }while (count < 3);{}

        //Final Results

        int userFinalScore = totalPoints(userResult)-userSum;
        int compFinalScore = totalPoints(computerResult)-compSum;
        printFinalResult();
        System.out.println("-------Lost points during cheating ------\n"+
                "User: "+ userSum+'\n'+
                "Computer: "+ compSum);
        if (userFinalScore > compFinalScore) {
            System.out.println("User win " + userFinalScore + " points more. Congratulations!");
        } else {
            System.out.println("Computer win " + compFinalScore + " points more. Congratulations!");
        }
        System.out.println("User's Final Points: "+ totalPoints(userResult)+ "| Computer's Final Result: " + totalPoints(computerResult));

    }


        static void printFinalResult(){
            System.out.println("-----------------Finish Game-----------------------\n"+
                    "Round  |     User       |        Computer ");
            int counter = 0;
            for(int i = 0;i<3;i++){
                counter++;
                System.out.printf("       | Predicted   %d  | Predicted  %d \n"+
                            "- %d -  | Dice        %d  | Dice       %d \n"+
                            "       | Result      %d | Result     %d \n"+
                            " -------+-----------------+----------------\n",userPredicate.get(i),computerPredicate.get(i),
                        counter,userDice.get(i),computerDice.get(i),userResult.get(i),computerResult.get(i));


        }


//                "       | Final points: "+ totalPoints(userResult)+ "| Final Result: " + totalPoints(computerResult));


        if(totalPoints(userResult) > totalPoints(computerResult)){
            System.out.println("User wins "+(totalPoints(userResult)-totalPoints(computerResult))+" points more. Congratulations!");
        }else if(totalPoints(computerResult)>(totalPoints(userResult))){
            System.out.println("Computer wins "+(totalPoints(computerResult)-(totalPoints(userResult))+" points more. Congratulations!"));
        }else{
            System.out.println("Draw!");
        }
    }





    static int rollTheDice() {
        return rand.nextInt(1, 7);
    }

    static int amountSum(int sum, int input) {
        int res = sum - Math.abs(sum - input) * 2;
        return res;
    }

    static int computerNumber() {
        return rand.nextInt(2, 13);
    }
    static int totalPoints(List<Integer> point){
        int sum = 0;
        for(int i = 0; i<point.size();i++){
            sum = sum + point.get(i);
        }
        return sum;
    }
    public static boolean getChanceFirstRound(int count){
        int n = rand.nextInt(1,count);
        int n1 = rand.nextInt(1,count);
        System.out.println("First number: "+n+ " Second number: "+ n1);
        return n==n1;
    }
}
