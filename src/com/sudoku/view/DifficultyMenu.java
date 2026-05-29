/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class DifficultyMenu {
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

