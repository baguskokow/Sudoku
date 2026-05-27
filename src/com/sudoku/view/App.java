/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class App {
	private final int WIDTH_FRAME = 900;
	private final int HEIGHT_FRAME = 600;
	private final String COLOR_MINT = "#A2D1B3";
	private final String COLOR_WHITE = "#FFFFFF";
	private final Font textFieldFont = SudokuFont.getFont("Inter", 1, 18); 	

	private JFrame frame;

	// list of panels
	private JPanel A_Container;
	private JPanel B_Container;
	private JPanel C_Container;
	private JPanel D_Container;
	private JPanel E_Container;
	private JPanel F_Container;
	private JPanel G_Container;
	private JPanel H_Container;
	private JPanel I_Container;
	private ArrayList<JComponent> containers = new ArrayList<JComponent>();

	private JTextField[][] fields = new JTextField[9][9];

	public App() { // Constructor
		initialized();
	}

	private void initTextField() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				fields[row][col] = new JTextField("x");
				fields[row][col].setHorizontalAlignment(JTextField.CENTER);
				fields[row][col].setFont(textFieldFont);

				if(row % 2 == 0) {
					fields[row][col].setBackground(Color.decode(COLOR_MINT));
				} else {
					fields[row][col].setBackground(Color.decode(COLOR_WHITE));
				}
			}
		}
	}

	private void initContainer() {
		A_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		B_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		C_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		D_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		E_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		F_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		G_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		H_Container = new JPanel(new GridLayout(3, 3, 0, 0));
		I_Container = new JPanel(new GridLayout(3, 3, 0, 0));

		JComponent[] childContainer = {
			A_Container, B_Container, C_Container, D_Container, E_Container,
			F_Container, G_Container, H_Container, I_Container,
		};
	
		for(int i = 0; i < childContainer.length; i++) {
			childContainer[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			containers.add(childContainer[i]);
		}
	}

	private void initialized() {
		// Init containers
		initContainer();
		initTextField();

		for(int i = 0; i < fields.length; i++) {
			for(int j = 0; j < fields[i].length; j++) {
				containers.get(i).add(fields[i][j]);
			}
		}

		// Init Frame
		frame = new JFrame("Sudoku");
		frame.setLayout(new GridLayout(3, 3, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// Add containers to frame
		for(int i = 0; i < containers.size(); i++) {
			frame.add(containers.get(i));
		}

		show();
	}

	private void show() {
		frame.setVisible(true);
	}
}
