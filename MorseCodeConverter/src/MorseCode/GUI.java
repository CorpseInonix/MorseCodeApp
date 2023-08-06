package MorseCode;

import javax.swing.*;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	GUI() {

		setSize(800, 340);
		setTitle("Morse Code Converter");
		setResizable(false);
		setDefaultCloseOperation(3);
		add(new Panel().panel());
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
