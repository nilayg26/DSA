package JavaPractise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class second implements ItemListener {
    static JLabel text;
    public void itemStateChanged(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            text.setText("Selected");
        }
        else{
            text.setText("Unselected");
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nilay");
        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        JToggleButton button = new JToggleButton("Gupta");
        button.setBounds(150, 100, 100, 50);
        second obj = new second();
        button.addItemListener(obj);
        frame.add(button);
        text= new JLabel();
        text.setText("null");
        text.setBounds(150, 50, 200, 50);
        frame.add(text);
        frame.setVisible(true);
    }
}
