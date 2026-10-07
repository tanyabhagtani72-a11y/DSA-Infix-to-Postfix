import java.util.Scanner;

public class CircularQueue {

    int[] queue;
    int front = -1;
    int rear = -1;
    int size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int job) {

        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = job;
        System.out.println("Print job " + job + " added.");
    }

    void dequeue() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Print job " + queue[front] + " completed.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void display() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Print Queue: ");

        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);

        while (true) {

            System.out.println("\n--- Printer Queue ---");
            System.out.println("1. Add Print Job");
            System.out.println("2. Complete Print Job");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter print job number: ");
                    int job = sc.nextInt();
                    cq.enqueue(job);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}