/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.util.Collections;

class LoadMenu {
	private ArrayList<String> listOfState = new ArrayList<String>();
	private ArrayList<String> listOfLastModified = new ArrayList<String>();
	private static JFrame loadFrame;
	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	private JPanel statePanel;
	private JPanel functionPanel; 
	private JScrollPane scrollPane;
	private int totalState;
	private ImageIcon wallpaper;
	private ImageIcon loadGameIcon;
	private JLabel loadGameLabel;
	private final Font buttonFont = SudokuFont.getFont("Inter", 1, 18);
	private final String backgroundColor = "#FFFFFF";
	private final String foregroundColor = "#000000";

	// Frame Padding
	private final int topPadding = 30;
	private final int bottomPadding = 20;
	private final int rightPadding = 300;
	private final int leftPadding = 300;
	private Border framePadding;
	private JPanel contentPanel;

	private ListState listState = new ListState();

	public LoadMenu() {
		countOfState();
		setImage();
		addLastModified();
		setButton();
		addButtonToPanel();
		initialized();
		addButtonEvent();
	}

	public static JFrame getFrame() {
		return loadFrame;
	}

	public static void killFrame() {
		System.out.println("Dispose load menu : " + loadFrame);
		if(loadFrame != null) {
			loadFrame.dispose();
			loadFrame = null;
		}
	}

	private void printFile() {
		for(int i = 0; i < totalState; i++) {
			System.out.println(listOfState.get(i));
		}
	}

	private void printModified() {
		for(int i = 0; i < totalState; i++) {
			System.out.println(listOfLastModified.get(i));
		}
	}

	private void setButton() {
		for(int i = 0; i < totalState; i++) {
			JTextField newField = new JTextField();
			String buttonName = listOfLastModified.get(i);
			JButton newButton = new Button(buttonName, backgroundColor, foregroundColor, buttonFont).getButton();
			newButton.setActionCommand(listOfState.get(i));
			listButton.add(newButton);
		}
	}	

	private void addButtonEvent() {
		for(int i = 0; i < listButton.size(); i++) {
			JButton buttonState = listButton.get(i);
			String nameState = listOfState.get(i);

			buttonState.addActionListener(e -> {
				System.out.println("Read state from " + nameState);
				SaveData.read(nameState);
				loadFrame.dispose();
				new App(null);
			});	
		}
	}

	private void addButtonToPanel() {
		loadGameLabel = new JLabel(loadGameIcon);
		statePanel = new JPanel();
		statePanel.setLayout(new GridLayout(totalState, 1, 1, 1));
		for(int i = 0; i < listButton.size(); i++) {
			statePanel.add(listButton.get(i));
		}
	}

	private void addLastModified() {
		for(int i = 0; i < listOfState.size(); i++) {
			String tempName = "src/com/sudoku/savedata/" + listOfState.get(i);
			File file = new File(tempName);

			listOfLastModified.add(listState.getLastModified(file));
		}
	}

	private void setPadding() {
		framePadding = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
		contentPanel = (JPanel) loadFrame.getContentPane();	
		contentPanel.setBorder(framePadding);
	}

	private void countOfState() {
		ArrayList<String> tempList = new ArrayList<String>();
		tempList = listState.getAllState();
		System.out.println(tempList);
		listOfState.clear();
		for(int i = 0; i < tempList.size(); i++) {
			String nameState = tempList.get(i).replace(".txt", "");
			listOfState.add(tempList.get(i));
		}

		Collections.sort(listOfState, Collections.reverseOrder());
		System.out.println(listOfState);
		totalState = listOfState.size();
	}

	private void initialized() {
		scrollPane = new JScrollPane(statePanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		loadFrame = new JFrame();
		loadFrame.setSize(1200, 600);
		loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadFrame.setLocationRelativeTo(null);
		loadFrame.setResizable(false);
		loadFrame.setLayout(new BorderLayout());
		setPadding();
		loadFrame.add(scrollPane, BorderLayout.CENTER);
		loadFrame.add(loadGameLabel, BorderLayout.NORTH);
		show();
	}

	private void setImage() {
		wallpaper = new ImageHelper("src/com/sudoku/images/loadBackground.png", 1200, 600).getImageIcon();
		loadGameIcon = new ImageHelper("src/com/sudoku/images/loadGame.png", 300, 150).getImageIcon();
	}

	private void show() {
		loadFrame.setVisible(true);
	}
}
