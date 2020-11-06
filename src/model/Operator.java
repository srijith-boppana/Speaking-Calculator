package model;


public enum Operator {

    ADD("+", 1) {
        int calculate(int d1, int d2) {
            return d1 + d2;
        }
    },
    SUBTRACT("-", 1) {
        int calculate(int d1, int d2) {
            return d1 - d2;
        }
    },
    MULTIPLY("*", 2) {
        int calculate(int d1, int d2) {
            return d1 * d2;
        }
    },
    STARTBRACE("(", 0) {
        int calculate(int d1, int d2) {
            return 0;
        }
    },
    ENDBRACE(")", 0) {
        int calculate(int d1, int d2) {
            return 0;
        }
    },
    RAISE("^", 3) {
        int calculate(int d1, int d2) {
            return (int) Math.pow(d1, d2);
        }
    };
    private String operator;
    private int precedence;

    private Operator(String operator, int precedence) {
        this.operator = operator;
        this.precedence = precedence;
    }

    public int getPrecedenceLevel() {
        return precedence;
    }

    public String getSymbol() {
        return operator;
    }

    public static boolean isOperator(String s) {
        for (Operator op : Operator.values()) { 
            if (op.getSymbol().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static Operator getOperator(String s)
            throws InvalidOperatorException {
        for (Operator op : Operator.values()) { 
            if (op.getSymbol().equals(s)) {
                return op;
            }
        }
        throw new InvalidOperatorException(s + " Is not a valid operator!");
    }

    public boolean isStartBrace() {
        return (operator.equals("("));
    }

    abstract int calculate(int d1, int d2);
}

class InvalidOperatorException extends Exception {

    public InvalidOperatorException() {
    }

    public InvalidOperatorException(String s) {
        super(s);
    }
}
