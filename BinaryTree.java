import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {// BinaryTree Class
    Node root;

    public BinaryTree() {
        root = null;
    }
    
    public void insert(int key) {// Method to insert a new node with given key
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {// A function to insert a new key in BST
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) // insert the key to the tree
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    
    public void inorder() {// Method to print the tree inorder
        inorderRec(root);
    }

    private void inorderRec(Node root) { // Afunction to do inorder traversal of BST
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(int key) {// Method to search for a key in the tree
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) { //function to search for a key
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

        System.out.print("Enter the number of nodes: ");//getting the number of nodes 
        int n = sc.nextInt();
        
        System.out.println("Enter the keys of the nodes:");//getting the data from the user
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            tree.insert(key);
        }
       
        System.out.println("Inorder traversal:"); // printing the data in order
        tree.inorder();
        System.out.println();
        
        System.out.print("Enter a key to search: ");//searching a key and displaying if a key is found
        int searchKey = sc.nextInt();
        if (tree.search(searchKey)) {
            System.out.println("Key " + searchKey + " found in the tree.");
        } else {
            System.out.println("Key " + searchKey + " not found in the tree.");
        }
    }
}