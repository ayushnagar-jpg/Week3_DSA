package LinkedList.OnlineTicketReservationSystem;

class Ticket {
    int ticketID;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;
    
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
    private Ticket last;
    private int totalTickets = 0;

    public TicketReservationSystem() {
        last = null;
    }

    // Add a new ticket at the end
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                }
                totalTickets--;
                System.out.println("Ticket " + ticketID + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
        System.out.println("Ticket not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets found.");
            return;
        }
        Ticket current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found: ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName);
                found = true;
            }
            current = current.next;
        } while (current != last.next);
        if (!found) System.out.println("No matching tickets found.");
    }

    // Get total booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}

public class TicketReservationDemo {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        
        system.addTicket(101, "Alice", "Inception", "A12", "18:00");
        system.addTicket(102, "Bob", "Interstellar", "B5", "20:00");
        system.addTicket(103, "Charlie", "Inception", "C7", "18:00");
        
        system.displayTickets();
        
        system.searchTicket("Inception");
        system.removeTicket(102);
        
        system.displayTickets();
        System.out.println("Total Tickets: " + system.getTotalTickets());
    }
}

