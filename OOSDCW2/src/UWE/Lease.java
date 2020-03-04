package UWE;

import java.util.Date;

public class Lease {

    private Student student;
    private int leaseNumber;
    private int leaseDuration;
    private Date startDate;
    private Date endDate;

    // Construct a student to create a lease
    public Lease(Student student) {
        this.student = student;
    }

    public void setLeaseNumber(int leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public int getLeaseNumber() {
        return this.leaseNumber;
    }

    // Calculate lease duration?
    public int getLeaseDuration() {
        return this.leaseDuration;
    }

    // Add create lease button and assign it to a student
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

}
