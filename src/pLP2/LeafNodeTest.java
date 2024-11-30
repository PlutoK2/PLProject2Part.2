package pLP2;

public class LeafNodeTest {

    public static void main(String[] args) {
        // Run the tests
        testLeafNodeInsert();
        testLeafNodeSizeLimit();
    }

    // Test inserting a rectangle into a LeafNode
    public static void testLeafNodeInsert() {
        LeafNode leafNode = new LeafNode(-50, -50, 50, 50);
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        leafNode.insert(rect);

        // Check if the rectangle was inserted
        if (leafNode.getRectangles().size() == 1) {
            System.out.println("testLeafNodeInsert PASSED");
        } else {
            System.out.println("testLeafNodeInsert FAILED");
        }
    }

    // Test inserting beyond the size limit of 5 rectangles in LeafNode
    public static void testLeafNodeSizeLimit() {
        LeafNode leafNode = new LeafNode(-50, -50, 50, 50);
        
        // Insert 6 rectangles to exceed the limit
        for (int i = 0; i < 6; i++) {
            leafNode.insert(new Rectangle(i * 10, i * 10, 5, 5));
        }

        // Ensure the leaf node does not exceed 5 rectangles
        if (leafNode.getRectangles().size() <= 5) {
            System.out.println("testLeafNodeSizeLimit PASSED");
        } else {
            System.out.println("testLeafNodeSizeLimit FAILED");
        }
    }
}
