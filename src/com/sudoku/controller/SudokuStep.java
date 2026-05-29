/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

class SudokuStep {
	int row;
	int col;
	String oldValue;
	String newValue;

	public SudokuStep(int row, int col, String oldValue, String newValue) {
		this.row = row;
		this.col = col;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
}
