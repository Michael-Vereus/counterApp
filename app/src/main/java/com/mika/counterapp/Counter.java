package com.mika.counterapp;

public class Counter {
    private int value;
    public Counter(int value){
        this.value = value;
    }

    public void addValue(){
        value++;
    }
    public void deductValue(){
        if(value > 0){
            value--;
        }
    }
    public int getValue() {
        return value;
    }
    public void resetValue(){
        value = 0;
    }
    public void addHundred(){
        value += 100;
    }
}
