import java.io.Serializable;


import java.time.LocalDate;

public class Doctor extends Person implements Serializable {         //Implementing Serializable interface to make objects readable for streams
    private String medicalLicenceNumber;        //Instance variables for Doctor
    private String specialization;

    //Constructor with name, surname, mobile number, dateOfBirth, medical Licence Number Parameters
    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialization){
        super(name, surname, mobileNumber, dateOfBirth);                //Calling the constructor in super class(Person class)
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialization = specialization;
    }

    /**
     Returns Medical Licence Number
     parameters- None
     Return- Medical Licence Number
     */
    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    /**
     Sets medicalLicence Number
     parameters- medicalLicenseNumber
     return None
     */
    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    /**
     Returns Specialization
     parameters- None
     Return- Specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     Sets specialization
     parameters- specialization
     return None
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     Overriding toString method to create a string with Doctor details
     Parameters- None
     Return- String containing doctor information
     */
    public String toString(){
        return super.toString() + " " +
                "Medical Licence Number: " + medicalLicenceNumber + " " +
                "Specialization: " + specialization;
    }

}
