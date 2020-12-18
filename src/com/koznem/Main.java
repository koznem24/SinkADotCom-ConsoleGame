package com.koznem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cell[][] generatedCell = GameSetup.filledGrid();
        ArrayList<String> sequencedValues = new ArrayList<>();
        int counter = 0;

        for(int i = 0; i<7; i++){
            for (int j = 0; j< 7; j++){
                if(generatedCell[i][j].isDoesHoldValue()){
                    System.out.print('+');
                    sequencedValues.add(generatedCell[i][j].toString());
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }

        sequencedValues.sort(String::compareTo);

        sequencedValues.forEach(System.out::println);

        while(!isWon(sequencedValues)){

            boolean isValidInput = false;
            String guess = "A0";

            while(!isValidInput){
               guess = scanner.nextLine();
               if(guess.length() == 2 &&
                       guess.toUpperCase().charAt(0)>= 'A' &&
                       guess.toUpperCase().charAt(0)<= 'G' &&
                       guess.charAt(1) >= '0' &&
                       guess.charAt(1) <= '9' ){

                   isValidInput = true;
               }
            }
            counter++;
            guess.toUpperCase();

            if(isHit(guess,sequencedValues)){
                int index = sequencedValues.indexOf(guess);
                sequencedValues.set(index,"done");
                System.out.println("You hit one!");
            }else{
                System.out.println("miss");
            }
        }

        System.out.println("You won the game in " + counter + " attempts");
    }

    public static boolean isHit (String a,ArrayList<String> b){
        return b.contains(a);
    }

    public static boolean isWon(ArrayList<String> listToCheck){
        for (String s : listToCheck) {
            if(s != "done"){
                return false;
            }
        }

        return true;
    }
}
