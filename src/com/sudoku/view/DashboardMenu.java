/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class DashboardMenu {
	private JFrame menuFrame;
	private ImageIcon wallpaper;
	private ImageIcon startIcon;
	private ImageIcon quitIcon;
	private ImageIcon loadIcon;
	private ImageIcon highScoresIcon;
	private JLabel background;
	private JButton startButton; 
	private JButton quitButton; 
	private JButton loadButton; 
	private JButton highScoresButton; 

	public DashboardMenu() {
		setImage();
		setStartButton();
		setHighScoresButton();
		setLoadButton();
		setQuitButton();
		addEvent();
		initialized();
	}
	
	private void addEvent() {
		startButton.addActionListener(e -> {
			menuFrame.dispose();

			App sudoku = new App();
		});

		quitButton.addActionListener(e -> {
			System.exit(0);
		});
	}

	private void setQuitButton() {
		quitButton = new Button(quitIcon, "#FFFFFF").getButton();
		quitButton.setBounds(520, 420, 150, 50);
	}

	private void setStartButton() {
		startButton = new Button(startIcon, "#FFFFFF").getButton();
		startButton.setBounds(520, 300, 150, 50);
	}
	
	private void setLoadButton() {
		loadButton = new Button(loadIcon, "#FFFFFF").getButton();
		loadButton.setBounds(520, 360, 150, 50);
	}

	private void setHighScoresButton() {
		highScoresButton = new Button(loadIcon, "#FFFFFF").getButton();
		highScoresButton.setBounds(520, 480, 150, 50);
	}
	
	private void setImage() {
		wallpaper = new ImageHelper("src/com/sudoku/images/background.png", 1200, 600).getImageIcon();
		startIcon = new ImageHelper("src/com/sudoku/images/play.png", 290, 130).getImageIcon();
		quitIcon = new ImageHelper("src/com/sudoku/images/quit.png", 270, 130).getImageIcon();
		loadIcon = new ImageHelper("src/com/sudoku/images/loadgame.png", 270, 130).getImageIcon();
		highScoresIcon = new ImageHelper("src/com/sudoku/images/highscores.png", 270, 130).getImageIcon();
		background = new JLabel(wallpaper);
	}

	private void initialized() {
		menuFrame = new JFrame("Sudoku");
		menuFrame.setSize(1200, 600);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setResizable(false);
		menuFrame.setLayout(null);
		menuFrame.setContentPane(background);
		menuFrame.add(startButton);
		menuFrame.add(loadButton);
		menuFrame.add(quitButton);
		show();
	}

	private void show() {
		menuFrame.setVisible(true);
	}
}
