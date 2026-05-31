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
	private JPanel numberPanel = new JPanel(new GridLayout(2, 5, 5, 5));
	private JButton[] buttons = new JButton[10];
	private ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
	private ImageIcon clearIcon; 
	private String backgroundColor = "#f2ebeb";
	private String foregroundColor = "#464c7d";
	private Font buttonFont = SudokuFont.getFont("Inter", 1, 12);

	public JPanel getPanel() {
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
		buttons[buttons.length - 1].setActionCommand("X");

		for(int i = 0; i < buttons.length; i++) {
			numberPanel.add(buttons[i]);
		}


		return numberPanel;
	}

	public ArrayList<JButton> getAllButton() {
		for(int i = 0; i < buttons.length; i++) {
			listOfButtons.add(buttons[i]);
		}
	
		return listOfButtons;
	}
}
