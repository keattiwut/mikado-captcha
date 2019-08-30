package com.thoughtworks.xconf.th.captcha;

public class GodNode extends ValueNode implements Node {

    private String operator = "#";

    private Node leftOperand;
    private Node rightOperand;

    private GodNode(String operator, Node leftOperand, Node rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    private GodNode(Integer value) {
        this.value = value;
    }

    public static Node createOpNode(String operator, Node leftOperand, Node rightOperand) {
        return new GodNode(operator, leftOperand, rightOperand);
    }

    public static Node createValueNode(Integer value) {
        return new GodNode(value);
    }

    @Override
    public Integer compute() {
        switch (this.operator) {
            case "+" : return leftOperand.compute() + rightOperand.compute();
            case "-" : return leftOperand.compute() - rightOperand.compute();
            case "*" : return leftOperand.compute() * rightOperand.compute();
            case "#" : return this.value;
            default  : throw new UnsupportedOperationException();
        }
    }

    @Override
    public String display() {
        switch (this.operator) {
            case "+" : return leftOperand.display() + " + " + rightOperand.display();
            case "-" : return leftOperand.display() + " - " + rightOperand.display();
            case "*" : return leftOperand.display() + " * " + rightOperand.display();
            case "#" : return this.value + "";
            default  : throw new UnsupportedOperationException();
        }
    }

}
