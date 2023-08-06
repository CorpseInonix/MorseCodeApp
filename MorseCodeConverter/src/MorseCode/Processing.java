package MorseCode;

import java.util.*;
import javax.swing.*;

public class Processing {

	ArrayList<Character> ch;
	HashMap<Character, String> map;
	String output = "";
	Audio audio;

	Processing() {

		audio = new Audio();

		ch = new ArrayList<Character>();
		map = new HashMap<Character, String>();

		for (int i = 0; i < 26; i++)
			ch.add((char) (i + 97));

		for (int i = 0; i < 10; i++) {
			String s = Integer.toString(i);
			ch.add(s.charAt(0));
		}

		ch.add(' ');

		setUp();

	}

	public String convert(String s) {

		if (check(s)) {

			int length1 = s.length();
			String x;

			for (int i = 0; i < length1; i++) {

				x = map.get(s.charAt(i));
				output = output + x + "  ";

			}

		} else {

			output = "The entered input had a special character or a character that could not be converted";

		}

		return output;

	}

	public void playAudio(String s) {

		boolean b = check(s);

		if (b) {

			audio.setAudio(s.toCharArray());

		} else {

			new Panel().getOutput().setText("Worng input, please use numbers and alphabets only.");

		}

	}

	boolean check(String s) {

		int length1 = s.length(), length2 = ch.size();
		boolean b = false;
		int flag = 0;

		char[] check = new char[length1];
		check = s.toCharArray();

		for (int i = 0; i < length1; i++) {

			for (int j = 0; j < length2; j++)
				if (ch.get(j) == check[i])
					b = true;

			if (b) {
				flag = 0;
				b = false;
			} else {
				flag = 1;
				break;
			}

		}

		if (flag == 0)
			return true;
		else
			return false;

	}

	public void setUp() {

		map.put('a', "●▬");
		map.put('b', "▬●●●");
		map.put('c', "▬●▬●");
		map.put('d', "▬●●");
		map.put('e', "●");
		map.put('f', "●●▬●");
		map.put('g', "▬▬●");
		map.put('h', "●●●●");
		map.put('i', "●●");
		map.put('j', "●▬▬▬");
		map.put('k', "▬●▬");
		map.put('l', "●▬●●");
		map.put('m', "▬▬");
		map.put('n', "▬●");
		map.put('o', "▬▬▬");
		map.put('p', "●▬▬●");
		map.put('q', "▬▬●▬");
		map.put('r', "●▬●");
		map.put('s', "●●●");
		map.put('t', "▬");
		map.put('u', "●●▬");
		map.put('v', "●●●▬");
		map.put('w', "●▬▬");
		map.put('x', "▬●●▬");
		map.put('y', "▬●▬▬");
		map.put('z', "▬▬●●");
		map.put('0', "▬▬▬▬▬");
		map.put('1', "●▬▬▬▬");
		map.put('2', "●●▬▬▬");
		map.put('3', "●●●▬▬");
		map.put('4', "●●●●▬");
		map.put('5', "●●●●●");
		map.put('6', "▬●●●●");
		map.put('7', "▬▬●●●");
		map.put('8', "▬▬▬●●");
		map.put('9', "▬▬▬▬●");
		map.put(' ', "       ");

	}

}
