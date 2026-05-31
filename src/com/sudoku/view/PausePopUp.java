/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class PausePopUp {
	private JFrame pauseFrame;
	private JPanel panel;
	private JDialog dialog;
	private JButton resumeButton;
	private JButton quitButton;
	private ImageIcon popupIcon;
	private ImageIcon resumeIcon;
	private ImageIcon quitIcon;
	private String backgroundColor = "#FFFFFF";
	private JLabel pauseLabel;
	private JLabel timeLabel;
	private final Font labelFont = SudokuFont.getFont("Inter", 1, 18);
	private Timer timer;
	
	public PausePopUp(JFrame frame, Timer timer) {
		this.pauseFrame = frame;
		this.timer = timer;

		initialized();
	}

	private void initialized() {
		setImage();
		
		dialog = new JDialog(pauseFrame, "Pause", true);
		dialog.setLayout(null);
		dialog.setSize(400, 500);
		dialog.setLocationRelativeTo(null);
		dialog.getContentPane().setLayout(null);

		timeLabel = new JLabel(timer.getTime());
		timeLabel.setBounds(180, 40, 70, 50);
		timeLabel.setFont(labelFont);
		timeLabel.setForeground(Color.decode("#adaba5"));

		pauseLabel = new JLabel(popupIcon);
		pauseLabel.setBounds(0, 70, 400, 400);

		resumeButton = new Button(resumeIcon, backgroundColor).getButton();
		resumeButton.setBounds(145, 370, 120, 40);

		addEvent();
		dialog.add(timeLabel);
		dialog.add(pauseLabel);
		dialog.add(resumeButton);
		dialog.setVisible(true);
	}

	private void addEvent() {
		resumeButton.addActionListener(e -> {
			dialog.dispose();
			timer.setStartTimer();
		});
	}

	private void setImage() {
		popupIcon = new ImageHelper("src/com/sudoku/images/pausePopUp.png", 400, 400).getImageIcon();
		resumeIcon = new ImageHelper("src/com/sudoku/images/resume.png", 50, 50).getImageIcon();
		pauseLabel = new JLabel(popupIcon);
	}
}
