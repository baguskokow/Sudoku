/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;

class Notification {
	public static void show(String message) {
		JFrame frame = App.getFrame();
		JWindow notif = new JWindow();
		JLabel label = new JLabel(message, SwingConstants.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		label.setForeground(Color.WHITE);

		int x = frame.getX() + 20;
		int y = frame.getY() + 20;

		JPanel panel = new JPanel();

		panel.setBackground(Color.decode("#333333"));
		panel.add(label);

		notif.add(panel);
		notif.pack();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//notif.setLocation(screen.width - notif.getWidth() - 20, screen.height - notif.getHeight() - 50);
		notif.setLocation(x, y);

		notif.setVisible(true);

		javax.swing.Timer timer = new javax.swing.Timer(2000, e -> {
			notif.dispose();
		});

		timer.setRepeats(false);
		timer.start();
	}
}
