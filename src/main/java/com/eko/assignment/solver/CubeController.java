package com.eko.assignment.solver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.eko.assignment.api.CubeEdge;
import com.eko.assignment.api.CubePiece;

/**
 * This class contains controller methods to validate solution
 *
 */
public class CubeController {
	
	//this map holds all faces of cube
	private Map<Integer, CubePiece> cubeFaceMap = new HashMap<>();
	private int currentFace = 0;

	public Map<Integer, CubePiece> getCubeFaceMap() {
		return cubeFaceMap;
	}

	public void setCubeFaceMap(Map<Integer, CubePiece> cubeFaceMap) {
		this.cubeFaceMap = cubeFaceMap;
	}

	public int getCurrentFace() {
		return currentFace;
	}

	public void setCurrentFace(int currentFace) {
		this.currentFace = currentFace;
	}

	//checks whether edges of piece match or not
	public boolean isCubePieceMatch(CubePiece incomingPiece) {
		
		if(this.getCurrentFace() == 1){
			CubePiece currenctPiece = getPiece(0);
			CubeEdge currentRightEdge = (CubeEdge) currenctPiece.getActualSide().getRightEdge();
			CubeEdge currentLeftEdge = (CubeEdge) incomingPiece.getActualSide().getLeftEdge();
			
			return currentRightEdge.isEdgeMatch(currentLeftEdge);
		}
		
		if(this.getCurrentFace() == 2){
			CubePiece currenctPiece = getPiece(1);
			CubeEdge currentRightEdge = (CubeEdge) currenctPiece.getActualSide().getRightEdge();
			CubeEdge currentLeftEdge = (CubeEdge) incomingPiece.getActualSide().getLeftEdge();
			
			return currentRightEdge.isEdgeMatch(currentLeftEdge);
		}
		
		if(this.getCurrentFace() == 3){
			CubePiece piece0 = getPiece(0);
			CubePiece piece1 = getPiece(1);
			CubePiece piece2 = getPiece(2);
			CubeEdge piece0BottomEdge = (CubeEdge) piece0.getActualSide().getBottomEdge();
			CubeEdge piece1BottomEdge = (CubeEdge) piece1.getActualSide().getBottomEdge();
			CubeEdge piece2BottomEdge = (CubeEdge) piece2.getActualSide().getBottomEdge();
			
			CubeEdge currentLeftEdge = (CubeEdge) incomingPiece.getActualSide().getLeftEdge();
			CubeEdge currentRightEdge = (CubeEdge) incomingPiece.getActualSide().getRightEdge();
			CubeEdge currentTopEdge = (CubeEdge) incomingPiece.getActualSide().getTopEdge();
			
			if(!piece0BottomEdge.isEdgeMatch(currentLeftEdge)){
				return false;
			}
			
			if(!piece1BottomEdge.isEdgeMatch(currentTopEdge)){
				return false;
			}
			
			if(!piece2BottomEdge.isEdgeMatch(currentRightEdge)){
				return false;
			}
			
			if(!((piece0.isFourthCornerValid() && !piece1.isThirdCornerValid() && !incomingPiece.isFirstCornerValid()) ||
			     (!piece0.isFourthCornerValid() && piece1.isThirdCornerValid() && !incomingPiece.isFirstCornerValid()) ||
			     (!piece0.isFourthCornerValid() && !piece1.isThirdCornerValid() && incomingPiece.isFirstCornerValid()))){
				return false;
			}
			
			if(!((piece1.isFourthCornerValid() && !piece2.isThirdCornerValid() && !incomingPiece.isSecondCornerValid()) ||
				(!piece1.isFourthCornerValid() && piece2.isThirdCornerValid() && !incomingPiece.isSecondCornerValid()) ||
				(!piece1.isFourthCornerValid() && !piece2.isThirdCornerValid() && incomingPiece.isSecondCornerValid()))){
				return false;
			}
			
			return true;
		}
		
		if(this.getCurrentFace() == 4){
			CubePiece piece0 = getPiece(0);
			CubePiece piece2 = getPiece(2);
			CubePiece piece3 = getPiece(3);
			CubeEdge piece0LeftEdge = (CubeEdge) piece0.getActualSide().getLeftEdge();
			CubeEdge piece2RightEdge = (CubeEdge) piece2.getActualSide().getRightEdge();
			CubeEdge piece3BottomEdge = (CubeEdge) piece3.getActualSide().getBottomEdge();
			
			CubeEdge currentLeftEdge = (CubeEdge) incomingPiece.getActualSide().getLeftEdge();
			CubeEdge currentRightEdge = (CubeEdge) incomingPiece.getActualSide().getRightEdge();
			CubeEdge currentTopEdge = (CubeEdge) incomingPiece.getActualSide().getTopEdge();
			
			if(!piece0LeftEdge.isEdgeMatch(currentLeftEdge)){
				return false;
			}
			
			if(!piece2RightEdge.isEdgeMatch(currentRightEdge)){
				return false;
			}
			
			if(!piece3BottomEdge.isEdgeMatch(currentTopEdge)){
				return false;
			}
			
			if(!((piece3.isThirdCornerValid() && !piece0.isThirdCornerValid() && !incomingPiece.isFirstCornerValid()) ||
			     (!piece3.isThirdCornerValid() && piece0.isThirdCornerValid() && !incomingPiece.isFirstCornerValid()) ||
			     (!piece3.isThirdCornerValid() && !piece0.isThirdCornerValid() && incomingPiece.isFirstCornerValid()))){
				return false;
			}
			
			if(!((piece3.isFourthCornerValid() && !piece2.isFourthCornerValid() && !incomingPiece.isSecondCornerValid()) ||
				(!piece3.isFourthCornerValid() && piece2.isFourthCornerValid() && !incomingPiece.isSecondCornerValid()) ||
				(!piece3.isFourthCornerValid() && !piece2.isFourthCornerValid() && incomingPiece.isSecondCornerValid()))){
				return false;
			}
			
			return true;
		}
		
		if(this.getCurrentFace() == 5){
			CubePiece piece0 = getPiece(0);
			CubePiece piece1 = getPiece(1);
			CubePiece piece2 = getPiece(2);
			CubePiece piece4 = getPiece(4);
			CubeEdge piece0TopEdge = (CubeEdge) piece0.getActualSide().getTopEdge();
			CubeEdge piece1TopEdge = (CubeEdge) piece1.getActualSide().getTopEdge();
			CubeEdge piece2TopEdge = (CubeEdge) piece2.getActualSide().getTopEdge();
			CubeEdge piece4BottomEdge = (CubeEdge) piece4.getActualSide().getBottomEdge();
			
			CubeEdge currentLeftEdge = (CubeEdge) incomingPiece.getActualSide().getLeftEdge();
			CubeEdge currentBottomEdge = (CubeEdge) incomingPiece.getActualSide().getBottomEdge();
			CubeEdge currentRightEdge = (CubeEdge) incomingPiece.getActualSide().getRightEdge();
			CubeEdge currentTopEdge = (CubeEdge) incomingPiece.getActualSide().getTopEdge();
			
			if(!piece0TopEdge.isEdgeMatch(currentLeftEdge)){
				return false;
			}
			
			if(!piece1TopEdge.isEdgeMatch(currentBottomEdge)){
				return false;
			}
			
			if(!piece2TopEdge.isEdgeMatch(currentRightEdge)){
				return false;
			}
			
			if(!piece4BottomEdge.isEdgeMatch(currentTopEdge)){
				return false;
			}
			
			if(!((piece0.isFirstCornerValid() && !piece4.isThirdCornerValid() && !incomingPiece.isFirstCornerValid()) ||
			     (!piece0.isFirstCornerValid() && piece4.isThirdCornerValid() && !incomingPiece.isFirstCornerValid()) ||
			     (!piece0.isFirstCornerValid() && !piece4.isThirdCornerValid() && incomingPiece.isFirstCornerValid()))){
				return false;
			}
			
			if(!((piece4.isFourthCornerValid() && !piece2.isSecondCornerValid() && !incomingPiece.isSecondCornerValid()) ||
				(!piece4.isFourthCornerValid() && piece2.isSecondCornerValid() && !incomingPiece.isSecondCornerValid()) ||
				(!piece4.isFourthCornerValid() && !piece2.isSecondCornerValid() && incomingPiece.isSecondCornerValid()))){
				return false;
			}
			
			if(!((piece0.isSecondCornerValid() && !piece1.isFirstCornerValid() && !incomingPiece.isThirdCornerValid()) ||
				 (!piece0.isSecondCornerValid() && piece1.isFirstCornerValid() && !incomingPiece.isThirdCornerValid()) ||
				 (!piece0.isSecondCornerValid() && !piece1.isFirstCornerValid() && incomingPiece.isThirdCornerValid()))){
				return false;
			}
			
			if(!((piece1.isSecondCornerValid() && !piece2.isFirstCornerValid() && !incomingPiece.isFourthCornerValid()) ||
				(!piece1.isSecondCornerValid() && piece2.isFirstCornerValid() && !incomingPiece.isFourthCornerValid()) ||
				(!piece1.isSecondCornerValid() && !piece2.isFirstCornerValid() && incomingPiece.isFourthCornerValid()))){
				return false;
			}
			
			return true;
		}
		
		return true;
	}

	private CubePiece getPiece(int i) {
		return this.getCubeFaceMap().get(i);
	}

	public boolean setPiece(CubePiece piece) {
		if (this.getCurrentFace() != 6 && isCubePieceMatch(piece)) {
			this.getCubeFaceMap().put(this.getCurrentFace(), piece);
			this.setCurrentFace(this.getCurrentFace() + 1);
			return true;
		}
		return false;
	}
	
	//write solution in a file
	public void writePiecesToFile(String filePath) throws IOException {
		try (PrintWriter out = new PrintWriter(filePath)) {
			
			String[] p1 = getCubeFaceMap().get(0).toStringArray();
			String[] p2 = getCubeFaceMap().get(1).toStringArray();
			String[] p3 = getCubeFaceMap().get(2).toStringArray();
			String[] p4 = getCubeFaceMap().get(3).toStringArray();
			String[] p5 = getCubeFaceMap().get(4).toStringArray();
			String[] p6 = getCubeFaceMap().get(5).toStringArray();
			String[][] piece = {p4, p5, p6};
			
			for (int i = 0; i < 5; i++) {
				out.print(p1[i]);
				out.print(p2[i]);
				out.println(p3[i]);
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					out.print("     ");
					out.print(piece[i][j]);
					out.println("     ");
				}
			}
		}
	}
	
	//write solution in console
	public String writePiecesToConsole() {
		StringBuilder sb = new StringBuilder();
		
		String[] p1 = getCubeFaceMap().get(0).toStringArray();
		String[] p2 = getCubeFaceMap().get(1).toStringArray();
		String[] p3 = getCubeFaceMap().get(2).toStringArray();
		String[] p4 = getCubeFaceMap().get(3).toStringArray();
		String[] p5 = getCubeFaceMap().get(4).toStringArray();
		String[] p6 = getCubeFaceMap().get(5).toStringArray();
		String[][] piece = { p4, p5, p6 };

		for (int i = 0; i < 5; i++) {
			sb.append(p1[i]);
			sb.append(p2[i]);
			sb.append(p3[i] + "\n");
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				sb.append("     ");
				sb.append(piece[i][j]);
				sb.append("     \n");
			}
		}
		
		return sb.toString();

	}
	
	public static CubeController createCube() {
		CubeController cube = new CubeController();
		for (int i = 0; i < 6; i++) {
			cube.getCubeFaceMap().put(i, new CubePiece());
		}
		return cube;
	}
}
