package pLP2;



class Quadtree {
    Node root;
    
    /*
     * This code Initializes the quadtree with a root LeafNode spanning the space from (-50, -50) to (50, 50).
     * 
     * Args: None 
     * 
     * Returns: None
     * 
     * 
     * */
    public Quadtree() {
        root = new LeafNode(-50, -50, 50, 50);  // Initial quadtree space
    }
    /*
     * This code Delegates the insertion of the rectangle to the root node.
If necessary, the tree will expand or convert LeafNodes to InternalNodes to accommodate the rectangle.
     * 
     * Args: rect: A Rectangle object to be inserted into the quadtree.
     * 
     * Returns: None
     * 
     * 
     * */
    public void insert(Rectangle rect) {
        root.insert(rect);
    }

    /*
     * This code Delegates the deletion operation to the root node, which recursively searches for and removes the rectangle matching the specified coordinates.
     * 
     * Args: x, y: Coordinates representing the location of the rectangle to be deleted.
     * 
     * Returns: None
     * 
     * 
     * */
    public void delete(double x, double y) {
        root.delete(x, y);
    }
    /*
     * This code Delegates the search to the root node, which traverses the tree and returns the rectangle if it is found.
     * 
     * Args: x, y: Coordinates representing the location of the rectangle to be found.
     * 
     * Returns: Rectangle: The rectangle at the specified coordinates, or null if no such rectangle exists.
     * 
     * 
     * */
    public Rectangle find(double x, double y) {
        return root.find(x, y);
    }
    /*
     * This code Prints the structure of the quadtree, starting from the root node. The tree hierarchy, including nodes and their rectangles, is displayed using indentation to indicate depth.
     * 
     * Args: None
     * 
     * Returns: None
     * 
     * 
     * */
    public void dump() {
        root.dump(0);
    }

    /*
     * This code Searches for a rectangle at the specified coordinates using find.
		If found, updates its dimensions (width and height).
		Throws an IllegalArgumentException if no rectangle exists at the specified coordinates.
     * 
     * Args: x, y: Coordinates of the rectangle to be updated.
			newWidth, newHeight: The updated dimensions for the rectangle.
     * 
     * Returns: None
     * 
     * 
     * */
    public void update(double x, double y, double newWidth, double newHeight) {
        Rectangle rect = find(x, y);
        if (rect != null) {
            rect.width = newWidth;
            rect.height = newHeight;
        } else {
            throw new IllegalArgumentException("Rectangle not found");
        }
    }
}


