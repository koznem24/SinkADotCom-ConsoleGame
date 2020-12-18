package com.koznem;

import javax.xml.stream.events.StartDocument;
import java.util.Random;

public class GameSetup {

    public static Cell[][] gridBuild(){
        int colStartingPoint = 0;
        char rowStartingPoint = 'A';
        Cell[][] collection = new Cell[7][7];

        for(int i = 0; i < 7; i++){
            for (int j = 0; j< 7; j++){
                collection[i][j] = new Cell(rowStartingPoint,colStartingPoint,false);
                colStartingPoint++;
            }
            rowStartingPoint++;
            colStartingPoint = 0;
        }

        return collection;
    }


    public static Cell[][] filledGrid(){
        GameSetup gameSetup = new GameSetup();
        Cell[][] tempGrid = GameSetup.gridBuild();
        Random r = new Random();
        int counter = 0;

        while(counter != 3){
            char rowLetter = (char) (r.nextInt(6) + 'A');
            int colNumber = r.nextInt(6);
            String cellKey = rowLetter + String.valueOf(colNumber);
//            System.out.println(cellKey);

            if(counter != 3) {
                if(counter == 1){
                    gameSetup.addHorizontal(cellKey, tempGrid);
                    counter++;
                }else if((gameSetup.addVertical(cellKey, tempGrid) != null )) {
                    counter++;
                }
            }else if(gameSetup.addHorizontal(cellKey, tempGrid) != null && counter != 3){
                counter++;
            }
        }



        return tempGrid;


    }

    private Cell[][] addVertical(String cellKey, Cell[][] grid){
        boolean isPossible = false;
        int counter = 0;
        int startingPoint = Integer.parseInt(String.valueOf(cellKey.charAt(1)));
       // Setting starting point
        while(!isPossible){
            if (startingPoint + 2 > 6) {
                startingPoint--;
            }else{
                isPossible = true;
            }

        }
        // Creating objects

        Cell object1 = new Cell(cellKey.charAt(0), startingPoint, true);
        Cell object2 = new Cell(cellKey.charAt(0),startingPoint + 1,true);
        Cell object3 = new Cell(cellKey.charAt(0), startingPoint + 2, true);


        for(int i = 0; i<7; i++){
            for (int j = 0; j< 7; j++){
                    if(grid[i][j].toString().equals(object1.toString()) && !grid[i][j].isDoesHoldValue()){

                            if (!grid[i][j].isDoesHoldValue()) {
                                grid[i][j].setDoesHoldValue(true);
                                counter++;

                                if(!grid[i][j+1].isDoesHoldValue()){
                                    grid[i][j+1].setDoesHoldValue(true);
                                    counter++;

                                    if(!grid[i][j+2].isDoesHoldValue()){
                                        grid[i][j+2].setDoesHoldValue(true);
                                        counter++;
                                    }else{
                                        grid[i][j].setDoesHoldValue(false);
                                        grid[i][j+1].setDoesHoldValue(false);
                                    }
                                }else{
                                    grid[i][j].setDoesHoldValue(false);
                                }
                            }
                    }
            }
        }

        if(counter == 3){
            return grid;
        }else{
            return null;
        }




    }

    private Cell[][] addHorizontal(String cellKey, Cell[][] grid){
        boolean isPossible = false;
        int counter = 0;
        char startingPoint = cellKey.charAt(0);
        // Setting starting point
        while(!isPossible){
            if (startingPoint + 2 > 'G') {
                startingPoint--;
            }else{
                isPossible = true;
            }

        }
        // Creating objects
        int point = Integer.parseInt(String.valueOf(cellKey.charAt(1)));
        Cell object1 = new Cell(startingPoint, point, true);
        Cell object2 = new Cell((char)(startingPoint + 1),point,true);
        Cell object3 = new Cell((char)(startingPoint + 2), point, true);

        for(int i = 0; i<7; i++){
            for (int j = 0; j< 7; j++){
                if(grid[i][j].toString().equals(object1.toString()) && !grid[i][j].isDoesHoldValue()){

                    if (!grid[i][j].isDoesHoldValue()) {
                        grid[i][j].setDoesHoldValue(true);
                        counter++;

                        if(!grid[i+1][j].isDoesHoldValue()){
                            grid[i+1][j].setDoesHoldValue(true);
                            counter++;

                            if(!grid[i+2][j].isDoesHoldValue()){
                                grid[i+2][j].setDoesHoldValue(true);
                                counter++;
                            }else{
                                grid[i][j].setDoesHoldValue(false);
                                grid[i+1][j].setDoesHoldValue(false);
                            }
                        }else{
                            grid[i][j].setDoesHoldValue(false);
                        }
                    }
                }
            }
        }

        if(counter == 3){
            return grid;
        }else{
            return null;
        }
    }
}
