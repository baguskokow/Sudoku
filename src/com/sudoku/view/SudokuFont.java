/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class SudokuFont {
	private static Font fontType;

	public static Font getFont(String fontName, int fontStyle, int fontSize) {
		fontType = new Font(fontName, fontStyle, fontSize);
		return fontType;
	}
}
