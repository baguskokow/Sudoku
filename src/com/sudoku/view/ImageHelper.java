/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ImageHelper {
	private ImageIcon icon;

	public ImageHelper(String path, int width, int height) {
		ImageIcon rawIcon = new ImageIcon(path);
		Image temp = rawIcon.getImage();
		Image resizedTemp = temp.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.icon = new ImageIcon(resizedTemp);
	}

	public ImageIcon getImageIcon() {
		return icon;
	}
}
