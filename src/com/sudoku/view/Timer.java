/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class Timer {
	private JPanel timePanel = new JPanel(new BorderLayout());
	private JLabel timeLabel;
	private final Font timerFont = SudokuFont.getFont("Inter", 1, 14);
	private javax.swing.Timer timer;
	private int seconds = 0;
	private int detik;
	private int menit;

	public Timer() {
		initialized();
	}
	
	public JPanel getPanel() {
		return timePanel;
	}

	public void initialized() {
		timeLabel = new JLabel();	
		timeLabel.setFont(timerFont);
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

	public void setStartTimer() {
		timer.start();
	}

	public void setStopTimer() {
		timer.stop();
	}

	public void setTime(String savedTime) {
		String[] parts = savedTime.split(":");
		menit = Integer.parseInt(parts[0]);
		detik = Integer.parseInt(parts[1]);
		seconds = (menit * 60) + detik;
		timeLabel.setText(savedTime);
	}

	public String getTime() {
		return timeLabel.getText();
	}
}
