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
	private JPanel functionPanel = new JPanel(new GridLayout(2, 3, 0, 1));
	private JButton[] buttons = new JButton[6];
	private ImageIcon undoIcon;
	private ImageIcon redoIcon;
	private ImageIcon hintIcon;
	private ImageIcon saveIcon;
	private ImageIcon quitIcon;
	private ImageIcon pauseIcon;
	private String backgroundColor = "#f2ebeb";
	
	public JPanel getPanel() {
		setImage();
		
		ImageIcon[] icons = {undoIcon, redoIcon, hintIcon, saveIcon, quitIcon, pauseIcon};

		for(int i = 0; i < icons.length; i++) {
			buttons[i] = new Button(icons[i], backgroundColor).getButton();	
		}

		buttons[0].setActionCommand("UNDO");
		buttons[1].setActionCommand("REDO");
		buttons[2].setActionCommand("HINT");
		buttons[3].setActionCommand("SAVE");
		buttons[4].setActionCommand("QUIT");
		buttons[5].setActionCommand("PAUSE");

		for(int i = 0; i < buttons.length; i++) {
			functionPanel.add(buttons[i]);
		}

		return functionPanel;
	}

	private void setImage() {
		undoIcon = new ImageHelper("src/com/sudoku/images/undo.png", 20, 20).getImageIcon();
		redoIcon = new ImageHelper("src/com/sudoku/images/redo.png", 20, 20).getImageIcon();
		hintIcon = new ImageHelper("src/com/sudoku/images/hint.png", 20, 20).getImageIcon();
		saveIcon = new ImageHelper("src/com/sudoku/images/save.png", 20, 20).getImageIcon();
		quitIcon = new ImageHelper("src/com/sudoku/images/quitGame.png", 20, 20).getImageIcon();
		pauseIcon = new ImageHelper("src/com/sudoku/images/pause.png", 20, 20).getImageIcon();
	}

	public JButton getUndoButton() {
		return buttons[0];
	}

	public JButton getRedoButton() {
		return buttons[1];
	}

	public JButton getHintButton() {
		return buttons[2];
	}

	public JButton getSaveButton() {
		return buttons[3];
	}

	public JButton getQuitButton() {
		return buttons[4];
	}

	public JButton getPauseButton() {
		return buttons[5];
	}
}
