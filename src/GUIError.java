import javax.swing.*;

public class GUIError extends JFrame {

    //Constructor to display an Error Frame when called
    public GUIError(String errorText) {
        JLabel error = new JLabel(errorText);
        this.setTitle("Error");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300,150);
        this.setVisible(true);
        this.add(error);
    }
}