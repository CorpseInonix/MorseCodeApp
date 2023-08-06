package MorseCode;

import javax.sound.sampled.*;
import java.io.*;

public class Audio implements LineListener {

	Clip clip;
	File file;
	String path;
	int i;
	char ch[];
	AudioInputStream in;

	Audio() {

		try {
			clip = AudioSystem.getClip();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		clip.addLineListener(this);

	}

	public void setUp(String path) {

		try {

			file = new File(path);
			in = AudioSystem.getAudioInputStream(file);
			if (!clip.isOpen())
				clip.open(in);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void setAudio(char[] temp) {

		ch = temp;
		path = "MorseCodeAudio\\" + ch[i] + ".wav";
		i++;
		setUp(path);
		clip.start();

	}

	public void update(LineEvent event) {

		if (event.getType() == LineEvent.Type.STOP) {

			if (ch[i] == ' ')
				try {

					Thread.sleep(2100);
					i++;

				} catch (Exception ex) {
				}

			clip.close();
			path = "MorseCodeAudio\\" + ch[i] + ".wav";
			setUp(path);
			clip.start();
			i++;

		}

	}

}
