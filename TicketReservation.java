class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next; // Circular link

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;

    // Add a new ticket at the end of the circular linked list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head; // Circular link
        }
        System.out.println("Ticket booked for " + customerName + ".");
    }

    // Remove a ticket by ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head, prev = null;
        do {
            if (temp.ticketID == ticketID) {
                if (temp == head) { // Removing head ticket
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) { // Only one ticket in the list
                        head = null;
                    } else {
                        last.next = head.next;
                        head = head.next;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket ID " + ticketID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket ID " + ticketID + " not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + " | Customer: " + temp.customerName + 
                               " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + 
                               " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Aman", "Avengers", "A1", "10:00 AM");
        system.addTicket(102, "Baman", "Batman", "B2", "12:00 PM");
        system.addTicket(103, "Chaman", "Spiderman", "C3", "2:00 PM");

        system.displayTickets();

        system.removeTicket(102);
        system.displayTickets();
    }
}
