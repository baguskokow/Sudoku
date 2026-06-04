/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


class SoundManager {
	private Clip backgroundMusic;

	public void playBackgroundMusic(String filePath) {
		try {
			File audioFile = new File(filePath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

			backgroundMusic = AudioSystem.getClip();
			backgroundMusic.open(audioStream);

			backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
			backgroundMusic.start();
		} catch(Exception e) {
			System.out.println("Failed to play audio" + e.getMessage());
		}
	}

	public void stopBackgroundMusic() {
		if(backgroundMusic != null && backgroundMusic.isRunning()) {
			backgroundMusic.stop();
			backgroundMusic.close();
		}
	}
}
