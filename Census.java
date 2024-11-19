import java.util.Scanner;

class Node {
    String surnameIntitialInitial;
    int familyCount;
    Node left, right;

    public Node(String surnameIntitialInitial, int familyCount) {
        this.surnameIntitialInitial = surnameIntitialInitial;
        this.familyCount = familyCount;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Insertion
    public void insert(String surnameIntitialInitial, int familyCount) {
        root = insertRec(root, surnameIntitialInitial, familyCount);
    }

    private Node insertRec(Node root, String surnameIntitialInitial, int familyCount) {
        if (root == null) {
            root = new Node(surnameIntitialInitial, familyCount);
            return root;
        }
        if (surnameIntitialInitial.compareTo(root.surnameIntitialInitial) < 0) {
            root.left = insertRec(root.left, surnameIntitialInitial, familyCount);
        } else if (surnameIntitialInitial.compareTo(root.surnameIntitialInitial) > 0) {
            root.right = insertRec(root.right, surnameIntitialInitial, familyCount);
        }
        return root;
    }

    // Search
    public Node search(String surnameIntitialInitial) {
        return searchRec(root, surnameIntitialInitial);
    }

    private Node searchRec(Node root, String surnameIntitialInitial) {
        if (root == null || root.surnameIntitialInitial.equals(surnameIntitialInitial)) {
            return root;
        }
        if (surnameIntitialInitial.compareTo(root.surnameIntitialInitial) < 0) {
            return searchRec(root.left, surnameIntitialInitial);
        } else {
            return searchRec(root.right, surnameIntitialInitial);
        }
    }

    // Deletion
    public void delete(String surnameIntitialInitial) {
        root = deleteRec(root, surnameIntitialInitial);
    }

    private Node deleteRec(Node root, String surnameIntitialInitial) {
        if (root == null) {
            return root;
        }
        if (surnameIntitialInitial.compareTo(root.surnameIntitialInitial) < 0) {
            root.left = deleteRec(root.left, surnameIntitialInitial);
        } else if (surnameIntitialInitial.compareTo(root.surnameIntitialInitial) > 0) {
            root.right = deleteRec(root.right, surnameIntitialInitial);
        } else {
            // Node with one or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest
            // in the right subtree)
            Node temp = minValueNode(root.right);

            // Copy the inorder successor's content to this node

            root.surnameIntitialInitial = temp.surnameIntitialInitial;
            root.familyCount = temp.familyCount;

            // Delete the inorder successor
            root.right = deleteRec(root.right, temp.surnameIntitialInitial);
        }
        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;

    }

    // Display
    public void display() {
        displayRec(root);
    }

    private void displayRec(Node root) {
        if (root != null) {
            displayRec(root.left);
            System.out.println("Surname: " + root.surnameIntitialInitial + ", Family Count: " + root.familyCount);
            displayRec(root.right);
        }
    }
}


public class Census {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice;
        System.out.println("\t\t\t Census System \t\t\t");

        do {
            System.out.println("\n********* MENU *********");
            System.out.println("1. Input Census Data");
            System.out.println("2. Show Census Data");
            System.out.println("3. Search data");
            System.out.println("4. Delete data");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Discard invalid input
                System.out.print("Choose an option: ");
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Surname: ");
                    String surnameIntitialInitial = scanner.next();

                    System.out.print("Enter Number of People in Family: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Number of People in Family: ");
                    }
                    int familyCount = scanner.nextInt();
                    bst.insert(surnameIntitialInitial, familyCount);
                    break;
                case 2:
                    bst.display();
                    break;
                case 3:
					 System.out.print("Enter Surname to Search: ");
					 String searchSurname = scanner.next();
					 Node foundNode = bst.search(searchSurname);
					 if (foundNode != null) {
					    System.out.println("Family Found: " + foundNode.surnameIntitialInitial + ", Family Count: " + foundNode.familyCount);
					 } else {
					    System.out.println("Family Not Found.");
					 }
					    break;
				case 4:
					 System.out.print("Enter Surname to Delete: ");
					 String deleteSurname = scanner.next();
					 bst.delete(deleteSurname);
            		System.out.println("Family Deleted.");
           			 break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}