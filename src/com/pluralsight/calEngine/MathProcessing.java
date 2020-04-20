package com.pluralsight.calEngine;

public interface MathProcessing {
     String SEPARATOR = " ";
     String getKeyword();
     char getSymbol();
     double doCalculation(double leftVal, double rightVal);

}
