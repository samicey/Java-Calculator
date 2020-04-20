package com.pluralsight.calEngine;

public abstract class CalculateBase {

    private double leftVal;
    private double rightVal;
    private char opCode = 'a';
    private double result;

    public double getLeftVal(){ return this.leftVal; }
    public void setLeftVal (double leftVal){ this.leftVal = leftVal;}
    public double getRightVal(){ return this.rightVal;}
    public void setRightVal(double rightVal){ this.rightVal = rightVal;}
    public char getOpCode(){return this.opCode;}
    public void setOpCode(char opCode){ this.opCode = opCode;}
    public double getResult(){ return this.result;}

    public CalculateBase(){}

    public CalculateBase(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public abstract void calculate();

    public double setResult(double value){
        return this.result = value;
    }

}

