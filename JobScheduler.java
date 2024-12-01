import java.util.PriorityQueue;
import java.util.Scanner;

class Job implements Comparable<Job> { //used for ensuring that the higher priority job is at the top
  String description;
  int priority;

  public Job(String description, int priority) {
    this.description = description;
    this.priority = priority;
  }

  public int compareTo(Job job) {// Higher priority jobs come first
    return job.priority - this.priority;
  }
}

public class JobScheduler {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to the Job Scheduler!");

    System.out.print("Enter the number of jobs to schedule initially: "); //prompt the user to input initial jobs
    int n = sc.nextInt();

    PriorityQueue<Job> pq = new PriorityQueue<>();//initialize a Priority Queue named pq


    for (int i = 0; i < n; i++) {  // for scheduling the initial jobs
      System.out.println("Enter details for Job " + (i + 1) + ":");
      System.out.print("Job Description: ");
      String description = sc.next();
      System.out.print("Priority (higher number = higher priority): ");
      int priority = sc.nextInt();

      pq.offer(new Job(description, priority));
    }

    boolean continueScheduling = true;
    while (continueScheduling) { //loop for recurring insertion if the user wishes to do so
      System.out.println("\nWhat do you want to do?");
      System.out.println("1. Insert a new job");
      System.out.println("2. Process jobs");
      System.out.println("3. Delete a job");
      System.out.println("4. Exit");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Enter details for the new job:");
          System.out.print("Job Description: ");
          String description = sc.next();
          System.out.print("Priority (higher number = higher priority): ");
          int priority = sc.nextInt();

          insertJob(pq, description, priority);
          break;
        case 2:
          System.out.println("\nProcessing jobs in priority order:");
          while (!pq.isEmpty()) {
            Job job = pq.poll();
            System.out.println("Job Description: " + job.description + ", Priority: " + job.priority);
          }
          continueScheduling = false;
          break;
        case 3: // New case for deleting a job
          System.out.println("Enter the description of the job you want to delete: ");
          String deleteDescription = sc.next();
          deleteJob(pq, deleteDescription);
          break;
        case 4:
          System.out.println("Exiting...");
          continueScheduling = false;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }

    sc.close();
  }

  public static void insertJob(PriorityQueue<Job> pq, String description, int priority) { // function for inserting more jobs to the schedule
    pq.offer(new Job(description, priority));
    System.out.println("Job inserted successfully!");
  }

  public static void deleteJob(PriorityQueue<Job> pq, String description) { // deletes jobs that the user wish to delete

    boolean jobDeleted = false;
    for (Job job : pq) {
      if (job.description.equals(description)) {
        pq.remove(job);
        jobDeleted = true;
        break;
      }
    }
    if (jobDeleted) {
      System.out.println("Job deleted successfully!");
    } else {
      System.out.println("Job with description '" + description + "' not found.");
    }
  }
}