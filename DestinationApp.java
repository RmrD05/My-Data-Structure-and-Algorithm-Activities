import java.util.*;

public class DestinationApp {

  
    public interface Graph {  // Initialization of the graph interface
        void addCity(String city);
        void addDistance(String city1, String city2, double distance);
        void displayGraph();
    }

    
    public static class SimpleGraph implements Graph {// creating a class named SimpleGraph class implementing the Graph interface
        private Map<String, List<Edge>> adjacencyList;

        
        private static class Edge {//the edge class to hold the destination and distance
            String destination;
            double distance;

            Edge(String destination, double distance) {
                this.destination = destination;
                this.distance = distance;
            }
        }

        public SimpleGraph() {
            adjacencyList = new HashMap<>();
        }

        @Override
        public void addCity(String city) { //method to add cities to the graph
            adjacencyList.putIfAbsent(city, new ArrayList<>());
        }

        @Override
        public void addDistance(String city1, String city2, double distance) { //method to add distance or weight betweent the cities
            adjacencyList.putIfAbsent(city1, new ArrayList<>());
            adjacencyList.putIfAbsent(city2, new ArrayList<>());
            adjacencyList.get(city1).add(new Edge(city2, distance));
            adjacencyList.get(city2).add(new Edge(city1, distance)); // For undirected graph
        }

        @Override
        public void displayGraph() { //method to display the data
            for (String city : adjacencyList.keySet()) {
                System.out.print(city + " -> ");
                for (Edge edge : adjacencyList.get(city)) {
                    System.out.print(edge.destination + " (" + edge.distance + " km) ");
                }
                System.out.println();
            }
        }
    }

    
    public static void main(String[] args) {// Main method to run the application
        Scanner scanner = new Scanner(System.in);
        Graph graph = new SimpleGraph();
        String command;

        System.out.println("Welcome to the Destination Application!");
        System.out.println("Available commands: AddCity, AddDistance, Display, Exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim();

            switch (command) {// switch case to choose the option
                case "AddCity":
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine().trim(); 
                    graph.addCity(city);
                    System.out.println("City " + city + " added.");
                    break;

                case "AddDistance":
                    System.out.print("Enter first city: ");
                    String city1 = scanner.nextLine().trim();
                    System.out.print("Enter second city: ");
                    String city2 = scanner.nextLine().trim();
                    System.out.print("Enter distance in kilometers: ");
                    double distance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    graph.addDistance(city1, city2, distance);
                    System.out.println("Distance added between " + city1 + " and " + city2 + ": " + distance + " km.");
                    break;

                case "Display":
                    System.out.println("Graph:");
                    graph.displayGraph();
                    break;

                case "Exit":
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
//Test case 
//AddDistance -> First city: Tuburan -> Second city: Balamban -> Distance in kilometer: 50
//Distance added between Tuburan and Balamban: 50.0 km.
//Display 
//Tuburan -> Balamban (30.0 km) 
//Balamban -> Tuburan (30.0 km) S