/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class DifficultyMenu {
	private JFrame difficultyFrame;
	private JButton easyButton;
	private JButton mediumButton;
	private JButton hardButton;
	private JLabel background;
	private ImageIcon wallpaper;
	private ImageIcon easyIcon;
	private ImageIcon mediumIcon;
	private ImageIcon hardIcon;
	
	public DifficultyMenu() {
		setImage();
		setEasyButton();
		setMediumButton();
		setHardButton();
		addEvent();
		initialized();
	}

	private void initialized() {
		difficultyFrame = new JFrame("Sudoku");
		difficultyFrame.setSize(1200, 600);
		difficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		difficultyFrame.setLocationRelativeTo(null);
		difficultyFrame.setResizable(false);
		difficultyFrame.setLayout(null);
		difficultyFrame.setContentPane(background);
		difficultyFrame.add(easyButton);
		difficultyFrame.add(mediumButton);
		difficultyFrame.add(hardButton);
		show();
	}

	private void show() {
		difficultyFrame.setVisible(true);
	}	

	private void addEvent() {
		easyButton.addActionListener(e -> {
			difficultyFrame.dispose();
			App sudoku = new App("EASY");
		});
		
		mediumButton.addActionListener(e -> {
			difficultyFrame.dispose();
			App sudoku = new App("MEDIUM");
		});

		hardButton.addActionListener(e -> {
			difficultyFrame.dispose();
			App sudoku = new App("HARD");
		});
	
	}

	private void setEasyButton() {
		easyButton = new Button(easyIcon, "#FFFFFF").getButton();
		easyButton.setBounds(520, 300, 150, 50);
	}

	private void setMediumButton() {
		mediumButton = new Button(mediumIcon, "#FFFFFF").getButton();
		mediumButton.setBounds(520, 360, 150, 50);
	}
	
	private void setHardButton() {
		hardButton = new Button(hardIcon, "#FFFFFF").getButton();
		hardButton.setBounds(520, 420, 150, 50);
	}

	private void setImage() {
		wallpaper = new ImageHelper("src/com/sudoku/images/difficulty_background.png", 1200, 600).getImageIcon();
		easyIcon = new ImageHelper("src/com/sudoku/images/easy.png", 290, 170).getImageIcon();
		mediumIcon = new ImageHelper("src/com/sudoku/images/medium.png", 270, 130).getImageIcon();
		hardIcon = new ImageHelper("src/com/sudoku/images/hard.png", 270, 130).getImageIcon();
		background = new JLabel(wallpaper);
	}
}

