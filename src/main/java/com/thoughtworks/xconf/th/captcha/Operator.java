package com.thoughtworks.xconf.th.captcha;

public class Operator {
    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public String display(Node leftOperand, Node rightOperand) {
        return leftOperand.display() + " " + getOperator() + " " + rightOperand.display();
    }
}
