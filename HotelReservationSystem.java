import java.util.*;

class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [Category: " + category + ", Price: $" + price + ", Available: " + isAvailable + "]";
    }
}

class Reservation {
    private int reservationId;
    private String customerName;
    private Room room;
    private double amountPaid;

    public Reservation(int reservationId, String customerName, Room room, double amountPaid) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.room = room;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Customer: " + customerName + ", Room: " + room.getRoomNumber() + ", Amount Paid: $" + amountPaid;
    }
}

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static int nextReservationId = 1;

    public static void main(String[] args) {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~Hotel Reservation System~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(103, "Suite", 300));
        rooms.add(new Room(104, "Single", 100));
        rooms.add(new Room(105, "Double", 150));
    }

    private static void searchRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room not available or invalid room number.");
            return;
        }

        System.out.print("Enter payment amount ($" + selectedRoom.getPrice() + "): ");
        double amountPaid = scanner.nextDouble();

        if (amountPaid < selectedRoom.getPrice()) {
            System.out.println("Insufficient payment. Reservation failed.");
            return;
        }

        selectedRoom.setAvailable(false);
        Reservation reservation = new Reservation(nextReservationId++, customerName, selectedRoom, amountPaid);
        reservations.add(reservation);

        System.out.println("Reservation successful! Details:");
        System.out.println(reservation);
    }

    private static void viewReservations() {
        System.out.println("\nAll Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
