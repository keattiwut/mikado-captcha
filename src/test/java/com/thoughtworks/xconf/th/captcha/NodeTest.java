package com.thoughtworks.xconf.th.captcha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NodeTest {

    @Test
    public void display_ValueNode_printsTheValue() {
        Node valueNode = new ValueNode(1);
        assertEquals("1", valueNode.display());
    }

    @Test
    public void display_OperatorNode_printsTheEquation() {
        Node operatorNode = new GodNode("+", new ValueNode(1), new ValueNode(2));
        assertEquals("1 + 2", operatorNode.display());
    }

    @Test
    public void display_complexOperatorNodes() {
        Node f = new GodNode("*", new ValueNode(2), new ValueNode(5));
        Node g = new GodNode("+", f, new ValueNode(3));

        assertEquals("2 * 5 + 3", g.display());
    }

    @Test
    public void compute_ValueNode_givesTheValueBack() {
        Node valueNode = new ValueNode(2);
        assertEquals(2, valueNode.compute().intValue());
    }

    @Test
    public void compute_OperatorNode_givesTheComputedResult() {
        Node opsNode = new GodNode("-", new ValueNode(5), new ValueNode(3));
        assertEquals(2, opsNode.compute().intValue());
    }

    @Test
    public void compute_complexOperatorNodes() {
        Node f = new GodNode("*", new ValueNode(2), new ValueNode(5));
        Node g = new GodNode("+", f, new ValueNode(3));

        assertEquals(13, g.compute().intValue());
    }
}
