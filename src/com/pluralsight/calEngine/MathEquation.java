package com.pluralsight.calEngine;

public class MathEquation {

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

  public MathEquation(){

  }
  public MathEquation(char opCode,double leftVal, double rightVal){
      this.opCode = opCode;
      this.leftVal = leftVal;
      this.rightVal = rightVal;
  }
  public void execute(){
      switch (opCode) {
          case 'a':
              result = leftVal + rightVal;
              break;
          case 's':
              result = leftVal - rightVal;
              break;
          case 'd':
              result = rightVal != 0 ? leftVal / rightVal : 0.0d;
              break;
          case 'm':
              result = leftVal * rightVal;
              break;
          default:
              result = 0.0d;
              System.out.println(("Error: Enter Valid opCode"));
              break;

      }
  }

}
