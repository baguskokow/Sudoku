/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class Button {
	private JButton button;
	private String titleButton;
	private String backgroundColor;
	private String foregroundColor;
	private Font font;

	public Button(String titleButton, String backgroundColor, String foregroundColor, Font font) {
		this.titleButton = titleButton;
		this.backgroundColor = backgroundColor;
		this.foregroundColor = foregroundColor;
		this.font = font;

		this.button = new JButton(titleButton);
    this.button.setBackground(Color.decode(backgroundColor));
    this.button.setForeground(Color.decode(foregroundColor));
    this.button.setFont(font);
		this.button.setFocusPainted(false);
	}

	public Button(ImageIcon buttonIcon, String backgroundColor) {
		this.button = new JButton(buttonIcon);
    this.button.setBackground(Color.decode(backgroundColor));
	}

	public JButton getButton() {
		return button;
	}
}
