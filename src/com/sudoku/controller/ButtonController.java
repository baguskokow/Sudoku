/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class ButtonController implements ActionListener{
	private ArrayList<JButton> buttons;
	private JTextField[][] fields;
	private String text;
	private int activeRow;
	private int activeCol;
	private boolean isEditable;
	
	public ButtonController(ArrayList<JButton> buttons, JTextField[][] field) {
		this.buttons = buttons;
		this.fields = field;

		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
		}
	}

	public void setActiveCell(int row, int col) {
		this.activeRow = row;
		this.activeCol = col;
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		if(activeRow == -1 || activeCol == -1) {
			return;
		}

		JButton clickedButton = (JButton) action.getSource();
		String textTombol = clickedButton.getText();


		if(fields[activeRow][activeCol].isEditable() == true) {
			if(textTombol.equals("X")) {
				fields[activeRow][activeCol].setText("");
			} else {
				fields[activeRow][activeCol].setText(textTombol);
			}
		}
	}
}
