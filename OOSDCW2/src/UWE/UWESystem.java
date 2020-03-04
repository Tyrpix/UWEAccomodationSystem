package UWE;

import java.util.ArrayList;

public class UWESystem {

    private ArrayList<Hall> halls;

    // Singleton Method
    private static UWESystem instance;

    public static UWESystem getInstance() {
        if (instance == null) {
            instance = new UWESystem();

        }
        return instance;
    }

    private UWESystem() {
        // ArrayList containing halls
        halls = new ArrayList<Hall>();
        createHalls();
    }

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }


    public void createHalls() {
        // Construct Hall object
        Hall hall1 = new Hall(1,
                "Brecon",
                "UWE Bristol - Frenchay Campus, Coldharbour Ln, Bristol BS16 1QY",
                "0117 32132123");

        // Iterate room numbers and construct rooms
        for (int i = 0; i < 10; i++) {
            Room room = new Room(i + 1,
                    "Clean",
                    400);
            // Add room to hall
            hall1.addRoom(room);
        }

        Hall hall2 = new Hall(2,
                "Cotswold",
                "UWE Bristol - Frenchay Campus, Coldharbour Ln, Bristol BS16 1QY",
                "0117 32132123");

        for (int i = 0; i < 10; i++) {
            Room room = new Room(i + 1,
                    "Clean",
                    400);

            hall2.addRoom(room);
        }

        Hall hall3 = new Hall(3,
                "Mendip",
                "UWE Bristol - Frenchay Campus, Coldharbour Ln, Bristol BS16 1QY",
                "0117 32132123");

        for (int i = 0; i < 10; i++) {
            Room room = new Room(i + 1,
                    "Clean",
                    400);

            hall3.addRoom(room);
        }

        Hall hall4 = new Hall(4,
                "Quantock",
                "UWE Bristol - Frenchay Campus, Coldharbour Ln, Bristol BS16 1QY",
                "0117 32132123");

        for (int i = 0; i < 10; i++) {
            Room room = new Room(i + 1,
                    "Clean",
                    400);

            hall4.addRoom(room);
        }

        // Add created halls to Hall ArrayList
        addHall(hall1);
        addHall(hall2);
        addHall(hall3);
        addHall(hall4);

        // Construct a student to create a lease
        Student student = new Student(10,
                "Fredddddddddddd",
                "Blogs");

        // Create a lease
        Lease lease = new Lease(student);
        lease.setLeaseDuration(6);
        lease.setLeaseNumber(303);

        Student student2 = new Student(10,
                "Fredd",
                "Zlogs");

        // Create a lease
        Lease lease2 = new Lease(student2);
        lease.setLeaseDuration(6);
        lease.setLeaseNumber(303);


        Student student3 = new Student(10,
                "Fredd",
                "Sloman");

        // Create a lease
        Lease lease3 = new Lease(student3);
        lease.setLeaseDuration(6);
        lease.setLeaseNumber(303);


        ArrayList<Room> rooms = hall1.getRooms();
        Room roomToChange = rooms.get(0);
        roomToChange.setLease(lease);
    }

}
