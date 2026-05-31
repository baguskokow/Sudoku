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
	private JLabel timeLabel = new JLabel("00;00");
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

	public String getTime() {
		return timeLabel.getText();
	}
}
