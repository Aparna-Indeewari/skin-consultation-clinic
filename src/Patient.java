import java.time.LocalDate;

public class Patient extends Person{        //Extends super class person
    private String patientID;

    //Constructor with name, surname, mobile number, dateOfBirth, patientID
    public Patient(String name, String surname, String mobileNumber, LocalDate dateOfBirth, String patientID) {
        super(name, surname, mobileNumber, dateOfBirth);
        this.patientID = patientID;
    }

    /**
     Returns Patient ID
     parameters- None
     Return- patient ID
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     Sets patient ID
     parameters- patientID
     Return- None
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
}
