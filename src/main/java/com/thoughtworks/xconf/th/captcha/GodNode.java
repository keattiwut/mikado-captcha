package com.thoughtworks.xconf.th.captcha;

public class GodNode implements Node {

    private String operator;

    private Node leftOperand;
    private Node rightOperand;

    private GodNode(String operator, Node leftOperand, Node rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public static Node createOpNode(String operator, Node leftOperand, Node rightOperand) {
        return new GodNode(operator, leftOperand, rightOperand);
    }

    public static Node createValueNode(Integer value) {
        return new ValueNode(value);
    }

    @Override
    public Integer compute() {
        switch (this.operator) {
            case "+" : return leftOperand.compute() + rightOperand.compute();
            case "-" : return leftOperand.compute() - rightOperand.compute();
            case "*" : return leftOperand.compute() * rightOperand.compute();
            default  : throw new UnsupportedOperationException();
        }
    }

    @Override
    public String display() {
        switch (this.operator) {
            case "+" : return leftOperand.display() + " + " + rightOperand.display();
            case "-" : return leftOperand.display() + " - " + rightOperand.display();
            case "*" : return leftOperand.display() + " * " + rightOperand.display();
            default  : throw new UnsupportedOperationException();
        }
    }

}
