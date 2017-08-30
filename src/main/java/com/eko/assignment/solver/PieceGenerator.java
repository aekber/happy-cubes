package com.eko.assignment.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.eko.assignment.api.CubePiece;
import com.eko.assignment.exception.HappyCubeException;

/**
 * This class generates pieces from unsolved cube
 *
 */
public class PieceGenerator {
    
    public static List<CubePiece> getPieces(String[] cubeInput) throws HappyCubeException {
        
    	List<CubePiece> pieces = new ArrayList<CubePiece>();
    	
    	String[] piece1 = new String[5];
    	String[] piece2 = new String[5];
    	String[] piece3 = new String[5];
        
    	for (int i = 0; i < 2; i++) {
    		
	        for (int j = 0; j < 5; j++) {
	        	String linePerPiece = cubeInput[i*5+j];
	        	
	        	if(!isLineValid(linePerPiece)){
	        		throw new HappyCubeException("Input line is not in expected format : " + linePerPiece);
	        	}
	        	
	        	piece1[j] = linePerPiece.substring(0, 5);
	        	piece2[j] = linePerPiece.substring(5, 10);
	        	piece3[j] = linePerPiece.substring(10, 15);
	        }
	        
			CubePiece p1 = new CubePiece(pieces.size() + 1, piece1);
			pieces.add(p1);
			CubePiece p2 = new CubePiece(pieces.size() + 1, piece2);
			pieces.add(p2);
			CubePiece p3 = new CubePiece(pieces.size() + 1, piece3);
			pieces.add(p3);
			
			piece1 = new String[5];
			piece2 = new String[5];
			piece3 = new String[5];
    	}
    	return pieces;
    }

    //checks line validity before process the line
    private static boolean isLineValid(String line){
        return Pattern.compile("^(?=.*o)(?=.*\\s)[o\\s]{15}$").matcher(line).matches();
    }

}
