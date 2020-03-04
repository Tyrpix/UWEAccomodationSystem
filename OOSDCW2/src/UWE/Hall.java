package UWE;

import java.util.ArrayList;

public class Hall {

    // Don't think number is needed, can be identified by names
    private int hallNumber;
    private String hallName;
    private String address;
    private String teleNumber;
    private ArrayList<Room> rooms;


    public Hall(int hallNumber, String hallName, String address, String teleNumber) {
        this.hallNumber = hallNumber;
        this.hallName = hallName;
        this.address = address;
        this.teleNumber = teleNumber;

        this.rooms = new ArrayList<Room>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // Hard code each halls name and return
    public String getName() {
        return hallName;
    }

    // Hard code each halls address and return
    public String getAddress() {
        return address;
    }

    // Hard code each halls number and return
    public String getTeleNumber() {
        return teleNumber;
    }

    public int getHallNumber() {
        return hallNumber;
    }

}

