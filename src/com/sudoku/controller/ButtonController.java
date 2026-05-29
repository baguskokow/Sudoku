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
import java.util.Stack;

class ButtonController implements ActionListener{
	private ArrayList<JButton> buttons;
	private JTextField[][] fields;
	private String text;
	private int activeRow;
	private int activeCol;
	private boolean isEditable;
	private Stack<SudokuStep> undoStack = new Stack<>();
	private Stack<SudokuStep> redoStack = new Stack<>();
	
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

		JButton clickedButton = (JButton) action.getSource();
		String contentText = clickedButton.getText();
		String textTombol = clickedButton.getActionCommand();

		if(textTombol.equals("UNDO")) {
			executeUndo();
			return;
		}

		if(textTombol.equals("REDO")) {
			executeRedo();
			return;
		}

		if(textTombol.equals("HINT")) {
			executeHint();
			return;
		}
		
		if(activeRow == -1 || activeCol == -1) {
			return;
		}

		if(fields[activeRow][activeCol].isEditable() == true) {
			String oldValue = fields[activeRow][activeCol].getText();
			String newValue;

			if(textTombol.equals("X") == false) {
				newValue = textTombol;
			} else {
				newValue = "";
			}

			if(oldValue.equals(newValue) == false) {
				undoStack.push(new SudokuStep(activeRow, activeCol, oldValue, newValue));
				fields[activeRow][activeCol].setText(newValue);
			}
		}
	}

	public void executeHint() {
		String[][] solution = App.getSolution();
		if(activeRow == -1 || activeCol == -1) {
			return;
		}

		fields[activeRow][activeCol].setText(solution[activeRow][activeCol]);
	}

	public void executeUndo() {
		if(undoStack.isEmpty()) {
			return;
		}

		SudokuStep lastStep = undoStack.pop();

		fields[lastStep.row][lastStep.col].setText(lastStep.oldValue);
		redoStack.push(lastStep);
	}

	public void executeRedo() {
		if(redoStack.isEmpty()) {
			return;
		}
		
		SudokuStep lastStep = redoStack.pop();
		fields[lastStep.row][lastStep.col].setText(lastStep.newValue);
		undoStack.push(lastStep);
	}
}
