package pLP2;


abstract class Node {
    double xMin, yMin, xMax, yMax;  // Coordinates of the space the node covers

    /*
     * This function initializes a Node object with the spatial boundaries.
     * 
     * Arg: xMin, yMin: The lower-left corner of the rectangular space.
     * 		xMax, yMax: The upper-right corner of the rectangular space.
     * 
     * Returns: None
     * 
     * */
    public Node(double xMin, double yMin, double xMax, double yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    /*
     * This code checks if the given rectangle is entirely within the bounds of the node's space. 
     * 
     * Arg: rect (Rectangle): A rectangle to test for inclusion within the node's space.
     * 
     * Returns: boolean: true if the rectangle is fully contained within the node's space, otherwise false.
     * 
     * */
    public boolean contains(Rectangle rect) {
        return rect.x >= xMin && rect.y >= yMin && 
               rect.x + rect.width <= xMax && rect.y + rect.height <= yMax;
    }
    
    /*
     * This code defines an abstract method to insert a rectangle into the node.
     * 
     * Arg: rect (Rectangle): The rectangle to be inserted into the spatial structure.
     * 
     * Returns: None
     * 
     * */
    public abstract void insert(Rectangle rect);
    /*
     * This code defines an abstract method for deleting a rectangle associated with the specified point (x, y) from the node.
     * 
     * Arg: x, y: The coordinates of a point that identify a rectangle to delete.
     * 
     * Returns: None
     * */
    public abstract void delete(double x, double y);
    /*
     * This code Defines an abstract method to search for a rectangle that contains the specified point (x, y) within the node.
     * 
     * Arg: x, y: The coordinates of a point.
     * 
     * Returns: Rectangle: The rectangle containing the given point, or null if no such rectangle exists.
     * */
    public abstract Rectangle find(double x, double y);
    /*
     * This code defines an abstract method for dumping (printing or serializing) the node's content
     * 
     * Arg: level (int): A parameter indicating the current depth or level in the spatial hierarchy
     * 
     * Returns: None
     * */
    public abstract void dump(int level);
}

