import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consultation extends Patient {     //Extends super class Patient
    private LocalDateTime dateTime;         //Instance Variables
    private double cost;
    private String notes;
    private String docML;


    //Constructor with name, surname, mobileNumber, dateofbith patientID, dateTime, cost, notes, and docML
    public Consultation(String name, String surname, String mobileNumber, LocalDate dateOfBirth, String patientID, LocalDateTime dateTime, double cost, String notes, String docML){
        super(name, surname, mobileNumber, dateOfBirth, patientID);
        this.dateTime = dateTime;
        this.cost = cost;
        this.notes = notes;
        this.docML = docML;
    }

    /**
     Returns cost
     parameters- None
     Return- cost
     */
    public double getCost() {
        return cost;
    }

    /**
     Sets cost
     parameters- cost
     Return- None
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     Returns notes
     parameters- None
     Return- notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     Sets notes
     parameters- notes
     Return- None
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     Returns date and time
     parameters- None
     Return- dateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     Sets Date and Time
     parameters- dateTime
     Return- None
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     Returns Doctor's Medical Licence Number
     parameters- None
     Return- docML
     */
    public String getDocML() {
        return docML;
    }

    /**
     Sets doctor's medical license number
     parameters- docML
     Return- None
     */
    public void setDocML(String docML) {
        this.docML = docML;
    }

}
