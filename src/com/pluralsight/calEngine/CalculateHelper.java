package com.pluralsight.calEngine;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    private MathCommand command;
    private double leftVal;
    private double rightVal;
    private double result;

    public void process (String statement) throws InvalidStatementException{
        // add 1.0 2.0
        String[] parts = statement.split(" ");
        if (parts.length != 3){
            throw new InvalidStatementException("Incorrect Number of fields", statement);
        }
        String commandString = parts[0];
        try {
            leftVal = Double.parseDouble(parts[1]);
            rightVal = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e){
            throw new InvalidStatementException("Non-numeric data",statement,e);
        }
        setCommandFromString(commandString);

        if (command == null){
            throw new InvalidStatementException("Invalid command", statement);
        }

        CalculateBase calculator = null;

        switch (command){
            case Add:
                calculator = new Adder(leftVal,rightVal);
                break;
            case Substract:
                calculator = new Subtracter(leftVal, rightVal);
                break;
            case Divide:
                calculator = new Divider(leftVal,rightVal);
                break;
            case Multiply:
                calculator = new Multiplier(leftVal, rightVal);
                break;
        }

        calculator.calculate();

        result = calculator.getResult();


    }

    private void setCommandFromString(String commandString){

        if (commandString.equalsIgnoreCase(MathCommand.Add.toString())){
          command = MathCommand.Add;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Substract.toString())){
            command = MathCommand.Substract;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())){
            command = MathCommand.Divide;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString())){
            command = MathCommand.Multiply;
        }
    }

    @Override
    public String toString(){

        char symbol = ' ';
        switch (command){
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            case Substract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Add:
                 symbol = ADD_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

}
