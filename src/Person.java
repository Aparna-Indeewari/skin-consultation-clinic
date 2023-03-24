import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {       //Implementing Serializable interface to make objects readable for streams
    private String name;            //Person Instance variables
    private String surname;
    private LocalDate dateOfBirth;
    private String mobileNumber;

    //Constructor with name, surname, mobile number, dateOfBirth
    public Person (String name, String surname, String mobileNumber, LocalDate dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     Returns first name
     parameters- None
     Return- first name
     */
    public String getName() {
        return name;
    }

    /**
     Sets first name
     parameters- name
     Return- None
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     Returns last name
     parameters- None
     Return- Last name
     */
    public String getSurname() {
        return surname;
    }

    /**
     Sets last name
     parameters- None
     Return- first name
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     Returns mobile number
     parameters- None
     Return- mobile number
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     Sets mobile number
     parameters- mobileNumber
     Return- Name
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     Returns last name
     parameters- None
     Return- Last name
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     Sets date of birth
     parameters- dateOfbirth
     Return- None
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     Overriding toString method to create a string with person details
     Parameters- None
     Return- String
     */
    public String toString(){
        return "Name: " + name + " " + surname + " " +
                "Date of Birth: " + dateOfBirth + " " +
                "Mobile Number: " + mobileNumber;
    }


}
