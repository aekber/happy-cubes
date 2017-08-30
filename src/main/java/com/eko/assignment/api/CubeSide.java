package com.eko.assignment.api;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 *Piece sides.This class contains all edges of a side
 * 
 */
public class CubeSide implements ICubeSide {

    private ICubeEdge topEdge, bottomEdge, leftEdge, rightEdge;

    public CubeSide(String[] rows) { //gelen row lardan birer kenar olusturuldu : top,bottom,left,right
        this.topEdge = getTopEdge(rows);
        this.bottomEdge = getBottomEdge(rows);
        this.leftEdge = getLeftEdge(rows);
        this.rightEdge = getRightEdge(rows);
    }

	public CubeSide() {
    	
    }

	public ICubeEdge getTopEdge() {
		return topEdge;
	}

	public void setTopEdge(ICubeEdge topEdge) {
		this.topEdge = topEdge;
	}

	public ICubeEdge getBottomEdge() {
		return bottomEdge;
	}

	public void setBottomEdge(ICubeEdge bottomEdge) {
		this.bottomEdge = bottomEdge;
	}

	public ICubeEdge getLeftEdge() {
		return leftEdge;
	}

	public void setLeftEdge(ICubeEdge leftEdge) {
		this.leftEdge = leftEdge;
	}

	public ICubeEdge getRightEdge() {
		return rightEdge;
	}

	public void setRightEdge(ICubeEdge rightEdge) {
		this.rightEdge = rightEdge;
	}

	//reverse the side
    public CubeSide getReverseSide() {
        CubeSide side = new CubeSide();
        side.setTopEdge(this.getTopEdge().reverseEdgeShape());
        side.setBottomEdge(this.getBottomEdge().reverseEdgeShape());
        side.setLeftEdge(this.getRightEdge());
        side.setRightEdge(this.getLeftEdge());

        return side;
    }

    private ICubeEdge getTopEdge(String[] rows) {
    	return new CubeEdge(rows[0]);
	}
    
    private ICubeEdge getBottomEdge(String[] rows) {
    	return new CubeEdge(rows[4]);
	}
    
    private CubeEdge getLeftEdge(String[] rows) {
    	return new CubeEdge(Arrays.asList(rows).stream().map(i -> i.charAt(0) + "").collect(Collectors.joining()));
    }

    private CubeEdge getRightEdge(String[] rows) {
    	return new CubeEdge(Arrays.asList(rows).stream().map(i -> i.charAt(4) + "").collect(Collectors.joining()));
    }

}
