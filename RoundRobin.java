class Process {
    int processID;
    int burstTime;
    int priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;

    // Add a process to the end of the circular linked list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head; // Circular link
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head; // Circular link
        }
        System.out.println("Process " + processID + " added.");
    }

    // Simulate Round Robin Scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        Process current = head;
        while (true) {
            System.out.println("Executing Process ID: " + current.processID + " | Remaining Burst Time: " + current.burstTime);
            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum; // Reduce burst time
                System.out.println("Process " + current.processID + " not completed. Moving to next process.");
            } else {
                System.out.println("Process " + current.processID + " completed.");
                removeProcess(current.processID); // Remove process
                if (head == null) {
                    System.out.println("All processes completed.");
                    break;
                }
            }
            current = current.next; // Move to next process
        }
    }

    // Remove a process by ID
    public void removeProcess(int processID) {
        if (head == null) return;

        Process temp = head, prev = null;
        do {
            if (temp.processID == processID) {
                if (temp == head) {
                    Process last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) {
                        head = null;
                    } else {
                        last.next = head.next;
                        head = head.next;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process " + processID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display all processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 15, 2);
        scheduler.addProcess(3, 5, 3);

        System.out.println("All processes:");
        scheduler.displayProcesses();

        System.out.println("\nSimulating Round Robin with Time Quantum = 5:");
        scheduler.simulateRoundRobin(5);
    }
}
