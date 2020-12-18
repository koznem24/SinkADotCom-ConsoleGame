package com.koznem;

public class Cell {



    private char rowLetter;
    private int colNumber;
    private boolean doesHoldValue;

    public Cell(char rowLetter, int colNumber,  boolean doesHoldValue){
        this.rowLetter = rowLetter;
        this.colNumber = colNumber;
        this.doesHoldValue = doesHoldValue;
    }

    public char getRowNumber() {
        return rowLetter;
    }

    public void setRowLetter(char rowLetter) {
        this.rowLetter = rowLetter;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public boolean isDoesHoldValue() {
        return doesHoldValue;
    }

    public void setDoesHoldValue(boolean doesHoldValue) {
        this.doesHoldValue = doesHoldValue;
    }

    @Override
    public String toString() {
        return rowLetter+ String.valueOf(colNumber) ;
    }
}
