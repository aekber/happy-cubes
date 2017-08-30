package com.eko.assignment.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eko.assignment.api.CubeEdge;

public class EdgeTest {

    @Test
    public void testEdge() {
    	CubeEdge edge1 = new CubeEdge("oo oo");
    	CubeEdge edge2 = new CubeEdge("  o  ");

        assertTrue(edge1.isEdgeMatch(edge2));
    }
}
