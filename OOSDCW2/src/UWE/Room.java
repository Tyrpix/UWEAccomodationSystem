package UWE;

public class Room {

    private int roomNumber;
    private String cleaningStatus;
    private float monthlyRate;
    private String roomStatus;
    private Lease lease;

    public Room(int roomNumber, String cleaningStatus, float monthlyRate) {
        this.roomNumber = roomNumber;
        this.cleaningStatus = cleaningStatus;
        this.monthlyRate = monthlyRate;
        this.lease = null;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setCleaningStatus(String cleaningStatus) {
        // Clean, Dirty, Offline
        this.cleaningStatus = cleaningStatus;
    }

    public String getCleaningStatus(){
        return cleaningStatus;
    }

    public boolean isOccupied() {
        // Return whether occupied based on lease
        // Return boolean based on whether occupied or not
        return !(getLease() == null);
    }

    public void setMonthlyRate(float monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public float getMonthlyRate() {
        return monthlyRate;
    }

    public String getRoomStatus() {
        // Calculated based on whether there is lease
        // Occupied or Unoccupied
        if (isOccupied()) {
            return "Occupied";
        } else {
            return "Unoccupied";
        }
    }

    public void setLease(Lease lease) {
        this.lease = lease;

    }

    public Lease getLease() {
        return lease;
    }

}
