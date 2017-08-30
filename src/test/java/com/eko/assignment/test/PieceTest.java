package com.eko.assignment.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eko.assignment.api.CubePiece;

public class PieceTest {

	@Test
	public void testPiece() {
		String[] tPiece1 = {"  o  ",  
							" ooo ",
							"ooooo", 
							" ooo ",
							"  o  "};
		String[] tPiece2 = {"o o o",
							"ooooo",
							" ooo ",
							"ooooo",
							"o o o"};
		String[] tPiece3 = {"  o  ",
							" oooo",
							"oooo ",
							" oooo",
							"  o  "};
		
		CubePiece piece1 = new CubePiece(1, tPiece1);
		CubePiece piece2 = new CubePiece(2, tPiece2);
		CubePiece piece3 = new CubePiece(3, tPiece3);
		
		assertTrue(piece1.getActualSide().getRightEdge().isEdgeMatch(piece2.getActualSide().getRightEdge()));
		assertTrue(piece2.getActualSide().getRightEdge().isEdgeMatch(piece1.getActualSide().getLeftEdge()));
		assertTrue(piece2.getActualSide().getRightEdge().isEdgeMatch(piece3.getActualSide().getLeftEdge()));
		
		piece1.rotateRight();
		piece2.rotateRight();
		piece3.rotateRight();
		
		assertTrue(piece1.getActualSide().getBottomEdge().isEdgeMatch(piece2.getActualSide().getTopEdge()));
		assertTrue(piece2.getActualSide().getBottomEdge().isEdgeMatch(piece1.getActualSide().getTopEdge()));
		assertTrue(piece2.getActualSide().getBottomEdge().isEdgeMatch(piece3.getActualSide().getTopEdge()));
		
		piece1.rotateRight();
		piece2.rotateRight();
		piece3.rotateRight();
		
		assertTrue(piece1.getActualSide().getLeftEdge().isEdgeMatch(piece2.getActualSide().getRightEdge()));
		assertTrue(piece2.getActualSide().getLeftEdge().isEdgeMatch(piece1.getActualSide().getRightEdge()));
		assertTrue(piece2.getActualSide().getLeftEdge().isEdgeMatch(piece3.getActualSide().getRightEdge()));
		
		piece1.rotateRight();
		piece2.rotateRight();
		piece3.rotateRight();
		
		assertTrue(piece1.getActualSide().getTopEdge().isEdgeMatch(piece2.getActualSide().getBottomEdge()));
		assertTrue(piece2.getActualSide().getTopEdge().isEdgeMatch(piece1.getActualSide().getBottomEdge()));
		assertTrue(piece2.getActualSide().getTopEdge().isEdgeMatch(piece3.getActualSide().getBottomEdge()));
	}
	
	@Test
	public void testCube() {
		String[] tPiece0 = {"  o  ",
							" ooo ",
							"ooooo",
							" ooo ",
							"  o  "};
		String[] tPiece1 = {"  o o",				
							"ooooo",
							" ooo ",
							"ooooo",
							" o oo"};
		String[] tPiece2 = {" o o ",
							" ooo ",
							"ooooo",
							" ooo ",
							"  o  "};
		String[] tPiece3 = {"o o  ",     
						    "ooooo",
						    " ooo ",
						    "ooooo",
						    " o o "};
		String[] tPiece4 = {"o o o",     
						    "ooooo",
						    " ooo ",
						    "ooooo",
						    "o o o"};
		String[] tPiece5 = {" o o ",     
						    "oooo ",
						    " oooo",
						    "oooo ",
						    "oo o "};
		CubePiece piece0 = new CubePiece(1, tPiece0);
		CubePiece piece1 = new CubePiece(2, tPiece1);
		CubePiece piece2 = new CubePiece(3, tPiece2);
		CubePiece piece3 = new CubePiece(4, tPiece3);
		CubePiece piece4 = new CubePiece(5, tPiece4);
		CubePiece piece5 = new CubePiece(6, tPiece5);
		
		assertTrue(piece0.getActualSide().getRightEdge().isEdgeMatch(piece1.getActualSide().getLeftEdge()));
		assertTrue(piece1.getActualSide().getRightEdge().isEdgeMatch(piece2.getActualSide().getLeftEdge()));
		
		assertTrue(piece0.getActualSide().getBottomEdge().isEdgeMatch(piece3.getActualSide().getLeftEdge()));
		assertTrue(piece1.getActualSide().getBottomEdge().isEdgeMatch(piece3.getActualSide().getTopEdge()));
		assertTrue(piece2.getActualSide().getBottomEdge().isEdgeMatch(piece3.getActualSide().getRightEdge()));
		
		assertTrue(piece0.getActualSide().getLeftEdge().isEdgeMatch(piece4.getActualSide().getLeftEdge()));
		assertTrue(piece2.getActualSide().getRightEdge().isEdgeMatch(piece4.getActualSide().getRightEdge()));
		assertTrue(piece3.getActualSide().getBottomEdge().isEdgeMatch(piece4.getActualSide().getTopEdge()));
		
		assertTrue(piece0.getActualSide().getTopEdge().isEdgeMatch(piece5.getActualSide().getLeftEdge()));
		assertTrue(piece1.getActualSide().getTopEdge().isEdgeMatch(piece5.getActualSide().getBottomEdge()));
		assertTrue(piece2.getActualSide().getTopEdge().isEdgeMatch(piece5.getActualSide().getRightEdge()));
		assertTrue(piece4.getActualSide().getBottomEdge().isEdgeMatch(piece5.getActualSide().getTopEdge()));
	}

}
