import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {          //Implementing Serializable interface to make objects readable for streams

    public static ArrayList<Doctor> doctorList = new ArrayList<>();         //Creating Doctor ArrayList to store Doctor Information
    public static ArrayList<Consultation> consultationList = new ArrayList<>();         //Creating Consultation ArrayList to store Consultation Information


    /**
     Menu for the program. User gets to select which option to run
     Menu loops until user inputs Q or q to exit
     */
    public void menu() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n                                                Welcome to Westminster Skin Consultation Manager\n");
            System.out.println("           CONSOLE MENU");
            System.out.println("               A> Add a new doctor");
            System.out.println("               R> Remove a doctor");
            System.out.println("               P> Print the list of doctors");
            System.out.println("               S> Save in a file");
            System.out.println("               L> Load the file");
            System.out.println("               G> Launch the GUI");
            System.out.println("               Q> Quit");

            System.out.print("\n               Please enter your selection:  ");
            char userInput = input.next().toUpperCase().charAt(0);
            System.out.println("\n_______________________________________________________________________________________________________________________________________________________________");

            switch (userInput) {         //Calling methods according to user selection
                case ('A'):
                    this.addDoctor();
                    break;

                case ('R'):
                    this.removeDoctor();
                    break;

                case ('P'):
                    this.printDoctors();
                    break;

                case ('S'):
                    this.saveToFile();
                    break;

                case ('L'):
                    this.loadFile();
                    break;

                case ('G'):
                    new GUIStart();
                    break;

                case ('Q'): //When user chooses to exit the program
                    System.out.println("\n\n\n                                                             EXITING PROGRAM !!!");
                    System.out.println("                                                                   GOOD BYE");
                    System.exit(0);

                default:
                    System.out.println("Invalid Input!! Please select an option from below menu");   //If user enters an incorrect option
            }
        }

    }

    @Override
    /**
     Prompts information about doctors and add them in to doctorList array list. Validates input fields.
     parameters- None
     Return- None
     */
    public void addDoctor() {
        Scanner input = new Scanner(System.in);
        String name, surname, mobileNumber, medicalLicenceNumber, specialization;
        LocalDate dateOfBirth;

        if (this.doctorList.size()<10){             //Check if there's already 10 Doctors in the system before adding more doctors
            System.out.println("Enter doctor's details\n");


            while(true) {                               //Prompting First Name and Validating
                System.out.print("First Name: ");
                name = input.nextLine();
                if (name.equals("") || name.equals(" ")){           //If the input is empty
                    System.out.println("Name cannot be empty!! Try Again...\n");
                }
                else break;
            }

            while(true) {                               //Prompting Last Name and Validating
                System.out.print("Last Name: ");
                surname = input.nextLine();
                if (surname.equals("") || surname.equals(" ")){         //If the input is empty
                    System.out.println("Last name cannot be empty!! Try Again...\n");
                }
                else break;
            }

            System.out.println("\nDate of Birth:");             //Prompting Date of Birth and Validating
            while (true) {
                try{
                    System.out.print("Birth Year- ");
                    int year = input.nextInt();
                    input.nextLine();

                    System.out.print("Birth Month- ");
                    int month = input.nextInt();
                    input.nextLine();

                    System.out.print("Birth Date- ");
                    int date = input.nextInt();
                    input.nextLine();

                    dateOfBirth = LocalDate.of(year, month, date);          //Creating a LocalDate object
                    break;

                } catch (DateTimeException e){          //Exception Handling for invalid Date input
                    System.out.println("Invalid Date of Birth!! Try Again with a valid input\n");
                } catch (InputMismatchException e){         //Exception handling if entered inputs are not ints
                    System.out.println("Invalid Input for Date of Birth!! Try Again\n");
                    input.next();
                }
            }

            while(true) {
                System.out.print("\nMobile Number: ");                     //Prompting Mobile Number and Validating
                mobileNumber = input.nextLine();
                if (mobileNumber.equals("") || mobileNumber.equals(" ")){       //If the input is empty
                    System.out.println("Mobile Number cannot be empty!! Try Again...\n");
                }
                else break;
            }

            while(true) {                                                   //Prompting Medical Licence NUmber and Validating
                System.out.print("Medical Licence Number: ");
                medicalLicenceNumber = input.nextLine();
                if (medicalLicenceNumber.equals("") || medicalLicenceNumber.equals(" ")){       //If the input is empty
                    System.out.println("Medical Licence Number cannot be empty!! Try Again...\n");
                }
                else break;
            }

            while(true) {                                           //Prompting Specialization and Validating
                System.out.print("Specialization: ");
                specialization = input.nextLine();
                if (specialization.equals("") || specialization.equals(" ")){           //If the input is empty
                    System.out.println("Name cannot be empty!! Try Again...\n");
                }
                else break;
            }

            Doctor doctor = new Doctor( name,surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specialization );        //Creating a Doctor object with prompted data
            doctorList.add(doctor);                 //Add Doctor to the ArrayList
        }

        else{                           //If the system is already filled with 10 Doctors
            System.out.println("The center is full!! Cannot allocate more than 10 doctors.");
        }

    }

    /**
     Prompts Medical Licence Number from user and deletes the relative doctor. Printing out the information of the deleted doctor and total number of doctors in the center.
     parameters- None
     Return- None
     */
    @Override
    public void removeDoctor() {
        while (true) {
            Scanner input = new  Scanner(System.in);
            System.out.print("Enter the medical license number of the doctor to remove: ");
            String licenceNumber = input.nextLine();

            Doctor doctor = null;                   //Finding the doctor with the given Medical Licence number
            for( Doctor d : this.doctorList ) {
                if (d.getMedicalLicenceNumber().equals(licenceNumber)){
                    doctor = d;
                    break;
                }
            }

            if (doctor != null){           //If a doctor with the given Medical Licence Number exists in the system
                this.doctorList.remove(doctor);         //Remove the doctor
                System.out.println("\n____________________________________________________________________________________________________________________________________________________");
                System.out.println("\nInformation of the removed doctor: " + doctor.toString());            //Information of removed doctor
                System.out.println("Number of doctors in the center: " + this.doctorList.size());           //NUmber of doctors left in the system
                break;
            }
            else {                      //If a doctor with the given Medical Licence Number does not exist in the system
                System.out.println("\nNo doctor was found with this given licence number.");
            }
        }

    }

    /**
     Displays all the details of the doctors in the system
     parameters- None
     Return- None
     */
    @Override
    public void printDoctors() {
        System.out.println("\nAlphabetically Ordered Doctor List by Last Name\n");

        ArrayList tempDoc = doctorList;         //Creating a temporary array to sort
        Collections.sort(tempDoc,new Comparator<Doctor>() {
            public int compare(Doctor d1, Doctor d2) {          //Comparing 2 Doctor lists
                return d1.getSurname().compareToIgnoreCase(d2.getSurname());
            }
        });
        String leftAlignFormat = "| %-20s | %-18s | %-13s | %-22s | %-20s |%n";

        System.out.format("+----------------------+--------------------+---------------+------------------------+----------------------+%n");
        System.out.format("| Name                 | Date of Birth      | Mobile Number | Medical License Number | Specialization       |%n");
        System.out.format("+----------------------+--------------------+---------------+------------------------+----------------------+%n");

        for(Doctor d : doctorList) {                //Display doctor information in alphabetical order
            System.out.format(leftAlignFormat, d.getSurname() + ", " + d.getName(), d.getDateOfBirth().toString(), d.getMobileNumber(), d.getMedicalLicenceNumber(), d.getSpecialization() );
        }
        System.out.format("+----------------------+--------------------+---------------+------------------------+----------------------+%n");
    }

    /**
     Writing all the doctor details to a file
     parameters- None
     Return- None
     */
    @Override
    public void saveToFile() {
        try {
            FileOutputStream fOut = new FileOutputStream("DoctorDetail");    // Creates a FileOutputStream to write objects from ObjectOutputStream
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);       //Create ObjectOutputStream
            oOut.writeObject(doctorList);            //write Doctor objects to the output stream
            oOut.close();
            fOut.close();
            System.out.println("Congratulations!! Doctors' Information has successfully written into DoctorDetails file");

        } catch (IOException ioe) {             //IOException Handling
            System.out.println("Something went Wrong! ");
            ioe.printStackTrace();
        }
    }

    /**
     Loading all the stored doctor information back to the doctorList arrayList
     parameters- None
     Return- None
     */
    @Override
    public void loadFile() {
        try {
            FileInputStream fis = new FileInputStream("DoctorDetail");
            ObjectInputStream ois = new ObjectInputStream(fis);                 //Creates ObjectInputStream

            doctorList = (ArrayList) ois.readObject();                  //Reads the Objects and storing in the arrayList
            System.out.println("Data Has Been Loaded Successfully");

            ois.close();
            fis.close();

        } catch (IOException ioe) {             //IOException Handling
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {        //ClassNotFound Exception Handling
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    /**
     Writing all the consultation details to a file
     parameters- None
     Return- None
     */
    @Override
    public void saveConsultationDataToFile() {
        try {
            FileOutputStream fOut = new FileOutputStream("ConsultationDetail");    // Creates a FileOutputStream to write objects from ObjectOutputStream
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);       //Create ObjectOutputStream
            oOut.writeObject(consultationList);            //write Doctor objects to the output stream
            oOut.close();
            fOut.close();
            System.out.println("Congratulations!! Consultation Data has successfully written into ConsultationDetails file");

        } catch (IOException ioe) {                     //IOException Handling
            System.out.println("Something went Wrong! ");
            ioe.printStackTrace();
        }
    }

    /**
     Loading all the store consultation information back to the consultationList arrayList
     parameters- None
     Return- None
     */
    @Override
    public void loadConsultationDataFromFile() {
        try {
            FileInputStream fis = new FileInputStream("ConsultationDetail");            //Creates ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(fis);

            consultationList = (ArrayList) ois.readObject();            //Reads the Objects and storing in the arrayList
            System.out.println("Data Has Been Loaded Successfully");

            ois.close();
            fis.close();

        } catch (IOException ioe) {                 //IOException Handling
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {            //ClassNotFound Exception Handling
            System.out.println("Class not found");
            c.printStackTrace();
        }

    }


}
