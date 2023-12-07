// BTree.java

// Class representing a B-tree in the medical record system
public class BTree {
    // Constants for defining the degree of the B-tree
    private static final int DEGREE = 2;

    // Node class representing a node in the B-tree
    private static class Node {
        // Number of keys currently in the node
        int numKeys;
        // Arrays to store keys and child pointers
        Patient[] keys;
        Node[] children;
        // Flag indicating whether the node is a leaf
        boolean isLeaf;

        // Constructor to initialize a new node
        Node() {
            this.numKeys = 0;
            this.keys = new Patient[2 * DEGREE - 1];
            this.children = new Node[2 * DEGREE];
            this.isLeaf = true;
        }
    }

    // Root of the B-tree
    private Node root;

    // Constructor to initialize a new B-tree
    public BTree() {
        this.root = new Node();
    }

    // Method to insert a patient into the B-tree
    public void insert(Patient patient) {
        Node root = this.root;

        // If the root is full, split it
        if (root.numKeys == 2 * DEGREE - 1) {
            Node newRoot = new Node();
            this.root = newRoot;
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            insertNonFull(newRoot, patient);
        } else {
            insertNonFull(root, patient);
        }
    }

    // Method to insert a patient into a non-full node
    private void insertNonFull(Node node, Patient patient) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            // Insert the patient into the leaf node
            while (i >= 0 && patient.getSeverityOfIllness() < node.keys[i].getSeverityOfIllness()) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = patient;
            node.numKeys++;
        } else {
            // Insert into a child node
            while (i >= 0 && patient.getSeverityOfIllness() < node.keys[i].getSeverityOfIllness()) {
                i--;
            }
            i++;

            // If the child is full, split it
            if (node.children[i].numKeys == 2 * DEGREE - 1) {
                splitChild(node, i);
                if (patient.getSeverityOfIllness() > node.keys[i].getSeverityOfIllness()) {
                    i++;
                }
            }
            insertNonFull(node.children[i], patient);
        }
    }

    // Method to split a full child of a node
    private void splitChild(Node parentNode, int childIndex) {
        Node newChild = new Node();
        Node child = parentNode.children[childIndex];

        // Move the median key of the child to the parent
        for (int i = 2 * DEGREE - 2; i > DEGREE - 2; i--) {
            child.keys[i - DEGREE + 1] = child.keys[i];
        }

        parentNode.keys[childIndex] = child.keys[DEGREE - 1];
        child.numKeys = DEGREE - 1;

        // Move the right half of the child's keys to the new child
        for (int i = DEGREE; i < 2 * DEGREE - 1; i++) {
            newChild.keys[i - DEGREE] = child.keys[i];
        }

        // If the child is not a leaf, move the right half of its children to the new child
        if (!child.isLeaf) {
            for (int i = DEGREE; i < 2 * DEGREE; i++) {
                newChild.children[i - DEGREE] = child.children[i];
            }
        }

        child.numKeys = DEGREE - 1;

        // Adjust the parent's children array
        for (int i = parentNode.numKeys; i > childIndex + 1; i--) {
            parentNode.children[i + 1] = parentNode.children[i];
        }

        parentNode.children[childIndex + 1] = newChild;
        parentNode.numKeys++;
    }
}
