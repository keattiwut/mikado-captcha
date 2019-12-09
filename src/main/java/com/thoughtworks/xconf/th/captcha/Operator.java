package com.thoughtworks.xconf.th.captcha;

public abstract class Operator {
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

    public abstract Integer compute(Node leftOperand, Node rightOperand);
}

class Plus extends Operator {

    public Plus() {
        super("+");
    }

    @Override
    public Integer compute(Node leftOperand, Node rightOperand) {
        return leftOperand.compute() + rightOperand.compute();
    }
}

class Minus extends Operator {

    public Minus() {
        super("-");
    }

    @Override
    public Integer compute(Node leftOperand, Node rightOperand) {
        return leftOperand.compute() - rightOperand.compute();
    }
}

class Multiply extends  Operator {

    public Multiply() {
        super("*");
    }

    @Override
    public Integer compute(Node leftOperand, Node rightOperand) {
        return leftOperand.compute() * rightOperand.compute();
    }
}