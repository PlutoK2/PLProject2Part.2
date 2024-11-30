package pLP2;

public class InternalNodeTest {

    public static void main(String[] args) {
        // Run the tests
        testInternalNodeSplit();
        testInternalNodeInsertAfterSplit();
    }

    // Test InternalNode splitting behavior
    public static void testInternalNodeSplit() {
        InternalNode internalNode = new InternalNode(-50, -50, 50, 50);

        // Insert 6 rectangles to trigger the split
        for (int i = 0; i < 6; i++) {
            internalNode.insert(new Rectangle(i * 10, i * 10, 5, 5));
        }

        // Check if the InternalNode has split into 4 children (LeafNodes)
        if (internalNode.getChildren().length == 4) {
            System.out.println("testInternalNodeSplit PASSED");
        } else {
            System.out.println("testInternalNodeSplit FAILED");
        }
    }

    // Test inserting into an InternalNode after it has split into children
    public static void testInternalNodeInsertAfterSplit() {
        InternalNode internalNode = new InternalNode(-50, -50, 50, 50);

        // Insert 6 rectangles to trigger the split
        for (int i = 0; i < 6; i++) {
            internalNode.insert(new Rectangle(i * 10, i * 10, 5, 5));
        }

        // Insert a new rectangle after the split
        Rectangle newRect = new Rectangle(5, 5, 5, 5);
        internalNode.insert(newRect);

        // Check if the rectangle was inserted into one of the child LeafNodes
        boolean inserted = false;
        for (Node child : internalNode.getChildren()) {
            if (child instanceof LeafNode && ((LeafNode) child).getRectangles().contains(newRect)) {
                inserted = true;
                break;
            }
        }

        if (inserted) {
            System.out.println("testInternalNodeInsertAfterSplit PASSED");
        } else {
            System.out.println("testInternalNodeInsertAfterSplit FAILED");
        }
    }
}
