

// BTree.java

public class BTree {
    // Placeholder implementation
    // You may need to customize this class based on your specific requirements

    private Node root;

    // Inner Node class
    private static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public BTree() {
        root = null;
    }

    // Method to insert a patient into the BTree
    public void insert(Patient patient) {
        root = insert(root, patient);
    }

    private Node insert(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient.getAge());
            return root;
        }

        if (patient.getAge() < root.data) {
            root.left = insert(root.left, patient);
        } else if (patient.getAge() > root.data) {
            root.right = insert(root.right, patient);
        }

        return root;
    }

}
