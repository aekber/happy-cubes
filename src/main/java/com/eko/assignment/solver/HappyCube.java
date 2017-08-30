package com.eko.assignment.solver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eko.assignment.api.CubePiece;
import com.eko.assignment.exception.HappyCubeException;

/**
 * Main solver class of happycube problem
 *
 */
public class HappyCube {

	public static void main(String[] args) throws HappyCubeException, IOException {

    	Map<String, String[]> happyCubeMap = new HashMap<>();
    	
        String[] blue = 	   {"  o  o o o  o  ",
								" ooo ooooo oooo",
								"ooooo ooo oooo ",
								" ooo ooooo oooo",
								"  o  o o o  o  ",
								" o o  o o  o o ",
								"oooo ooooo oooo",
								" oooo ooo oooo ",
								"oooo ooooo oooo",
								"oo o o o  oo oo"};
        
        String[] red = 	       {"   oo o o  oo o",
								" ooo oooo ooooo",
								"ooooo oooo ooo ",
								" ooo oooo ooooo",
								" o oo o   o  oo",
								"  o    oo  oo  ",
								"oooo ooooo ooo ",
								" oooo ooo ooooo",
								"oooo ooooo ooo ",
								"  o  o o  oo oo"};
        
        String[] violet = 	   {"oo o    oo o   ",
								"oooo oooo oooo ",
								"oooo ooooo oooo",
								" oooo ooo oooo ",
								"  o   o o   o  ",
								"oo oo  o o o oo",
								" oooo oooo ooo ",
								"oooo ooooo oooo",
								" ooo oooo oooo ",
								" o o o oo oo o "};
        
        String[] yellow = 	   {"  o    o o  o o",
								"oooo ooooo oooo",
								" oooo ooo oooo ",
								"oooo oooo ooooo",
								" o o  o o o o  ",
								"o o o  o   o o ",
								"ooooo oooo ooo ",
								" ooo oooo ooooo",
								"ooooo oooo ooo ",
								"o o  oo o  o oo"};
        
        happyCubeMap.put("blue", blue);
        happyCubeMap.put("red", red);
        happyCubeMap.put("violet", violet);
        happyCubeMap.put("yellow", yellow);
		
        for(Map.Entry<String, String[]> entry : happyCubeMap.entrySet()){
        	System.out.println("Solution started for " + entry.getKey() + " cube");
			List<CubePiece> pieces = PieceGenerator.getPieces(entry.getValue());
			CubeSolution cubeSolver = new CubeSolution();
			CubeController result = cubeSolver.getSolution(pieces);
			
			if (result == null) {
				System.err.println("No solution found for " + entry.getKey() + " cube !");
				continue;
			}
			
			result.writePiecesToFile(entry.getKey() + "_cube_solution.txt");
			System.out.println("Solution has been written to " + entry.getKey() + "_cube_solution.txt\n");
        }
	}
}
