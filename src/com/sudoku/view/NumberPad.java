/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class NumberPad {
	private static JPanel numberPanel = new JPanel(new GridLayout(2, 5, 5, 5));
	private static JButton[] buttons = new JButton[10];
	private static ImageIcon clearIcon; 
	private static String backgroundColor = "#f2ebeb";
	private static String foregroundColor = "#464c7d";
	private static Font buttonFont = SudokuFont.getFont("Inter", 1, 12);

	public static JPanel getPanel() {
		ImageHelper helperIcon = new ImageHelper("src/com/sudoku/images/clearIcon.png", 20, 20);
		clearIcon = helperIcon.getImageIcon();

		String[] titleButton = {
			"1", "2", "3", "4",
			"5", "6", "7", "8", "9"
		};
		
		for(int i = 0; i < buttons.length - 1; i++) {
			buttons[i] = new Button(titleButton[i], backgroundColor, foregroundColor, buttonFont).getButton();	
		}

		buttons[buttons.length - 1] = new JButton(clearIcon);

		for(int i = 0; i < buttons.length; i++) {
			numberPanel.add(buttons[i]);
		}

		return numberPanel;
	}
}
