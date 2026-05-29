/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class FunctionPad {
	private static JPanel functionPanel = new JPanel(new GridLayout(1, 3, 0, 1));
	private static JButton[] buttons = new JButton[3];
	private static ImageIcon undoIcon;
	private static ImageIcon redoIcon;
	private static ImageIcon hintIcon;
	private static String backgroundColor = "#f2ebeb";
	
	public static JPanel getPanel() {
		setImage();
		ImageIcon[] icons = {undoIcon, redoIcon, hintIcon};

		for(int i = 0; i < icons.length; i++) {
			buttons[i] = new Button(icons[i], backgroundColor).getButton();	
		}

		buttons[0].setActionCommand("UNDO");
		buttons[1].setActionCommand("REDO");
		buttons[2].setActionCommand("HINT");

		for(int i = 0; i < buttons.length; i++) {
			functionPanel.add(buttons[i]);
		}

		return functionPanel;
	}

	private static void setImage() {
		undoIcon = new ImageHelper("src/com/sudoku/images/undo.png", 20, 20).getImageIcon();
		redoIcon = new ImageHelper("src/com/sudoku/images/redo.png", 20, 20).getImageIcon();
		hintIcon = new ImageHelper("src/com/sudoku/images/hint.png", 20, 20).getImageIcon();
	}

	public static JButton getUndoButton() {
		return buttons[0];
	}

	public static JButton getRedoButton() {
		return buttons[1];
	}

	public static JButton getHintButton() {
		return buttons[2];
	}
}
