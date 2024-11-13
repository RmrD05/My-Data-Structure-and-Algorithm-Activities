import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree Class
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node with given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Method to print the tree inorder
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A utility function to search for a key in BST
    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter the keys of the nodes:");
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            tree.insert(key);
        }

        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println();

        System.out.print("Enter a key to search: ");
        int searchKey = sc.nextInt();
        if (tree.search(searchKey)) {
            System.out.println("Key " + searchKey + " found in the tree.");
        } else {
            System.out.println("Key " + searchKey + " not found in the tree.");
        }
    }
}