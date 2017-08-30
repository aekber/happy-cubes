package com.eko.assignment.api;


/**
 * Edges of piece
 * 
 */
public class CubeEdge implements ICubeEdge {

    private String edgeShape;

    public CubeEdge(String edgeShape) {
        this.edgeShape = edgeShape;
    }

    public String getEdgeShape() {
		return edgeShape;
	}

	public void setEdgeShape(String edgeShape) {
		this.edgeShape = edgeShape;
	}

	//get equivalence of a shape
	private String getEquivalence(String edgeShape) {
        String edgeShapeMatch = edgeShape.replace(' ', 'x').replace('o', ' ').replace('x', 'o');
        return edgeShapeMatch;
    }

    //compare current edge with incoming edge
    public boolean isEdgeMatch(ICubeEdge edge) {
    	String middleOfCurrentEdgeShape = this.getEdgeShape().substring(1, 3);
    	String middleOfIncomingEdgeShape = ((CubeEdge)edge).getEdgeShape().substring(1, 3);
    	String equivalenceOfMiddleOfIncomingEdgeShape = getEquivalence(middleOfIncomingEdgeShape);
    	boolean isMatchMiddle = middleOfCurrentEdgeShape.equals(equivalenceOfMiddleOfIncomingEdgeShape);
    	
    	boolean isMatchCorners = isCornerMatch(edge);
        return isMatchMiddle && isMatchCorners;
    }

    private boolean isCornerMatch(ICubeEdge edge) {
		return (this.getEdgeShape().charAt(0) != 'o' || ((CubeEdge)edge).getEdgeShape().charAt(0) != 'o') &&
			   (this.getEdgeShape().charAt(4) != 'o' || ((CubeEdge)edge).getEdgeShape().charAt(4) != 'o');

	}
    
    public CubeEdge reverseEdgeShape() {
    	String reversedEdgeShape = reverseString(this.getEdgeShape());
        return new CubeEdge(reversedEdgeShape);
    }
    
	private String reverseString(String value) {
		String reverse = "";
        if(value.length() == 1){
            return value;
        } else {
            reverse += value.charAt(value.length() - 1) + reverseString(value.substring(0, value.length() - 1));
            return reverse;
        }
	}

}
