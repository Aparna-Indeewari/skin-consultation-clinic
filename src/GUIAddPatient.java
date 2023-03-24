import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;

public class GUIAddPatient implements ActionListener {          //Implements ActionListener Interface to receive action events
    WestminsterSkinConsultationManager wscm = new WestminsterSkinConsultationManager();
    JFrame frame = new JFrame("Westminster Skin Consultation Center");
    JPanel patientPanel = new JPanel();
    JButton costButton = new JButton();
    JLabel costLabel = new JLabel();
    JButton addPatientButton = new JButton();
    JLabel imageLabel = new JLabel();
    JButton imageButton = new JButton();
    JButton addConsult = new JButton();
    JButton backButton = new JButton();
    JLabel addPatientText = new JLabel("The Consultation Is Added Successfully ");


    JTextField fNameValue, lNameValue, mobNoValue, idValue, yearValue, noteValue;
    JComboBox dayValue,monthValue, hourValue;

    double totalCost;
    private int secretKey = 1234;

    String filePath, fileName;
    GUIAddPatient() {

        //Customizing JLabels
        imageLabel.setBounds(690,190,460,290);
        imageLabel.setBackground(Color.white);

        costLabel.setBounds(50,480, 550, 50);
        costLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));

        JLabel header = new JLabel("Westminster Skin Consultation Center");
        header.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 38));
        header.setForeground(Color.decode("#3C493F"));
        header.setBounds(400,30,800,50);


        JLabel fName = new JLabel("First Name: ");
        JLabel lName = new JLabel("Last Name: ");
        JLabel dob = new JLabel("Date of Birth: ");
        JLabel mobNo = new JLabel("Mobile No: ");
        JLabel id = new JLabel("Patient ID");
        JLabel numOfHours = new JLabel("Consultation: ");
        JLabel yearLabel = new JLabel("Year");
        JLabel monthLabel = new JLabel("Month");
        JLabel dayLabel = new JLabel("Day");
        JLabel notes = new JLabel("Notes");


        fName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        fName.setBounds(50,100,100,30);
        lName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lName.setBounds(370,100,100,30);
        dob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        dob.setBounds(50,170,150,30);
        mobNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        mobNo.setBounds(50,240,100,30);
        id.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        id.setBounds(370,240,150,30);
        numOfHours.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        numOfHours.setBounds(50,310,150,30);

        yearLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        yearLabel.setBounds(428,200,80,20);
        monthLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        monthLabel.setBounds(310,200,80,20);
        dayLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        dayLabel.setBounds(200,200,80,20);
        notes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        notes.setBounds(630,100,80,20);

        //Creating elements Arrays for JCombo Boxes
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] months = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] hours = {"1","2","3","4","5"};

        //Creating JComboBoxes and JTextFields to get information from patient
        fNameValue = new JTextField();
        lNameValue = new JTextField();
        dayValue = new JComboBox<>(days);
        monthValue = new JComboBox<>(months);
        yearValue = new JTextField();
        mobNoValue = new JTextField();
        idValue = new JTextField();
        hourValue = new JComboBox<>(hours);
        noteValue = new JTextField();

        //Customizing JComboBoxes and JTextFields
        fNameValue.setBounds(170,100,150,30);
        fNameValue.setBackground(Color.white);
        fNameValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        lNameValue.setBounds(470,100,150,30);
        lNameValue.setBackground(Color.white);
        lNameValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        dayValue.setBounds(170,170,80,30);
        dayValue.setBackground(Color.white);
        dayValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        monthValue.setBounds(285,170,80,30);
        monthValue.setBackground(Color.white);
        monthValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        yearValue.setBounds(400, 170, 80,30);
        yearValue.setBackground(Color.white);
        yearValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        mobNoValue.setBounds(170,240,150,30);
        mobNoValue.setBackground(Color.white);
        mobNoValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        idValue.setBounds(470,240,150,30);
        idValue.setBackground(Color.white);
        idValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        hourValue.setBounds(170, 310, 150,30);
        hourValue.setBackground(Color.white);
        hourValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        noteValue.setBounds(690, 100, 460,50);
        noteValue.setBackground(Color.white);
        noteValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));


        //Customizing Buttons
        addPatientButton.addActionListener(this);
        addPatientButton.setText("Add Consultation");
        addPatientButton.setFocusable(false);
        addPatientButton.setFont(new Font("Arial", Font.BOLD, 15));
        addPatientButton.setForeground(Color.white);
        addPatientButton.setBackground(Color.decode("#3C493F"));
        addPatientButton.setBounds(1050,510,150,50);

        costButton.addActionListener(this);
        costButton.setText("Cost");
        costButton.setFocusable(false);
        costButton.setFont(new Font("Arial", Font.BOLD, 15));
        costButton.setForeground(Color.white);
        costButton.setBackground(Color.decode("#3C493F"));
        costButton.setBounds(50,400,150,50);

        imageButton.addActionListener(this);
        imageButton.setText("Browse Image");
        imageButton.setFocusable(false);
        imageButton.setFont(new Font("Arial", Font.BOLD, 9));
        imageButton.setForeground(Color.white);
        imageButton.setBackground(Color.decode("#3C493F"));
        imageButton.setBounds(690,155,150,30);

        addConsult.addActionListener(this);
        addConsult.setText("Show Consultations");
        addConsult.setFocusable(false);
        addConsult.setFont(new Font("Arial", Font.BOLD, 13));
        addConsult.setForeground(Color.white);
        addConsult.setBackground(Color.decode("#453643"));
        addConsult.setBounds(1250,770,160,50);

        backButton.addActionListener(this);
        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.decode("#453643"));
        backButton.setBounds(150,770,160,50);


        addPatientText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        addPatientText.setBounds(400,500,500,30);
        addPatientText.setVisible(false);


        //Customizing patientPanel
        patientPanel.setBounds(150,150,1250, 600);
        patientPanel.setBackground(Color.decode("#7E8D85"));
        patientPanel.setLayout(null);
        patientPanel.add(fName);

        //Adding components to patientPanel
        patientPanel.add(fNameValue);
        patientPanel.add(lName);
        patientPanel.add(lNameValue);
        patientPanel.add(dob);
        patientPanel.add(dayValue);
        patientPanel.add(monthValue);
        patientPanel.add(yearValue);
        patientPanel.add(mobNo);
        patientPanel.add(mobNoValue);
        patientPanel.add(id);
        patientPanel.add(idValue);
        patientPanel.add(numOfHours);
        patientPanel.add(hourValue);
        patientPanel.add(dayLabel);
        patientPanel.add(monthLabel);
        patientPanel.add(yearLabel);
        patientPanel.add(costButton);
        patientPanel.add(costLabel);
        patientPanel.add(notes);
        patientPanel.add(noteValue);
        patientPanel.add(addPatientButton);
        patientPanel.add(imageLabel);
        patientPanel.add(imageButton);
        patientPanel.add(addPatientText);

        //Customizing frame
        frame.setSize(1550, 900);        //Set x-dimension and y-dimension
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of the application
        frame.setVisible(true);         //Make the frame visible
        frame.setLayout(null);
        frame.setResizable(false);      //Make frame cannot be resized by the user
        frame.getContentPane().setBackground(Color.decode("#F0F7F4"));
        frame.add(patientPanel);
        frame.add(header);
        frame.add(addConsult);
        frame.add(backButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == costButton ){          //When costButton is clicked
            calculatingCost();
        }
        if ( e.getSource() == addPatientButton ) {      //When addPatientButton is clicked
            setAddPatient();
            addPatientText.setVisible(true);
        }
        if ( e.getSource() == imageButton ) {           //When image button is clicked
            setImageButton();
        }

        if ( e.getSource() == addConsult ){
            new GUIViewConsultation();
            frame.setVisible(false);
        }
        if ( e.getSource() == backButton ){
            new GUIViewDoc();
            frame.setVisible(false);

    }
    }

    /**
     Calculates cost for the given number of consultation hours.
     parameters- None
     Return- None
     */
    public void calculatingCost () {
        String conHours = hourValue.getSelectedItem().toString();       //Getting user entered value for consultation hours
        String id = idValue.getText();                  //Getting user entered patientID

        if ( id.equals("")){                //If patientID is null
            new GUIError ("Please Enter Patient ID!");              //Sending an error frame
        } else {
            int consultHr = Integer.parseInt(conHours);

            if (consultHr == 1){
                totalCost = 15;
            }
            else {
                totalCost = 15 + 25 * ( consultHr - 1 );  //Calculating cost
            }

            costLabel.setText("Total cost: " + totalCost);          //Adding total cost to the label to display
        }
    }

    /**
     Adding entered patient details and consultation details to consultationList ArrayList.
     parameters- None
     Return- None
     */
    public void setAddPatient () {

        //setting user entered details to local variables
        String name = fNameValue.getText();
        String lName = lNameValue.getText();
        String dobDate = dayValue.getSelectedItem().toString();
        String dobMonth = monthValue.getSelectedItem().toString();
        String dobYear = yearValue.getText();
        String mobNo = mobNoValue.getText();
        String patientID = idValue.getText();
        String docML = GUIViewDoc.docML;
        String note = noteValue.getText();

        //if the fields are empty
        if (name.equals("") || lName.equals("") || dobDate.equals("") || dobMonth.equals("") || dobYear.equals("") || mobNo.equals("") || patientID.equals("")){
            new GUIError("Fields cannot be empty !!");              //Sends an Error message
        } else if (totalCost == 0.0){                               //If user did not click calculating cost button
            new GUIError("Calculate Cost First!");          //Sends an Error message
        }else{
            int iDay = Integer.parseInt(dobDate);
            int iMonth = Integer.parseInt(dobMonth);
            int iYear = Integer.parseInt(dobYear);

            LocalDate dob = LocalDate.of(iYear,iMonth,iDay);        //Creating LocalDate date of birth objects
            note = encryptText(note);

            //making a consultation object
            Consultation consultation = new Consultation(name, lName, mobNo, dob, patientID, GUIViewDoc.dateTime, totalCost, note, docML);
            WestminsterSkinConsultationManager.consultationList.add(consultation);          //Adding consultation objet to the Array

            wscm.saveConsultationDataToFile();              //Save consultation details to a file
        }
    }

    /**
     Setting image size to the size of the label it contains and returns image
     parameters- None
     Return- image
     */
    public ImageIcon resizeImage (String imagePath){

        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image img = imageIcon.getImage();
        Image newImage = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    /**
     User gets to browse an image from the device and upload it
     parameters- None
     Return- None
     */
    public void setImageButton () {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            filePath = selectedFile.getAbsolutePath();
            fileName = selectedFile.getName();
            imageLabel.setIcon(resizeImage(filePath));

        }
        else if (result == JFileChooser.CANCEL_OPTION){
            System.out.println("No File Select");
        }
    }


    /**
     Encrypting Notes added by user
     parameters- notes
     Return- encryptedText
     */
    public String encryptText (String notes){
        char[] characters = notes.toCharArray();
        String encryptedText = "";
        for(char c : characters) {
            c += secretKey;
            encryptedText += c;
        }
        return encryptedText;
    }
}
