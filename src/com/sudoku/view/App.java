/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;
import java.util.Stack;

class App {
	private final int WIDTH_FRAME = 1200;
	private final int HEIGHT_FRAME = 600;
	private final String COLOR_MINT = "#A2D1B3";
	private final String COLOR_WHITE = "#FFFFFF";
	private final String LINE_COLOR = "#4a4444";
	private final Font textFieldFont = SudokuFont.getFont("Inter", 1, 18); 	
	private ImageIcon clearIcon;
	private String savedTime;
	
	// Frame Padding
	private final int topPadding = 30;
	private final int bottomPadding = 20;
	private final int rightPadding = 300;
	private final int leftPadding = 300;

	private static JFrame frame;
	private Border framePadding;
	private JPanel contentPanel;

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

	private JTextField[][] fields = new JTextField[9][9]; // Untuk kolom-kolom kecil
	private JTextField selectedField = null;
	// Pembungkus UI
	private JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
	private JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
	
	private JPanel boardPanel = new JPanel(new GridLayout(3, 3, 0, 0)); // Board Panel
	private NumberPad numberPad = new NumberPad();																										 
	private JPanel numberPanel = numberPad.getPanel();
	private ButtonController buttonController = new ButtonController(numberPad.getAllButton(), fields, this);
	private Timer timer = buttonController.getTimer();
	private JPanel timePanel = timer.getPanel();

	private FunctionPad functionPad = new FunctionPad();
	private JPanel functionPanel = functionPad.getPanel();
																												 
	private JButton undoButton = functionPad.getUndoButton(); 
	private JButton redoButton = functionPad.getRedoButton(); 
	private JButton hintButton = functionPad.getHintButton(); 
	private JButton saveButton = functionPad.getSaveButton(); 
	private JButton quitButton = functionPad.getQuitButton(); 
	private JButton pauseButton = functionPad.getPauseButton(); 

	private static String difficulty;

	private static String[][] solution = new String[9][9]; // Save solution
																												 //
	public App(String difficulty) {
		this(difficulty, null);
	}

	public App(String difficulty, String savedTime) { // Constructor
		this.difficulty = difficulty;																	
		this.savedTime = savedTime;
		initialized();
	}

	public static String[][] getSolution() {
			return solution;
	}

	public static void killFrame() { 
		frame.dispose();
	}

	private void initialized() {
		// Init containers
		initContainer();
		initTextField();
		if(difficulty == null) {
			loadSudokuPuzzle();
		} else {
			generateSudokuPuzzle();
		}
		undoButton.addActionListener(buttonController);
		redoButton.addActionListener(buttonController);
		hintButton.addActionListener(buttonController);
		saveButton.addActionListener(buttonController);
		quitButton.addActionListener(buttonController);
		pauseButton.addActionListener(buttonController);
		
		// Ini untuk disable permanent input keyboard
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent event) {
				if (event.getSource() instanceof JTextField) {
					event.consume();
					return true;
				}
				return false;
			}
		});

		for(int i = 0; i < fields.length; i++) {
			for(int j = 0; j < fields[i].length; j++) {
				int boxIndex = (i / 3) * 3 + (j / 3);
				containers.get(boxIndex).add(fields[i][j]);
			}
		}

		// Init Frame
		frame = new JFrame("Sudoku");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// Add containers to frame
		for(int i = 0; i < containers.size(); i++) {
			boardPanel.add(containers.get(i));
		}

		topPanel.setPreferredSize(new Dimension(800, 650));
		topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		topPanel.add(boardPanel);
		
		numberPanel.setPreferredSize(new Dimension(250, 100));
		botPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		botPanel.add(numberPanel);
		botPanel.add(functionPanel);

		setPadding(); // Frame Padding
		frame.add(timePanel, BorderLayout.NORTH);
		frame.add(boardPanel, BorderLayout.CENTER);
		frame.add(botPanel, BorderLayout.SOUTH);

		show();
		if(savedTime != null) {
			timer.setTime(savedTime);
		}
		
		timer.setStartTimer();
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static String getDifficulty() {
		return difficulty;
	}

	public void loadSudokuPuzzle() {
		String[][] board = SaveData.getBoard();
		boolean[][] editable = SaveData.getEditable();
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				if(board[r][c].equals("0")) {
					fields[r][c].setText("");
				} else {
					fields[r][c].setText(board[r][c]);
				}

				fields[r][c].setEditable(editable[r][c]);
			}
		}
	}

	private void generateSudokuPuzzle() {
		SudokuGenerator.fillSudokuCell(fields, 0, 0);
		SudokuGenerator.fillSudokuCell(fields, 3, 3);
		SudokuGenerator.fillSudokuCell(fields, 6, 6);

		boolean success = SudokuGenerator.fillRemaining(fields, 0, 0);

		//Save solution
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				solution[row][col] = fields[row][col].getText();
			}
		}

		if(success) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}

		if(difficulty.equals("EASY")) {
			SudokuGenerator.removeCell(fields, 1);
		} else if(difficulty.equals("MEDIUM")) {
			SudokuGenerator.removeCell(fields, 51);
		} else if(difficulty.equals("HARD")) {
			SudokuGenerator.removeCell(fields, 56);
		} else {
			
		}

	}

	private void addCells() {
		for(int row = 0; row < containers.size(); row++) {
			for(int col = 0; col < 9; col++) {
				//int boxIndex = (row / 3) * 3 + (col / 3);
				containers.get(0).add(fields[row][col]);
			}
		}
	}

	private void addContainerToPanel() {
		for(int i = 0; i < containers.size(); i++) {
			boardPanel.add(containers.get(i));
		}
	}

	private void initTextField() {
		for(int row = 0; row < 9; row++) {
			final int currentRow = row;
			for(int col = 0; col < 9; col++) {
				final int currentCol = col;
				
				fields[row][col] = new JTextField();
				fields[row][col].setEditable(false);
				fields[row][col].setFocusable(true);
				fields[row][col].setHorizontalAlignment(JTextField.CENTER);
				fields[row][col].setFont(textFieldFont);
				fields[row][col].setPreferredSize(new Dimension(50, 50));

				int boxIndex = (row / 3) * 3 + (col / 3);
				if(boxIndex % 2 != 0) {
					fields[row][col].setBackground(Color.decode(COLOR_MINT));
				} else {
					fields[row][col].setBackground(Color.decode(COLOR_WHITE));
				}

				fields[row][col].addFocusListener(new FocusListener() {
					@Override
					public void focusGained(FocusEvent event) {
						JTextField source = (JTextField) event.getSource();
						buttonController.setActiveCell(currentRow, currentCol);

						source.setBackground(Color.decode("#8f798f"));
						source.setForeground(Color.decode(COLOR_WHITE));
					}

					@Override
					public void focusLost(FocusEvent event) {
						JTextField source = (JTextField) event.getSource();
						source.setForeground(Color.BLACK);

						if(boxIndex % 2 != 0) {
							source.setBackground(Color.decode(COLOR_MINT));
						} else {
							source.setBackground(Color.decode(COLOR_WHITE));
						}
					}
				});
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
			childContainer[i].setBorder(BorderFactory.createLineBorder(Color.decode(LINE_COLOR)));
			containers.add(childContainer[i]);
		}

		for(int i = 0; i < containers.size(); i++) {
			boardPanel.add(containers.get(i));
		}		
	}

	private void setPadding() {
		framePadding = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
		contentPanel = (JPanel) frame.getContentPane();	
		contentPanel.setBorder(framePadding);
	}

	private void show() {
		frame.setVisible(true);
	}
}
