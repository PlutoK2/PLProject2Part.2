package pLP2;




class InternalNode extends Node {
    Node[] children;
    
    /*
     * This code Initializes the InternalNode with a defined spatial boundary and an empty array of children (one for each quadrant).
     * 
     * Args:xMin, yMin: The lower-left corner of the node's space.
			xMax, yMax: The upper-right corner of the node's space.
     * 
     * Returns: None
     * 
     * 
     * */
    public InternalNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        children = new Node[4];  // 4 quadrants: top-right, top-left, bottom-right, bottom-left
    }

    /*
     * This code Determines which quadrant the rectangle belongs to using getQuadrant.
		If the corresponding child node is null, creates a new LeafNode for that quadrant.
     * 
     * Args: rect: A Rectangle object to be inserted into the spatial structure.
     * 
     * Returns: None
     * 
     * 
     * */
    public void insert(Rectangle rect) {
        int quadrant = getQuadrant(rect);
        if (children[quadrant] == null) {
            // Create a new LeafNode if the quadrant is empty
            children[quadrant] = new LeafNode(getChildXMin(quadrant), getChildYMin(quadrant), getChildXMax(quadrant), getChildYMax(quadrant));
        }
        // Insert the rectangle into the appropriate child node
        children[quadrant].insert(rect);
    }

    /*
     * This code Iterates through all child nodes and delegates the deletion operation to them if they are not null.
     * 
     * Args: x, y: Coordinates of the point identifying a rectangle to delete.
     * 
     * Returns: None
     * 
     * 
     * */
    public void delete(double x, double y) {
        for (Node child : children) {
            if (child != null) {
                child.delete(x, y);
            }
        }
    }

    /*
     * This code Iterates through all child nodes and recursively searches for the rectangle containing (x, y).
	Returns the first matching rectangle found or null if none exists.
     * 
     * Args: x, y: Coordinates of the point to locate.
     * 
     * Returns: Rectangle: The rectangle containing the point (x, y), or null if no such rectangle exists.
     * 
     * 
     * */
    public Rectangle find(double x, double y) {
        for (Node child : children) {
            if (child != null) {
                Rectangle rect = child.find(x, y);
                if (rect != null) {
                    return rect;
                }
            }
        }
        return null;
    }

    /*
     * This code Prints the internal node's boundaries.
Recursively calls dump on each child node, increasing the level for indentation to represent the hierarchy visually.
     * 
     * Args: level: The depth of the current node in the spatial hierarchy, used for formatting.
     * 
     * Returns: None
     * 
     * 
     * */
    public void dump(int level) {
        String tabs = "\t".repeat(level);
        System.out.println(tabs + "Internal Node [" + xMin + ", " + yMin + "] to [" + xMax + ", " + yMax + "]");
        for (Node child : children) {
            if (child != null) {
                child.dump(level + 1);
            }
        }
    }

    /*
     * This code Determines the appropriate quadrant for a rectangle based on its position relative to the center of the node's space.
     * 
     * Args: rect: A Rectangle object.
     * 
     * Returns: int: The quadrant index where the rectangle fits:
	0: Top-right.
	1: Bottom-right.
	2: Top-left.
	3: Bottom-left.
     * 
     * 
     * */
    private int getQuadrant(Rectangle rect) {
        if (rect.x > (xMin + xMax) / 2) {
            if (rect.y > (yMin + yMax) / 2) return 0;  // top-right
            else return 1;  // bottom-right
        } else {
            if (rect.y > (yMin + yMax) / 2) return 2;  // top-left
            else return 3;  // bottom-left
        }
    }
    /*
     * This code Calculates the x-coordinate of the lower-left corner of the specified quadrant
     * 
     * Args: quadrant: The index of the quadrant.
     * 
     * Returns: double: The minimum x-coordinate of the quadrant.
     * 
     * 
     * */
    private double getChildXMin(int quadrant) {
        switch (quadrant) {
            case 0: return (xMin + xMax) / 2;
            case 1: return (xMin + xMax) / 2;
            case 2: return xMin;
            case 3: return xMin;
            default: return 0;
        }
    }
    /*
     * This code Calculates the y-coordinate of the lower-left corner of the specified quadrant.
     * 
     * Args: quadrant: The index of the quadrant.
     * 
     * Returns: double: The minimum y-coordinate of the quadrant.
     * 
     * 
     * */
    private double getChildYMin(int quadrant) {
        switch (quadrant) {
            case 0: return (yMin + yMax) / 2;
            case 1: return yMin;
            case 2: return (yMin + yMax) / 2;
            case 3: return yMin;
            default: return 0;
        }
    }
    /*
     * This code Calculates the x-coordinate of the upper-right corner of the specified quadrant.
     * 
     * Args: quadrant: The index of the quadrant.
     * 
     * Returns: double: The maximum x-coordinate of the quadrant.
     * 
     * 
     * */
    private double getChildXMax(int quadrant) {
        switch (quadrant) {
            case 0: return xMax;
            case 1: return xMax;
            case 2: return (xMin + xMax) / 2;
            case 3: return (xMin + xMax) / 2;
            default: return 0;
        }
    }
    /*
     * This code Calculates the y-coordinate of the upper-right corner of the specified quadrant.
     * 
     * Args: quadrant: The index of the quadrant.
     * 
     * Returns: double: The maximum y-coordinate of the quadrant.
     * 
     * 
     * */
    private double getChildYMax(int quadrant) {
        switch (quadrant) {
            case 0: return yMax;
            case 1: return (yMin + yMax) / 2;
            case 2: return yMax;
            case 3: return (yMin + yMax) / 2;
            default: return 0;
        }
    }

    /*
     * This code Provides access to the children array for other parts of the program.
     * 
     * Args: None
     * 
     * Returns: Node[]: An array of child nodes.
     * 
     * 
     * */
    public Node[] getChildren() {
        return children;
    }
}
