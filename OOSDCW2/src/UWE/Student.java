package UWE;

public class Student {

    private int studentID;
    private String forename;
    private String surname;

    public Student(int studentID,
                   String forename,
                   String surname) {
        this.studentID = studentID;
        this.forename = forename;
        this.surname = surname;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname(){
        return surname;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
