package Pingpong;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dialog {
	public static String Dialog() {
        JTextField ign = new JTextField();
        Object[] message = {
            "Namn:", ign
        };
        int option = JOptionPane.showOptionDialog(null, message, "Skriv ditt ign", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        if (option == JOptionPane.OK_OPTION) {
            String name = ign.getText();
            
            if (name.length() > 3) {
                name = name.substring(0, 3);
            }
            return name;
        } else {
        	System.exit(0);
            return null;
        }
    }
}
