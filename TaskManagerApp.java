import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Next Task");
            System.out.println("3. Remove Completed Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task priority (lower = higher priority): ");
                    int priority = scanner.nextInt();
                    taskQueue.offer(new Task(name, priority));
                    System.out.println("Task added.");
                    break;

                case 2:
                    Task next = taskQueue.peek();
                    if (next != null)
                        System.out.println("Next task: " + next);
                    else
                        System.out.println("No tasks in queue.");
                    break;

                case 3:
                    Task removed = taskQueue.poll();
                    if (removed != null)
                        System.out.println("Completed and removed: " + removed);
                    else
                        System.out.println("No tasks to remove.");
                    break;

                case 4:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks.");
                    } else {
                        System.out.println("All tasks (by priority):");
                        for (Task t : taskQueue) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Task Manager.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
