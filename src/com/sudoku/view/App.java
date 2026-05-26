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

	// List of text fields;
	private JTextField A_TextField_1;
	private JTextField A_TextField_2;
	private JTextField A_TextField_3;
	private JTextField A_TextField_4;
	private JTextField A_TextField_5;
	private JTextField A_TextField_6;
	private JTextField A_TextField_7;
	private JTextField A_TextField_8;
	private JTextField A_TextField_9;

	private ArrayList<JComponent> A_TextFields = new ArrayList<JComponent>();

	public App() { // Constructor
		initialized();
	}

	private void initTextField() {
		A_TextField_1 = new JTextField("1");
		A_TextField_2 = new JTextField("1");
		A_TextField_3 = new JTextField("1");
		A_TextField_4 = new JTextField("1");
		A_TextField_5 = new JTextField("1");
		A_TextField_6 = new JTextField("1");
		A_TextField_7 = new JTextField("1");
		A_TextField_8 = new JTextField("1");
		A_TextField_9 = new JTextField("1");

		JComponent[] textFields = {
			A_TextField_1, A_TextField_2, A_TextField_3,
			A_TextField_4, A_TextField_5, A_TextField_6,
			A_TextField_7, A_TextField_8, A_TextField_9
		};
		
		for(int i = 0; i < textFields.length; i++) {
			A_TextFields.add(textFields[i]);
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
	
		// Init panel
		initTextField();
		for(int i = 0; i < A_TextFields.size(); i++) {
			containers.get(0).add(A_TextFields.get(i));
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
