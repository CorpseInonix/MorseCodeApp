package MorseCode;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Panel {

	JPanel mainPanel;
	JTextField input, output;
	JButton convert, play;

	JPanel panel() {

		mainPanel = new JPanel();
		Font myFont = new Font("Ariel", Font.PLAIN, 19);
		mainPanel.setLayout(null);
		Border b = BorderFactory.createLineBorder(Color.black, 1);
		input = new JTextField();
		output = new JTextField();
		JLabel l1 = new JLabel("Do not enter a special character, only enter english alphabets or numbers.");
		JLabel l2 = new JLabel("You can copy the output as well but it may not look the same in all text editors.");
		convert = new JButton("Convert");
		play = new JButton("Play audio");

		play.setBackground(Color.white);
		play.addActionListener(new ButtonListener());
		play.setFocusable(false);
		play.setBounds(37, 185, 100, 30);

		convert.setBackground(Color.white);
		convert.addActionListener(new ButtonListener());
		convert.setFocusable(false);
		convert.setBounds(37, 140, 80, 30);

		output.addMouseListener(new TextListener());
		output.setBackground(null);
		output.setBorder(b);
		output.setFont(myFont);
		output.setText("Morse code appears here");
		output.setBounds(37, 80, 712, 40);
		output.setFocusable(false);

		input.addMouseListener(new TextListener());
		input.setBackground(null);
		input.setBorder(b);
		input.setFont(myFont);
		input.setText("Enter text in english");
		input.setBounds(37, 20, 712, 40);
		input.setFocusable(false);

		l1.setBounds(37, 230, 700, 20);
		l1.setForeground(Color.red);
		l2.setBounds(37, 250, 700, 20);
		l2.setForeground(Color.red);

		mainPanel.add(input);
		mainPanel.add(output);
		mainPanel.add(convert);
		mainPanel.add(play);
		mainPanel.add(l1);
		mainPanel.add(l2);

		return mainPanel;

	}

	JTextField getOutput() {
		return output;
	}

	public class TextListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {

			if (e.getSource() == input)
				if (input.getText().equals("Enter text in english")) {
					input.setText(null);
					input.setFocusable(true);
				}

		}

		public void mouseExited(MouseEvent e) {

			if (e.getSource() == input)
				if (input.getText().equals(""))
					input.setText("Enter text in english");

		}

	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Processing temp = new Processing();

			if (e.getSource() == convert) {
				output.setText(temp.convert(input.getText().toLowerCase()));
				output.setFocusable(true);
			} else
				temp.playAudio(input.getText().toLowerCase());

		}

	}

}
