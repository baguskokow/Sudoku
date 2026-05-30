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
	private static String[][] userInput = new String[9][9];
	private static String[][] solution;
	
	public ButtonController(ArrayList<JButton> buttons, JTextField[][] field) {
		this.buttons = buttons;
		this.fields = field;

		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
		}
	}

	public static String[][] getUserInput() {
		return userInput;
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
				userInput[activeRow][activeCol] = newValue;
				checkWin();
			}
		}
	}

	// Sync init number with user input
	public void syncNumber() {
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				String initialText = fields[r][c].getText();
				userInput[r][c] = initialText;
			}
		}
		
	}

	public void checkWin() {
		solution = App.getSolution();
		syncNumber();

		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				String userValue = userInput[r][c];
				String solutionValue = solution[r][c];

				if(userValue == null || userValue.equals("") || !userValue.equals(solutionValue)) {
					return;
				}
			}
		}

		SwingUtilities.invokeLater(() -> {
			new WinPopUp(App.getFrame(), "05:00");
		});
	}

	public void executeHint() {
		String[][] solution = App.getSolution();
		if(activeRow == -1 || activeCol == -1) {
			return;
		}

		fields[activeRow][activeCol].setText(solution[activeRow][activeCol]);
		userInput[activeRow][activeCol] = solution[activeRow][activeCol];
		checkWin();
	}

	public void executeUndo() {
		if(undoStack.isEmpty()) {
			return;
		}

		SudokuStep lastStep = undoStack.pop();

		fields[lastStep.row][lastStep.col].setText(lastStep.oldValue);
		redoStack.push(lastStep);
		userInput[lastStep.row][lastStep.col] = lastStep.oldValue;
		checkWin();
	}

	public void executeRedo() {
		if(redoStack.isEmpty()) {
			return;
		}
		
		SudokuStep lastStep = redoStack.pop();
		fields[lastStep.row][lastStep.col].setText(lastStep.newValue);
		undoStack.push(lastStep);
		userInput[lastStep.row][lastStep.col] = lastStep.newValue;
		checkWin();
	}
}
