/**
 * 
 */
package view;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class ButtonView extends JPanel {

	 
	/**
	 * Simple button view that contains a New Game button and a levelSelector combo box.
	 * Only the NewGame button listener is currently implemented.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton newGameButton;
	private JComboBox levelSelector;
	private JLabel levelLabel;
	
	public ButtonView(ActionListener gameButtonListener) {
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(gameButtonListener);
		add(newGameButton);
		

	}
}
