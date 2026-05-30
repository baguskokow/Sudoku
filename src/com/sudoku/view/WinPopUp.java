/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class WinPopUp {
	private JFrame winFrame;
	private JPanel panel;
	private JDialog dialog;
	private JButton okButton;
	private ImageIcon popupIcon; 
	private ImageIcon okIcon;
	private String backgroundColor = "#FFFFFF";
	private JLabel winLabel;
	private JLabel timeLabel;
	private String time;
	private final Font labelFont = SudokuFont.getFont("Comic Sans MS", 1, 14);

	public WinPopUp(JFrame frame, String time) {
		this.winFrame = frame;
		this.time = time;

		initialized();
	}

	private void initialized() {
		setImage();

		dialog = new JDialog(winFrame, "Victory", true);
		//dialog.setLayout(new BorderLayout());
		dialog.setLayout(null);
		dialog.setSize(400, 500);
		dialog.setLocationRelativeTo(null);
		dialog.getContentPane().setLayout(null);

		winLabel = new JLabel(popupIcon);
		winLabel.setBounds(0, 50, 400, 400);

		timeLabel = new JLabel("05:00");
		timeLabel.setBounds(180, 245, 50, 50);
		timeLabel.setFont(labelFont);
		timeLabel.setForeground(Color.decode("#adaba5"));

		okButton = new Button(okIcon, backgroundColor).getButton();
		okButton.setBounds(145, 370, 120, 40);

		addEvent();
		dialog.add(timeLabel);
		dialog.add(winLabel);
		dialog.add(okButton);
		dialog.setVisible(true);
		
	}

	private void addEvent() {
		okButton.addActionListener(e -> {
			dialog.dispose();
		});
	}

	private void setImage() {
		popupIcon = new ImageHelper("src/com/sudoku/images/popup.png", 500, 500).getImageIcon();
		okIcon = new ImageHelper("src/com/sudoku/images/ok.png", 250, 130).getImageIcon();
		winLabel = new JLabel(popupIcon);
	}
}
