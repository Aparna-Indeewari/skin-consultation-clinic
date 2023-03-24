import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIStart implements ActionListener {       //Implements ActionListener Interface to receive action events

    JFrame frame = new JFrame("Westminster Skin Consultation Center");      //Create a frame and set title
    JLabel heading = new JLabel("Westminster \r\nSkin Consultation Center" );       //Heading for the frame
    JButton button = new JButton();
    JButton consultButton = new JButton();

    GUIStart(){

        //Customizing buttons
        button.setBounds(600, 450, 150, 50);
        button.addActionListener(this);
        button.setText("View Doctors");
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.white);
        button.setBackground(Color.decode("#28112B"));

        consultButton.setBounds(775, 450, 150, 50);
        consultButton.addActionListener(this);
        consultButton.setText("View Consultations");
        consultButton.setFocusable(false);
        consultButton.setFont(new Font("Arial", Font.BOLD, 11));
        consultButton.setForeground(Color.white);
        consultButton.setBackground(Color.decode("#28112B"));

        //customizing heading
        heading.setHorizontalTextPosition(JLabel.CENTER);
        heading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));
        heading.setForeground(Color.white);
        heading.setBounds(325, 300, 1000, 100);

        //customizing frame
        frame.setSize(1550, 900);        //Set x-dimension and y-dimension
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of the application
        frame.setVisible(true);         //Make the frame visible
        frame.setLayout(null);
        frame.setResizable(false);      //Make frame cannot be resized by the user
        frame.getContentPane().setBackground(Color.decode("#453643"));
        frame.add(heading);
        frame.add(button);
        frame.add(consultButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {                  //If user clicks button
            new GUIViewDoc();                           //Opens GUIViewDoc
            frame.setVisible(false);                    //Making this frame not visible
        }

        if ( e.getSource() == consultButton) {          //If user enters consultButton
            new GUIViewConsultation();                  //Opens GUIViewConsultation
            frame.setVisible(false);                    //Making this frame not visible
        }
    }
}
