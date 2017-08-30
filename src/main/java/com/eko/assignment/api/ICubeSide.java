package com.eko.assignment.api;

/**
 * Interface representing a side of a piece.
 * 
 */
public interface ICubeSide {

	public ICubeEdge getTopEdge();
	public void setTopEdge(ICubeEdge topEdge);
	public ICubeEdge getLeftEdge();
	public void setLeftEdge(ICubeEdge leftEdge);
	public ICubeEdge getRightEdge();
	public void setRightEdge(ICubeEdge rightEdge);
	public ICubeEdge getBottomEdge();
	public void setBottomEdge(ICubeEdge bottomEdge);
}
