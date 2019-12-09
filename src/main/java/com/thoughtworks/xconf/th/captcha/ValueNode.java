package com.thoughtworks.xconf.th.captcha;

public class ValueNode implements Node {
    protected Integer value = 0;

    @Override
    public Integer compute() {
        return value;
    }

    @Override
    public String display() {
        return value.toString();
    }
}
