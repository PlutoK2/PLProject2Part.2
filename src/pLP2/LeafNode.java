package pLP2;

import java.util.ArrayList;


class LeafNode extends Node {
    ArrayList<Rectangle> rectangles;
    
    /*
     * This code Initializes a LeafNode with a defined spatial boundary and an empty list to store rectangles.
     * 
     * Args: xMin, yMin: The lower-left corner of the node's space.
		xMax, yMax: The upper-right corner of the node's space.
     * 
     * Returns: None
     * 
     * 
     * */
    public LeafNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        rectangles = new ArrayList<>();
    }

    /*
     * This code Adds the rectangle to the rectangles list if it doesn't already exist (checked by comparing x and y coordinates).
Throws an IllegalArgumentException if a rectangle with the same coordinates is already present.
     * 
     * Args: rect: A Rectangle object to be inserted into the leaf node.
     * 
     * Returns: None
     * 
     * 
     * */
    public void insert(Rectangle rect) {
        // Check for duplicates before adding
        for (Rectangle r : rectangles) {
            if (r.x == rect.x && r.y == rect.y) {
                throw new IllegalArgumentException("Duplicate rectangle at (" + rect.x + ", " + rect.y + ")");
            }
        }
        rectangles.add(rect);
    }

    /*
     * This code Removes rectangles from the rectangles list if their x and y coordinates match the specified values.
     * 
     * Args: x, y: The coordinates of the rectangle to be deleted.
     * 
     * Returns: None
     * 
     * 
     * */
    public void delete(double x, double y) {
        rectangles.removeIf(r -> r.x == x && r.y == y);
    }

    /*
     * This code Iterates through the rectangles list to locate a rectangle with the specified x and y coordinates.
     * 
     * Args: x, y: The coordinates of the rectangle to be found.
     * 
     * Returns: Rectangle: The rectangle matching the given coordinates, or null if no such rectangle exists.
     * 
     * 
     * */
    public Rectangle find(double x, double y) {
        for (Rectangle rect : rectangles) {
            if (rect.x == x && rect.y == y) {
                return rect;
            }
        }
        return null;
    }

    /*
     * This code Prints the boundaries of the leaf node and the details of all rectangles stored in it.
     * 
     * Args: level: The depth of the current node in the spatial hierarchy, used for formatting.
     * 
     * Returns: None
     * 
     * 
     * */
    public void dump(int level) {
        String tabs = "\t".repeat(level);
        System.out.println(tabs + "Leaf Node [" + xMin + ", " + yMin + "] to [" + xMax + ", " + yMax + "]");
        for (Rectangle rect : rectangles) {
            System.out.println(tabs + "\tRectangle at [" + rect.x + ", " + rect.y + "]: " + rect.width + "x" + rect.height);
        }
    }

    /*
     * This code Provides access to the collection of rectangles stored in the leaf node.
     * 
     * Args: None
     * 
     * Returns: ArrayList<Rectangle>: The list of rectangles stored in the node.
     * 
     * 
     * */
    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }
}

