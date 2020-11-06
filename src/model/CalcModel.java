
package model;

import java.util.Stack;
import java.util.StringTokenizer;


public class CalcModel {

    int result;
    String input = "";
    static String expressionToBeSpoken = "";
    static String LaTeX = "";

    public void reset() {
        result = 0;
        input = "";
        expressionToBeSpoken = "";
        LaTeX = "";
    }

    public String getExpressionToBeSpoken() {
        return expressionToBeSpoken;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void process() {
        result = calculateResult(input);
    }

    public static int calculateResult(String equation) {
        
        Stack<Operator> opStack;
        Stack<Integer> numberStack;
        int valOne, valTwo, newVal;
        Operator temp;

        
        StringTokenizer ops = new StringTokenizer(equation, " +-*()^", true);
        String token = "";
        numberStack = new Stack();
        opStack = new Stack();
        try {
            while (ops.hasMoreTokens()) { 
                token = ops.nextToken();
                if (token.equals(" ")) { 
                    continue;
                } else if (!Operator.isOperator(token)) { 
                    numberStack.push(Integer.parseInt(token));
                } else if (token.equals("(")) {
                    opStack.push(Operator.getOperator(token));
                } else if (token.equals(")")) { 
                    while (!((temp = opStack.pop()).isStartBrace())) {
                        valTwo = numberStack.pop();
                        valOne = numberStack.pop();

                       
                        setExpressrionTobBeSpoken(temp.toString(), valOne, valTwo);
                        newVal = temp.calculate(valOne, valTwo);
                        numberStack.push(newVal);
                    }
                } else { 
                    while (true) { 
                        if ((opStack.empty()) || (opStack.peek().isStartBrace())
                                || (opStack.peek().getPrecedenceLevel() < Operator.getOperator(token).getPrecedenceLevel())) {
                            opStack.push(Operator.getOperator(token));
                            break; 
                        }
                        temp = opStack.pop();
                        valTwo = numberStack.pop();
                        valOne = numberStack.pop();
                        setExpressrionTobBeSpoken(temp.toString(), valOne, valTwo);

                        
                        newVal = temp.calculate(valOne, valTwo);
                        numberStack.push(newVal);
                    }
                }
            }
        } catch (InvalidOperatorException e) {
            System.out.println("Invalid operator found!");
        }

       
        while (!opStack.isEmpty()) {
            temp = opStack.pop();
            valTwo = numberStack.pop();
            valOne = numberStack.pop();
            newVal = temp.calculate(valOne, valTwo);
            
            setExpressrionTobBeSpoken(temp.toString(), valOne, valTwo);
            numberStack.push(newVal);
        }
        
        return numberStack.pop();
    }

    public static void setExpressrionTobBeSpoken(String temp, int valOne, int valTwo) {
        String middleWord = "";

        if (temp.equals("ADD")) {
            middleWord = "to";
        } else if ("SUBTRACT".equals(temp)) {
            middleWord = "from";
            int buffer = valOne;
            valOne = valTwo;
            valTwo = buffer;
        } else if ("MULTIPLY".equals(temp)) {
            middleWord = "by";
        } else if ("RAISE".equals(temp)) {
            middleWord = "to the power of";

        }
        expressionToBeSpoken += " " + temp + " " + String.valueOf(valOne) + " " + middleWord + " " + String.valueOf(valTwo) + "\n";
    }
}
