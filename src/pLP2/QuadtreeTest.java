package pLP2;

public class QuadtreeTest {

    public static void main(String[] args) {
        // Run the tests
        testInsert();
        testInsertDuplicate();
        testDelete();
        testFindNotFound();
        testUpdate();
        testDump();
    }

    // Test insert functionality in Quadtree
    public static void testInsert() {
        Quadtree quadtree = new Quadtree();
        Rectangle rect = new Rectangle(10, 10, 5, 5);

        quadtree.insert(rect);
        Rectangle foundRect = quadtree.find(10, 10);

        if (foundRect != null && foundRect.x == 10 && foundRect.y == 10) {
            System.out.println("testInsert PASSED");
        } else {
            System.out.println("testInsert FAILED");
        }
    }

    // Test inserting a duplicate rectangle
    public static void testInsertDuplicate() {
        Quadtree quadtree = new Quadtree();
        Rectangle rect1 = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect1);

        Rectangle rect2 = new Rectangle(10, 10, 7, 7); // Same position
        boolean exceptionThrown = false;

        try {
            quadtree.insert(rect2);  // This should throw an exception
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        if (exceptionThrown) {
            System.out.println("testInsertDuplicate PASSED");
        } else {
            System.out.println("testInsertDuplicate FAILED");
        }
    }

    // Test deleting a rectangle from Quadtree
    public static void testDelete() {
        Quadtree quadtree = new Quadtree();
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect);

        quadtree.delete(10, 10);
        Rectangle foundRect = quadtree.find(10, 10);

        if (foundRect == null) {
            System.out.println("testDelete PASSED");
        } else {
            System.out.println("testDelete FAILED");
        }
    }

    // Test finding a non-existing rectangle
    public static void testFindNotFound() {
        Quadtree quadtree = new Quadtree();
        Rectangle foundRect = quadtree.find(100, 100);

        if (foundRect == null) {
            System.out.println("testFindNotFound PASSED");
        } else {
            System.out.println("testFindNotFound FAILED");
        }
    }

    // Test updating the size of a rectangle
    public static void testUpdate() {
        Quadtree quadtree = new Quadtree();
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect);

        // Update the rectangle's size
        quadtree.update(10, 10, 7, 7);
        Rectangle updatedRect = quadtree.find(10, 10);

        if (updatedRect != null && updatedRect.width == 7 && updatedRect.height == 7) {
            System.out.println("testUpdate PASSED");
        } else {
            System.out.println("testUpdate FAILED");
        }
    }

    // Test dumping the quadtree structure
    public static void testDump() {
        Quadtree quadtree = new Quadtree();
        quadtree.insert(new Rectangle(10, 10, 5, 5));
        quadtree.insert(new Rectangle(-10, -10, 3, 3));

        System.out.println("Dumping quadtree:");
        quadtree.dump(); // This will print the structure of the tree
        System.out.println("testDump PASSED");
    }
}
