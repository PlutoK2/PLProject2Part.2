package pLP2;



class Rectangle {
    double x, y, width, height;
    
    
    /*
     * This code initializes a Rectangle object with the specified position (x, y) and dimensions (width, height).
     * 
     * Arg: x (double): The x-coordinate of the rectangle's lower-left corner.
     * 		y (double): The y-coordinate of the rectangle's lower-left corner.
     * 		width (double): The rectangle's width.
     * 		height (double): The rectangle's height.
     * 
     * Returns: None
     * 
     * */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    /*
     * This code returns the x-coordinate of the lower-left corner of the rectangle.
     * 
     * Args: None
     * 
     * Returns: double: The x coordinate of the rectangle.
     * */
    public double getX() {
        return x;
    }
    /*
     * This code returns the y-coordinate of the lower-left corner of the rectangle.
     * 
     * Args: None
     * 
     * Returns: double: The y coordinate of the rectangle.
     * 
     * */
    public double getY() {
        return y;
    }
    
    /*
     * This code returns the rectangle's width.
     * 
     * Args: None
     * 
     * Returns: double: The width of the rectangle.
     * 
     * */
    public double getWidth() {
        return width;
    }
    
    /*
     * This code returns the rectangle's height.
     * 
     * Args: None
     * 
     * Returns: double: The height of the rectangle.
     * 
     * */
    public double getHeight() {
        return height;
    }
}

