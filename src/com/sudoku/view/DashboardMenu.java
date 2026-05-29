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
	private JLabel background;
	private JButton startButton; 
	private JButton quitButton; 

	public DashboardMenu() {
		setImage();
		setStartButton();
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
		quitButton.setBounds(460, 360, 150, 50);
	}

	private void setStartButton() {
		startButton = new Button(startIcon, "#FFFFFF").getButton();
		startButton.setBounds(460, 300, 150, 50);
		//startButton.setBounds(410, 330, 330, 85);
	}
	
	private void setImage() {
		wallpaper = new ImageHelper("src/com/sudoku/images/background.png", 1200, 600).getImageIcon();
		startIcon = new ImageHelper("src/com/sudoku/images/play.png", 290, 130).getImageIcon();
		quitIcon = new ImageHelper("src/com/sudoku/images/quit.png", 270, 130).getImageIcon();
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
		menuFrame.add(quitButton);
		show();
	}

	private void show() {
		menuFrame.setVisible(true);
	}
}
