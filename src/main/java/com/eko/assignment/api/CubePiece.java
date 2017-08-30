package com.eko.assignment.api;


/**
 * Piece of cube
 *
 */
public class CubePiece implements ICubePiece {

    private int pieceId;
    private ICubeSide actualSide, reverseSide;

    public CubePiece(int pieceId, String[] rows) {
        CubeSide side = new CubeSide(rows);
        actualSide = side;
        reverseSide = side.getReverseSide();
        this.pieceId = pieceId;
    }

    public CubePiece() {
    	
    }
    
    public ICubeSide getActualSide() {
		return actualSide;
	}

	public void setActualSide(ICubeSide actualSide) {
		this.actualSide = actualSide;
	}

	public ICubeSide getReverseSide() {
		return reverseSide;
	}

	public void setReverseSide(ICubeSide reverseSide) {
		this.reverseSide = reverseSide;
	}

	//change sides
    public CubePiece swapSide() {
        ICubeSide tmp = this.getActualSide();
        this.setActualSide(this.getReverseSide());
        this.setReverseSide(tmp);
        
        return this;
    }

    //get side as string array to write in file
    public String[] toStringArray() {
    	String[] result = new String[5];
    	
    	result[0] = ((CubeEdge) this.getActualSide().getTopEdge()).getEdgeShape();
    	for (int i = 1; i < 4; i++) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(((CubeEdge) this.getActualSide().getLeftEdge()).getEdgeShape().charAt(i));
    		sb.append("ooo");
    		sb.append(((CubeEdge) this.getActualSide().getRightEdge()).getEdgeShape().charAt(i));
    		result[i] = sb.toString();
    	}
    	result[4] = ((CubeEdge) this.getActualSide().getBottomEdge()).getEdgeShape();
    	return result;
    }
    
    //rotate right the side
    public void rotateRight() {
        ICubeEdge tmp = this.getActualSide().getTopEdge();
        this.getActualSide().setTopEdge(this.getActualSide().getLeftEdge().reverseEdgeShape());
        this.getActualSide().setLeftEdge(this.getActualSide().getBottomEdge());
        this.getActualSide().setBottomEdge(this.getActualSide().getRightEdge().reverseEdgeShape());
        this.getActualSide().setRightEdge(tmp);
    }

  //rotate left the side
    public void rotateLeft() {
        ICubeEdge tmp = this.getActualSide().getTopEdge();
        this.getActualSide().setTopEdge(this.getActualSide().getRightEdge());
        this.getActualSide().setRightEdge(this.getActualSide().getBottomEdge().reverseEdgeShape());
        this.getActualSide().setBottomEdge(this.getActualSide().getLeftEdge());
        this.getActualSide().setLeftEdge(tmp.reverseEdgeShape());
    }
    
    public boolean isFirstCornerValid() {
        return ((CubeEdge) this.getActualSide().getTopEdge()).getEdgeShape().charAt(0) == 'o';
    }

    public boolean isSecondCornerValid() {
        return ((CubeEdge) this.getActualSide().getTopEdge()).getEdgeShape().charAt(4) == 'o';
    }

    public boolean isThirdCornerValid() {
        return ((CubeEdge) this.getActualSide().getBottomEdge()).getEdgeShape().charAt(0) == 'o';
    }

    public boolean isFourthCornerValid() {
        return ((CubeEdge) this.getActualSide().getBottomEdge()).getEdgeShape().charAt(4) == 'o';
    }

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pieceId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CubePiece other = (CubePiece) obj;
		if (pieceId != other.pieceId)
			return false;
		return true;
	} 

}
