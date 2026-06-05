/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class HintLeft {
	private JPanel hintLeftPanel = new JPanel(new BorderLayout());
	private JLabel hintLeftLabel;
	private final Font hintFont = SudokuFont.getFont("Inter", 1, 14);
	private int totalHintClicked = 0;

	public HintLeft() {
		initialized();
		//this.totalHintClicked = buttonController.getTotalHint();
	}

	private void initialized() {
		hintLeftLabel = new JLabel();
		hintLeftLabel.setText("Hint Left : 0 / 5");

		hintLeftPanel.add(hintLeftLabel, BorderLayout.CENTER);
		hintLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
	}

	public void refreshHintLeft() {
		String format = "Hint Left : " + totalHintClicked + " / 5";
		hintLeftLabel.setText(format);
	}

	public void updateHintLeft() {
		if(totalHintClicked < 5) {
			totalHintClicked++;
		}
		String format = "Hint Left : " + totalHintClicked + " / 5";
		hintLeftLabel.setText(format);
	}

	public JPanel getPanel() {
		return hintLeftPanel;
	}

	public int getTotalHintClicked() {
		return totalHintClicked;
	}

	public void setTotalHintClicked(int totalHintClicked) {
		this.totalHintClicked = totalHintClicked;
	}
}
