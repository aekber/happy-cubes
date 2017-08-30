package com.eko.assignment.solver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.eko.assignment.api.CubePiece;


public class CubeSolution {

    public CubeController getSolution(List<CubePiece> pieces) {
        CubeController cube = CubeController.createCube();
        return solution(cube, pieces);
    }

    private CubeController solution(CubeController cube, List<CubePiece> pieceList) {
        if (cube.getCurrentFace() == 6) {
            return cube;
        }

        if (pieceList.isEmpty()) {
            return null;
        }

        for (CubePiece piece : pieceList) {
            CubeController result = solve(pieceList, cube, piece);
            if (result != null) {
                return result;
            }

            result = solve(pieceList, cube, piece.swapSide());
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private CubeController cloneCube(CubeController cube){
    	try{
    		CubeController clone = cube.getClass().newInstance();
    		for (Field field : cube.getClass().getDeclaredFields()) {
    			field.setAccessible(true);
    			field.set(clone, field.get(cube));
    		}
    		return clone;
    	}catch(Exception e){
    		return null;
    	}
    }
    
    private CubeController solve(List<CubePiece> pieceList, CubeController cube, CubePiece piece) {
        for (int i = 0; i < 4; i++) {
            if (cube.isCubePieceMatch(piece)) {
                CubeController c = cloneCube(cube);
                c.setPiece(piece);
                List<CubePiece> tempList = new ArrayList<CubePiece>(pieceList);
                tempList.remove(piece);
                CubeController result = solution(c, tempList);
                if (result != null) {
                    return result;
                }
            }
            piece.rotateRight();
        }

        return null;
    }
}
