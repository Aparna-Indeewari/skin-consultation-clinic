import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUIViewConsultation implements ActionListener {        //Implements ActionListener Interface to receive action events

    JTable docTable = new JTable();
    JFrame frame = new JFrame("Westminster Skin Consultation Center");
    JButton sortButton = new JButton();
    JLabel docList = new JLabel("Consultation List");
    JLabel header = new JLabel("Westminster Skin Consultation Center");
    JButton backButton = new JButton();

    JPanel docPanel = new JPanel();


    GUIViewConsultation(){

        //customizing JLabels
        docList.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
        docList.setForeground(Color.decode("#F8F8F8"));
        docList.setBounds(50,30,550,50);

        header.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 38));
        header.setForeground(Color.decode("#3C493F"));
        header.setBounds(400,30,800,50);

        String[] column = new String[]{"Full Name", "Mobile No", "Date of Birth", "PatientId", "Consultation Date/Time", "Cost", "Notes", "Doctor's ML"};   //Setting names for columns
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);            //Creating a DefaultTableModel
        tableModel.setColumnIdentifiers(column);

        docTable.setModel(tableModel);                  //Creating a table
        docTable.setBounds(150,100,1250,400);

        JScrollPane docPane = new JScrollPane(docTable);            //Creating a JScrollPane for the table
        docPane.setBounds(50, 100, 1250,400);

        for (Consultation c : WestminsterSkinConsultationManager.consultationList) {            //Populating the table from consultationList ArrayList
            tableModel.addRow(new Object[]{c.getName() + " " + c.getSurname(), c.getMobileNumber(), c.getDateOfBirth(), c.getPatientID(), c.getDateTime(), c.getCost(), c.getNotes(), c.getDocML()});
        }


        //customizing panels
        docPanel.setBackground(Color.decode("#7E8D85"));
        docPanel.setBounds(100,125,1350,600);
        docPanel.setLayout(null);
        docPanel.add(docList);
        docPanel.add(docPane);
        docPanel.add(sortButton);

        backButton.addActionListener(this);
        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.decode("#453643"));
        backButton.setBounds(100,735,160,50);


        //customizing the frame
        frame.setSize(1550, 900);        //Set x-dimension and y-dimension
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of the application
        frame.setVisible(true);         //Make the frame visible
        frame.setLayout(null);
        frame.setResizable(false);      //Make frame cannot be resized by the user
        frame.getContentPane().setBackground(Color.decode("#F0F7F4"));
        frame.add(header);
        frame.add(docPanel);
        frame.add(backButton);
        //frame.add(sortButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if ( e.getSource() == backButton){
            new GUIStart();
            frame.setVisible(false);

    }
}
}