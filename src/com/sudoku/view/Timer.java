/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class Timer {
	private static JPanel timePanel = new JPanel(new BorderLayout());
	private static JLabel timeLabel;
	private static javax.swing.Timer timer;
	private static int seconds = 0;
	private static int detik;
	private static int menit;

	public static JPanel getPanel() {
		initialized();
		return timePanel;
	}

	public static void initialized() {
		timeLabel = new JLabel();
		timeLabel.setText("00:00");

		timer = new javax.swing.Timer(1000, e -> {
			seconds++;

			menit = seconds / 60;
			detik = seconds % 60;

			timeLabel.setText(String.format("%02d:%02d", menit, detik));
		});

		timePanel.add(timeLabel, BorderLayout.CENTER);
		timePanel.setBorder(BorderFactory.createEmptyBorder(20, 280, 20, 20));
		timePanel.setPreferredSize(new Dimension(100, 50));
	}

	public static void setStartTimer() {
		timer.start();
	}

	public static void setStopTimer() {
		timer.stop();
	}

	public static String getTime() {
		return timeLabel.getText();
	}
}
