/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.util.Random;

class SudokuGenerator {
	private String[][] solution = new String[9][9];

	public static void fillSudokuCell(JTextField[][] fields, int startRow, int startCol) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= 9; i++) {
			numbers.add(i);
		}

		Collections.shuffle(numbers); // Acak angka

		int index = 0;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				fields[startRow + r][startCol + c].setText(String.valueOf(numbers.get(index)));
				index++;
			}
		}
	}

	public static boolean isValid(JTextField[][] fields, int row, int col, String number) {
		// Check Horizontal
		for(int i = 0; i < 9; i++) {
			if(i == col) {
				continue;
			}

			if(fields[row][i].getText().equals(number)) {
				return false;
			}
		}

		// Check vertical
		for(int i = 0; i < 9; i++) {
			if(i == row) {
				continue;
			}

			if(fields[i][col].getText().equals(number)) {
				return false;
			}
		}

		// Check per box
		int boxStartRow = (row / 3) * 3;
		int boxStartCol = (col / 3) * 3;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				int currentRow = boxStartRow + r;
				int currentCol = boxStartCol + c;
				
				if(currentRow == row && currentCol == col) {
					continue;
				}

				if(fields[currentRow][currentCol].getText().equals(number)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean fillRemaining(JTextField[][] fields, int row, int col) {
		if(col >= 9) {
			row++;
			col = 0;
		}

		if(row >= 9) {
			return true;
		}

		if(fields[row][col].getText().isEmpty() == false) {
			return fillRemaining(fields, row, col + 1);
		}

		for(int i = 1; i <= 9; i++) {
			String stringNumber = String.valueOf(i);

			if(isValid(fields, row, col, stringNumber) == true) {
				fields[row][col].setText(stringNumber);

				if(fillRemaining(fields, row, col + 1) == true) {
					return true;
				}

				fields[row][col].setText("");
			}
		}
		return false;
	}

	public static void removeCell(JTextField[][] fields, int totalCellToRemove) {
		Random rand = new Random();


		int removedCount = 0;

		while(removedCount < totalCellToRemove) {
			int randRow = rand.nextInt(9);
			int randCol = rand.nextInt(9);

			if(fields[randRow][randCol].getText().equals("") == false) {
				fields[randRow][randCol].setText("");
				fields[randRow][randCol].setEditable(true);
				removedCount++;
			}
		}
	}
}
