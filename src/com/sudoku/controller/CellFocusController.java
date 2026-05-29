/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CellFocusController implements FocusListener {
	private int row;
	private int col;
	private ButtonController buttonController;
	private final String COLOR_MINT = "#A2D1B3";
	private final String COLOR_WHITE = "#FFFFFF";

	public CellFocusController(int row, int col, ButtonController controller) {
		this.row = row;
		this.col = col;
		this.buttonController = controller;
	}	

	@Override 
	public void focusGained(FocusEvent event) {
		buttonController.setActiveCell(row, col);

		JTextField source = (JTextField) event.getSource();
		source.setBackground(Color.decode("#8f798f"));
		source.setForeground(Color.decode(COLOR_WHITE));
	}

	@Override
	public void focusLost(FocusEvent event) {
		JTextField source = (JTextField) event.getSource();
		if(row % 2 == 0) {
			source.setBackground(Color.decode(COLOR_MINT));
		} else {
			source.setBackground(Color.decode(COLOR_WHITE));
		}
	}

}
