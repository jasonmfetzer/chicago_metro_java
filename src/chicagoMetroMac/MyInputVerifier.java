package chicagoMetroMac;

import java.io.IOException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//input verifier was initially to verify inputs in swing, however methods proved to be harder than try catch blocks for 
//the assignment.  JComponent verification was not integrating well with action listeners and methods, tried to delete the
//class, but gave fatal error, so it remains.
public class MyInputVerifier extends InputVerifier {
	public boolean verify(JComponent input) {
		String text = ((JTextField) input).getText();
		if (text.equals(null))
			return false;
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean shouldYieldFocus(JComponent input) {
		return verify(input);

	}

}
