package edu.ib;

public class Calculator {

    Operations operation = new Operations();

    public double calculate(String operator, double a, double b){
        double result=0;

        if(operator.equals("+")){
            result=operation.addition(a, b);
        }
        else if (operator.equals("-")){
            result=operation.subtraction(a, b);
        }
        else if (operator.equals("*")){
            result=operation.multiplication(a, b);
        }
        else if (operator.equals("/")){
            result=operation.division(a, b);
        }
        else{
            result=b;
        }

        return result;
    }

    public double other(String operator, double a){
        double result=0;
        if(operator.equals("+/-")){
            result = operation.switchSign(a);
        }
        else if(operator.equals("%")){
            result=a/100;
        }
        return result;
    }

}
