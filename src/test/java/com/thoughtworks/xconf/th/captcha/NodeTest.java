package com.thoughtworks.xconf.th.captcha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NodeTest {

    @Test
    public void display_ValueNode_printsTheValue() {
        Node valueNode = GodNode.createValueNode(1);
        assertEquals("1", valueNode.display());
    }

    @Test
    public void display_OperatorNode_printsTheEquation() {
        Node operatorNode = GodNode.createOpNode("+", GodNode.createValueNode(1), GodNode.createValueNode(2));
        assertEquals("1 + 2", operatorNode.display());
    }

    @Test
    public void display_complexOperatorNodes() {
        Node f = GodNode.createOpNode("*", GodNode.createValueNode(2), GodNode.createValueNode(5));
        Node g = GodNode.createOpNode("+", f, GodNode.createValueNode(3));

        assertEquals("2 * 5 + 3", g.display());
    }

    @Test
    public void compute_ValueNode_givesTheValueBack() {
        Node valueNode = GodNode.createValueNode(2);
        assertEquals(2, valueNode.compute().intValue());
    }

    @Test
    public void compute_OperatorNode_givesTheComputedResult() {
        Node opsNode = GodNode.createOpNode("-", GodNode.createValueNode(5), GodNode.createValueNode(3));
        assertEquals(2, opsNode.compute().intValue());
    }

    @Test
    public void compute_complexOperatorNodes() {
        Node f = GodNode.createOpNode("*", GodNode.createValueNode(2), GodNode.createValueNode(5));
        Node g = GodNode.createOpNode("+", f, GodNode.createValueNode(3));

        assertEquals(13, g.compute().intValue());
    }
}
