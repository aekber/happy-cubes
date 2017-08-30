package com.eko.assignment.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.eko.assignment.api.CubePiece;
import com.eko.assignment.solver.CubeController;
import com.eko.assignment.solver.CubeSolution;

public class CubeSolverTest {

	private String SOLVED_CUBE = 
			  "  o    o o o o "
			+ " ooo ooooo ooo "
			+ "ooooo ooo ooooo"
			+ " ooo ooooo ooo "
			+ "  o   o oo  o  "
			+ "     o o       "
			+ "     ooooo     "
			+ "      ooo      "
			+ "     ooooo     "
			+ "      o o      "
			+ "     o o o     "
			+ "     ooooo     "
			+ "      ooo      "
			+ "     ooooo     "
			+ "     o o o     "
			+ "      o o      "
			+ "     oooo      "
			+ "      oooo     "
			+ "     oooo      "
			+ "     oo o      ";

	
	@Test
	public void testCube() throws IOException {
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
		
		List<CubePiece> pieces = Arrays.asList(piece0, piece1, piece2, piece3, piece4, piece5);
		
		CubeSolution solver = new CubeSolution();
		CubeController solution = solver.getSolution(pieces);
		
		assertNotNull(solution);
		assertTrue(solution.getCurrentFace() == 6);
		
		String result = solution.writePiecesToConsole();
		
		assertEquals(SOLVED_CUBE, result.replace("\n", "").replace("\r", ""));
	}
}
