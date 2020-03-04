package UWE;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;


public class ReadableData {
    private final SimpleStringProperty hallNumber;
    private final SimpleStringProperty roomNumber;
    private final SimpleStringProperty studentNumber;
    private final SimpleStringProperty forename;
    private final SimpleStringProperty surname;
    private final SimpleStringProperty leaseNumber;
    private final SimpleStringProperty cleaningStatus;
    private final SimpleStringProperty roomStatus;

    private Hall hall;
    private Room room;
    private Lease lease;

    public ReadableData(String hallNumber,
                        String roomNumber,
                        String studentNumber,
                        String forename,
                        String surname,
                        String leaseNumber,
                        String cleaningStatus,
                        String roomStatus,
                        Hall hall,
                        Room room,
                        Lease lease) {
        this.hallNumber = new SimpleStringProperty(hallNumber);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.studentNumber = new SimpleStringProperty(studentNumber);
        this.forename = new SimpleStringProperty(forename);
        this.surname = new SimpleStringProperty(surname);
        this.leaseNumber = new SimpleStringProperty(leaseNumber);
        this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
        this.roomStatus = new SimpleStringProperty(roomStatus);
        this.hall = hall;
        this.room = room;
        this.lease = lease;
    }

    public Hall getHall() {
        return hall;
    }

    public Room getRoom() {
        return room;
    }

    public Lease getLease() {
        return lease;
    }

    // Return student number
    public String getStudentNumber() {
        return studentNumber.get();
    }


    // Set student number
    public void setStudentNumber(String studentNumber) {
        this.studentNumber.set(studentNumber);
    }

    public String getForename() {
        return forename.get();
    }


    public void setForename(String forename) {
        this.forename.set(forename);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getHallNumber() {
        return hallNumber.get();
    }


    public String getRoomNumber() {
        return roomNumber.get();
    }


    public String getLeaseNumber() {
        return leaseNumber.get();
    }


    public void setLeaseNumber(String leaseNumber) {
        this.leaseNumber.set(leaseNumber);
    }

    public String getCleaningStatus() {
        return cleaningStatus.get();
    }


    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus.set(cleaningStatus);
    }

    public String getRoomStatus() {
        return roomStatus.get();
    }

    public SimpleStringProperty hallNumberProperty() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber.set(hallNumber);
    }

    public SimpleStringProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public SimpleStringProperty studentNumberProperty() {
        return studentNumber;
    }

    public SimpleStringProperty forenameProperty() {
        return forename;
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public SimpleStringProperty leaseNumberProperty() {
        return leaseNumber;
    }

    public SimpleStringProperty cleaningStatusProperty() {
        return cleaningStatus;
    }

    public SimpleStringProperty roomStatusProperty() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus.set(roomStatus);
    }
}
