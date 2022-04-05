package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Random random = new Random();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Predict amount of points from 2-12: ");
//        int userInput = scanner.nextInt();
//        System.out.println("User rolls the dices...");

        for(int i=0;i<=2;i++){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Predict amount of points from 2-12: ");
            int userInput = scanner.nextInt();
            System.out.println("User rolls the dices...");
            printDice(userInput);
        }


    }


    public static void printDice(int userInput){
        Random random = new Random();
        Dices1 dices1 = new Dices1();
        //User
        int dice1 = random.nextInt(1,7);
        int dice2 = random.nextInt(1,7);
        dices1.rollTheDice(dice1);
        dices1.rollTheDice(dice2);
        int result = dice1 + dice2;
        System.out.println("On the dice fell "+ result  + " points.");
        System.out.print("Result is: ");
        int points = result-Math.abs(result-userInput)*2;
        System.out.println(points+ " points");
        //computer

        System.out.println("Computer rolls the dices...");
        int computerChoice = random.nextInt(2,12);
        System.out.println("Computer predicted "+ computerChoice + " points.");
        int cDice1 = random.nextInt(1,7);
        int cDice2 = random.nextInt(1,7);
        dices1.rollTheDice(cDice1);
        dices1.rollTheDice(cDice2);

        int cResult = cDice1 + cDice2;
        System.out.println("On the dice fell "+ cResult  + " points.");
        System.out.print("Result is: ");
        int cPoints = cResult-Math.abs(cResult-computerChoice)*2;
        System.out.println(cPoints+ " points");
        currentScore(points,cPoints);

        //        System.out.println("Finals");
//        finalScore(userInput,computerChoice,result,cResult,points,cPoints);


//        if(points > cPoints){
//            System.out.println("User wins "+(points-cPoints) +" points more.");
//        }else if(cPoints> points){
//            System.out.println("Computer wins "+(cPoints-points)+" points more.");
//        }else {
//            System.out.println("Draw");
//        }
    }

    public static void currentScore(int points,int cPoints){
        System.out.println("----------Current score-----------");
        System.out.println("User: " + points);
        System.out.println("Computer: " + cPoints);
        if(points > cPoints){
            System.out.println("User is "+(points-cPoints) +" points ahead.");
        }else if(cPoints> points){
            System.out.println("Computer is "+(cPoints-points)+" points ahead.");
        }else {
            System.out.println("Draw");
        }
    }
    public static void finalScore(int userInput,int computerChoice,int result,int cResult,int points,int cPoints){
        System.out.println("--------------Finish game--------------");
        System.out.println("Round |     User  |        Computer");
        System.out.println("------+-----------+-----------------");
        System.out.println("- 1 - | Predicted:"+userInput+" N Predicted: "+ computerChoice);
        System.out.println("      | Dice: "+result+ "     | Dice: "+cResult);
        System.out.println("      | Result: "+points+"  | Result: "+cPoints);

        System.out.println("------+-----------+-----------------");
        System.out.println("- 2 - | Predicted:"+userInput+" N Predicted: "+ computerChoice);
        System.out.println("      | Dice: "+result+ "     | Dice: "+cResult);
        System.out.println("      | Result: "+points+"  | Result: "+cPoints);

        System.out.println("------+-----------+-----------------");
        System.out.println("- 3 - | Predicted:"+userInput+" N Predicted: "+ computerChoice);
        System.out.println("      | Dice: "+result+ "     | Dice: "+cResult);
        System.out.println("      | Result: "+points+"  | Result: "+cPoints);
        int userPoints = result+result+result;
        int computerPoints = cPoints+cPoints+cPoints;
        System.out.println("Total | Points:"+userPoints+" | Points: "+computerPoints);
        if(userPoints > computerPoints){
            System.out.println("User wins "+ (userPoints-computerPoints)+" points more. Congratulations!");
        }else if(computerPoints > userPoints){
            System.out.println("Computer wins "+ (computerPoints-userPoints)+" points more. Congratulations!");

        }

    }

}
