package com.thoughtworks.xconf.th.captcha;

public class GodNode implements Node {

    private Operator operator;

    private Node leftOperand;
    private Node rightOperand;

    public GodNode(Operator operator, Node leftOperand, Node rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Integer compute() {
        return operator.compute(leftOperand, rightOperand);
    }

    @Override
    public String display() {
        return operator.display(leftOperand, rightOperand);
    }

}
