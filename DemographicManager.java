
import java.util.ArrayList;
import java.util.Collections; // Used for the sorting of names
import java.util.Comparator; // Comparing
import java.util.LinkedList;
import java.util.Scanner;

public class DemographicManager {
    private LinkedList<Family>[] table;

    public DemographicManager(int size) { // Constructor to create or initialize the hash table
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void addFamily(String familyName, String monthlySalary) { // Method to add a family
        Family family = new Family(familyName, monthlySalary);
        int index = familyName.hashCode() % table.length; // Use hashCode for better distribution
        table[index].add(family);
        System.out.println("Family added: " + family);
    }

    public Family searchFamily(String familyName) { // Method to search for a family by name
        int index = familyName.hashCode() % table.length;
        for (Family family : table[index]) {
            if (family.getName().equalsIgnoreCase(familyName)) {
                return family; // Return the family if found
            }
        }
        return null; // Return null if the family is not found
    }

    public boolean deleteFamily(String familyName) { // Method to delete a family by name
        int index = familyName.hashCode() % table.length;
        for (Family family : table[index]) {
            if (family.getName().equalsIgnoreCase(familyName)) {
                table[index].remove(family); // Remove the family from the linked list
                System.out.println("Family deleted: " + family);
                return true; // Return true if deletion was successful
            }
        }
        System.out.println("Family not found for deletion.");
        return false; // Return false if the family was not found
    }

    public void displayFamily() { // Method to display all families in alphabetical order
        ArrayList<Family> allFamilies = new ArrayList<>();

        // Collect all families from the hash table
        for (int i = 0; i < table.length; i++) {
            allFamilies.addAll(table[i]);
        }

        // Sort the families by name
        Collections.sort(allFamilies, Comparator.comparing(Family::getName));

        // Display the sorted families
        System.out.println("Families:");
        for (Family family : allFamilies) {
            System.out.println(family);
        }
    }

    private static class Family { // Family class to store family information
        private String familyName;
        private String monthlySalary;

        public Family(String familyName, String monthlySalary) {
            this.familyName = familyName;
            this.monthlySalary = monthlySalary;
        }

        public String getName() {
            return familyName;
        }

        public String toString() {
            return "Family: " + familyName + ", Salary: " + monthlySalary;
        }
    }

    public static void main(String[] args) { // Main method to run the application
        Scanner scanner = new Scanner(System.in);
        DemographicManager demographicManager = new DemographicManager(10); // Create a hash table with size 10

        while (true) { // Choices to ask the user what they want to do
            System.out.println("\nDemographic Manager");
            System.out.println("1. Add Family");
            System.out.println("2. Search Family");
            System.out.println("3. Display Families");
            System.out.println("4. Delete Family");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Input the family name and the salary
                    System.out.print("Enter family name: ");
                    String familyName = scanner.nextLine();
                    System.out.print("Enter monthly salary: ");
                    String monthlySalary = scanner.nextLine();
                    demographicManager.addFamily(familyName, monthlySalary);
                    break;
                case 2: // Search a family within the hash table
                    System.out.print("Enter family to search: ");
                    String searchName = scanner.nextLine();
                    Family foundFamily = demographicManager.searchFamily(searchName);
                    if (foundFamily != null) {
                        System.out.println("Family found: " + foundFamily);
                    } else {
                        System.out.println("Family not found.");
                    }
                    break;
                case 3:
                    demographicManager.displayFamily();
                    break;
 case 4: // Delete a family from the hash table
                    System.out.print("Enter family name to delete: ");
                    String deleteName = scanner.nextLine();
                    demographicManager.deleteFamily(deleteName);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
