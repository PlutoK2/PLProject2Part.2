package pLP2;

public class RectangleTest {

    public static void main(String[] args) {
        // Run the tests
        testRectangleConstructor();
        testRectangleProperties();
    }

    // Test the constructor of Rectangle
    public static void testRectangleConstructor() {
        Rectangle rect = new Rectangle(10, 20, 5, 5);
        if (rect.x == 10 && rect.y == 20 && rect.width == 5 && rect.height == 5) {
            System.out.println("testRectangleConstructor PASSED");
        } else {
            System.out.println("testRectangleConstructor FAILED");
        }
    }

    // Test access to properties of the rectangle
    public static void testRectangleProperties() {
        Rectangle rect = new Rectangle(0, 0, 10, 20);
        if (rect.getX() == 0 && rect.getY() == 0 && rect.getWidth() == 10 && rect.getHeight() == 20) {
            System.out.println("testRectangleProperties PASSED");
        } else {
            System.out.println("testRectangleProperties FAILED");
        }
    }
}
