import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterSkinConsultationManagerTest {

    ArrayList<Doctor> doctorArrayList = new ArrayList<>();
    //ArrayList<Person> personArrayList = new ArrayList<>();

    WestminsterSkinConsultationManager manager;

    @BeforeEach
    void setUp() {
        manager = new WestminsterSkinConsultationManager();
    }

    @Test
    @DisplayName("Checking if the file exist or not")
    public void checkFileExist(){

        File file = new File("DoctorDetail");
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Checking if the file is readable or not")
    public void checkFileisReadable(){

        File file = new File("DoctorDetail");
        assertTrue(file.canRead());
    }

    @Test
    @DisplayName("Checking if the file is writeable or not")
    public void checkFileisWriteable(){

        File file = new File("DoctorDetail");
        assertTrue(file.canWrite());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Add a doctor")
    void addNewDoctor() {
        Person  person1 = new Person("Kamal","Perera","21225456325", LocalDate.of(1995, 01, 01));
        Doctor doctor1 = new Doctor(person1.getName(), person1.getSurname(), person1.getDateOfBirth(), person1.getMobileNumber(),"D001","Paediatric");
        doctorArrayList.add(doctor1);
        assertEquals(1, doctorArrayList.size());

        Person  person2 = new Person("Amal","Perera","5655412546",LocalDate.of(1998, 05, 15));
        Doctor doctor2 = new Doctor(person2.getName(), person2.getSurname(), person2.getDateOfBirth(), person2.getMobileNumber(),"D002","Paediatric");
        doctorArrayList.add(doctor2);
        assertEquals(2, doctorArrayList.size());
    }


}