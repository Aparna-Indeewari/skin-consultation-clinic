import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class GUIViewDoc implements ActionListener {      //Implements ActionListener Interface to receive action events

    JTable docTable = new JTable();
    JFrame frame = new JFrame("Westminster Skin Consultation Center");
    JButton sortButton = new JButton();
    JButton checkButton = new JButton();
    JButton patientButton = new JButton();
    JLabel docList = new JLabel("List of Doctors");
    JLabel header = new JLabel("Westminster Skin Consultation Center");
    JLabel sort = new JLabel("Click here to sort Doctor List in alphabetical order");
    JLabel header2 = new JLabel("Choose a Doctor and Check Their Availability");
    JLabel instruction = new JLabel("Select a doctor from table and add date and time for the ");
    JLabel instruction2 = new JLabel("consultation to check for the availability");
    JButton backButton =new JButton();

    JTextArea availableMsg = new JTextArea();

    JPanel docPanel = new JPanel();
    JPanel consultPanel = new JPanel();

    JComboBox  dayValue, monthValue, hourValue, minutesValue;
    JTextField yearValue;

    public static LocalDateTime dateTime;
    public static String docML;

    GUIViewDoc(){

        //Customizing JLabels
        sort.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        sort.setForeground(Color.decode("#F0F7F4"));
        sort.setBounds(50,530,550,50);

        docList.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
        docList.setForeground(Color.decode("#F8F8F8"));
        docList.setBounds(50,30,550,50);

        header.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 38));
        header.setForeground(Color.decode("#3C493F"));
        header.setBounds(400,30,800,50);

        header2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        header2.setForeground(Color.black);
        header2.setBounds(50,30,550,50);

        instruction.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        instruction.setForeground(Color.black);
        instruction.setBounds(50,80,550,20);
        instruction2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        instruction2.setForeground(Color.black);
        instruction2.setBounds(50,95,550,20);

        String[] column = new String[]{"Full Name", "DoB", "Mobile", "Medical No.", "Specialization"};      // Setting names for columns
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);                //Creating a DefaultTableModel
        tableModel.setColumnIdentifiers(column);

        //Custimizing docTable
        docTable.setModel(tableModel);
        docTable.setRowHeight(22);
        docTable.setBorder(null);
        docTable.setBounds(100,100,700,400);
        docTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        docTable.getColumnModel().getColumn(4).setPreferredWidth(150);

        JScrollPane docPane = new JScrollPane(docTable);                            //Creating a JScrollPane for the docTable
        docPane.setBounds(50, 100, 700,400);

        //Populating docTable with details in the doctorList ArrayList
        for (Doctor d : WestminsterSkinConsultationManager.doctorList) {
            tableModel.addRow(new Object[]{d.getName() + ", " + d.getSurname(), d.getDateOfBirth(), d.getMobileNumber(), d.getMedicalLicenceNumber(), d.getSpecialization(),});
        }

        //Creating JLabels for user input fields
        JLabel day = new JLabel("Day");
        JLabel month = new JLabel("Month");
        JLabel time = new JLabel("Time");
        JLabel year = new JLabel("Year");

        //Customizing JLabels
        day.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        day.setBounds(50,200,150,40);
        month.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        month.setBounds(50,250,150,40);
        year.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        year.setBounds(50,300,150,40);
        time.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        time.setBounds(50,350,150,40);

        availableMsg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        availableMsg.setBounds(50,500,450,40);
        availableMsg.setLineWrap(true);


        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] months = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] hours = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        String[] minutes = {"0","15","30","45"};

        dayValue = new JComboBox<>(days);
        monthValue = new JComboBox<>(months);
        hourValue = new JComboBox<>(hours);
        minutesValue = new JComboBox<>(minutes);
        yearValue = new JTextField();

        dayValue.setBounds(200,200,150,40);
        dayValue.setBackground(Color.white);
        dayValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        monthValue.setBounds(200,250,150,40);
        monthValue.setBackground(Color.white);
        monthValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        yearValue.setBounds(200, 300, 150,40);
        yearValue.setBackground(Color.white);
        yearValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        hourValue.setBounds(200,350,75,40);
        hourValue.setBackground(Color.white);
        hourValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));

        minutesValue.setBounds(280,350,75,40);
        minutesValue.setBackground(Color.white);
        minutesValue.setBorder(BorderFactory.createLineBorder(Color.decode("#3C493F")));


        sortButton.addActionListener(this);
        sortButton.setText("Sort");
        sortButton.setFocusable(false);
        sortButton.setFont(new Font("Arial", Font.BOLD, 15));
        sortButton.setForeground(Color.white);
        sortButton.setBackground(Color.decode("#3C493F"));
        sortButton.setBounds(600,530,150,50);

        checkButton.addActionListener(this);
        checkButton.setText("Check Availability");
        checkButton.setFocusable(false);
        checkButton.setFont(new Font("Arial", Font.BOLD, 13));
        checkButton.setForeground(Color.white);
        checkButton.setBackground(Color.decode("#3C493F"));
        checkButton.setBounds(350,430,150,50);

        patientButton.addActionListener(this);
        patientButton.setText("View Form");
        patientButton.setFocusable(false);
        patientButton.setFont(new Font("Arial", Font.BOLD, 13));
        patientButton.setForeground(Color.white);
        patientButton.setBackground(Color.decode("#453643"));
        patientButton.setBounds(1300,770,150,50);

        backButton.addActionListener(this);
        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.decode("#453643"));
        backButton.setBounds(100,770,150,50);


        docPanel.setBackground(Color.decode("#7E8D85"));
        docPanel.setBounds(100,150,800,600);
        docPanel.setLayout(null);
        docPanel.add(docList);
        docPanel.add(docPane);
        docPanel.add(sortButton);
        docPanel.add(sort);

        consultPanel.setBackground(Color.decode("#B3BfB8"));
        consultPanel.setBounds(900,150,550,600);
        consultPanel.setLayout(null);
        consultPanel.add(header2);
        consultPanel.add(instruction);
        consultPanel.add(instruction2);
        consultPanel.add(dayValue);
        consultPanel.add(monthValue);
        consultPanel.add(yearValue);
        consultPanel.add(hourValue);
        consultPanel.add(minutesValue);
        consultPanel.add(day);
        consultPanel.add(month);
        consultPanel.add(year);
        consultPanel.add(time);
        consultPanel.add(checkButton);
        consultPanel.add(availableMsg);

        frame.setSize(1550, 900);        //Set x-dimension and y-dimension
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of the application
        frame.setVisible(true);         //Make the frame visible
        frame.setLayout(null);
        frame.setResizable(false);      //Make frame cannot be resized by the user
        frame.getContentPane().setBackground(Color.decode("#F0F7F4"));
        frame.add(header);
        frame.add(docPanel);
        frame.add(consultPanel);
        frame.add(patientButton);
        frame.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == sortButton ){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(docTable.getModel());
            docTable.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<>(10);
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        else if ( e.getSource() == checkButton){
            checkAvailability();
        }

        else if ( e.getSource() == patientButton ) {
            new GUIAddPatient();
            frame.setVisible(false);
        }
        else if ( e.getSource() == backButton ) {
            new GUIStart();
            frame.setVisible(false);
        }

    }

    public void checkAvailability(){

        if ( yearValue.getText().equals("") ){
            new GUIError("Fields Cannot Be Empty !");
        }
        else {
            int checkDate, checkMonth, checkYear, checkHour, checkMinute, selectedRow;

            checkDate = Integer.parseInt(dayValue.getSelectedItem().toString());
            checkMonth = Integer.parseInt(monthValue.getSelectedItem().toString());
            checkYear = Integer.parseInt(yearValue.getText());
            checkHour = Integer.parseInt(hourValue.getSelectedItem().toString());
            checkMinute = Integer.parseInt(minutesValue.getSelectedItem().toString());

            dateTime = LocalDateTime.of(LocalDate.of(checkYear,checkMonth,checkDate), LocalTime.of(checkHour,checkMinute));

            selectedRow = docTable.getSelectedRow();
            if (selectedRow == -1) {
                new GUIError("Select a Doctor");
            }
            else{
                docML = docTable.getModel().getValueAt(selectedRow, 3).toString();


                int i;
                boolean foundDoctor = true;
                if (WestminsterSkinConsultationManager.consultationList.size() != 0) {
                    for ( i = 0; i < WestminsterSkinConsultationManager.consultationList.size(); i++) {
                        if (WestminsterSkinConsultationManager.consultationList.get(i).getDocML().equalsIgnoreCase(docML)) {
                            if (WestminsterSkinConsultationManager.consultationList.get(i).getDateTime().equals(dateTime)) {
                                foundDoctor = true;
                            } else {
                                foundDoctor = false;
                            }
                        }else{
                            foundDoctor = false;
                        }
                    }
                    if (!foundDoctor) {
                        availableMsg.setText("Congratulations! Your consultation appointment is successful.  Selected Doctor: " + docTable.getModel().getValueAt(selectedRow,0).toString() +
                                " Medical Licence No: " + docML);

                    } else {
                        //consultDoc.setText("bla bla" );
                        while (foundDoctor) {
                            int random = (int)(Math.random() * WestminsterSkinConsultationManager.doctorList.size());
                            //if(random != docIndex){
                            for ( i = 0; i < WestminsterSkinConsultationManager.consultationList.size(); i++) {
                                if(WestminsterSkinConsultationManager.doctorList.get(random).getMedicalLicenceNumber().equals(WestminsterSkinConsultationManager.consultationList.get(i).getDocML())){
                                    if(WestminsterSkinConsultationManager.consultationList.get(i).getDateTime().equals(dateTime)){
                                        foundDoctor = true;
                                    } else {
                                        foundDoctor = false;
                                    }
                                } else{
                                    foundDoctor = false;
                                }
                            }
                            //}
                            if (!foundDoctor) {
                                docML = WestminsterSkinConsultationManager.doctorList.get(i).getMedicalLicenceNumber();
                                String docName = WestminsterSkinConsultationManager.doctorList.get(random).getSurname() + " " + WestminsterSkinConsultationManager.doctorList.get(random).getName();
                                availableMsg.setText("Sorry!! The doctor you selected is not available. Doctor appointed: "  + docName + " Medical Licence No: " + docML);
                            }
                        }

                    }
                } else {
                    availableMsg.setText("Congratulations! Your consultation appointment is successful.  Selected Doctor: " + docTable.getModel().getValueAt(selectedRow,0).toString() +
                            " Medical Licence No: " + docML);
                }
            }
        }
    }
}
