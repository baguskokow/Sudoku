/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class Save {
	private static JButton saveButton;
	private static String backgroundColor = "#FFFFFF";
	private static ImageIcon saveIcon;

	public static JButton getSaveButton() {
		initialized();

		return saveButton;
	}

	private static void initialized() {
		setImage();

		saveButton = new Button(saveIcon, backgroundColor).getButton();
	}
	
	private static void setImage() {
		saveIcon = new ImageHelper("src/com/sudoku/images/save.png", 200, 200).getImageIcon();
	}
}
