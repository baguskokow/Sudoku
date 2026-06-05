/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

class SaveData {
	private static String[][] userInput = new String[9][9];
	private static String[][] board = new String[9][9];
	private static String savedTime;
	private static String savedDifficulty;
	private static int savedHintClicked;
	private static boolean[][] editable = new boolean[9][9];
	private static final String PATH = "src/com/sudoku/savedata/";
	private App app;
	private static String[][] solution = new String[9][9];

	// Ini nanti dibikin dinamik nama filenya
	
	public static void save(JTextField[][] fields, Timer timer, String difficulty, int hintClicked, String[][] solution) {
		String fileName = PATH + ListState.generateFileName();
		try {
			FileWriter file = new FileWriter(fileName);

			file.write("[BOARD]\n");
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					String value = fields[i][j].getText();
						
					if(value == null || value.trim().isEmpty()) {
						value = "0";
					}

					file.write(value);

					if(j < 8) {
						file.write(" ");
					}
				}
				file.write("\n");
			}

			file.write("[EDITABLE]\n");
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(fields[i][j].isEditable() == true) {
						file.write("1");
					} else {
						file.write("0");
					}

					if(j < 8) {
						file.write(" ");
					}
				}
				file.write("\n");
			}
			
			file.write("[TIME]\n");
			file.write(timer.getTime() + "\n");

			file.write("[DIFFICULTY]\n");
			file.write(difficulty + "\n");
			
			file.write("[HINT LEFT]\n");
			file.write(hintClicked + "\n");

			file.write("[SOLUTION]\n");
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					String value = solution[i][j];
						
					file.write(value);

					if(j < 8) {
						file.write(" ");
					}
				}
				file.write("\n");
			}

			file.close();

		} catch (Exception e) {
			System.out.println("Error save!");	
		}
	}

	public static void read(String fileName) {
		try {
			Scanner read = new Scanner(new FileReader(PATH + fileName));
			//Scanner read = new Scanner(new FileReader("src/com/sudoku/savedata/state.txt"));

			read.nextLine(); //[Board]

			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					board[r][c] = read.next();
				}
			}

			read.nextLine();
			read.nextLine(); // [EDITABLE]
			
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					editable[r][c] = read.next().equals("1");
				}
			}

			read.nextLine();
			read.nextLine(); // [TIME]

			savedTime = read.next();
			System.out.println(savedTime); // Debuggin


			read.nextLine();
			read.nextLine(); // [DIFFICUTY]

			savedDifficulty = read.next();
			System.out.println(savedDifficulty);
			read.nextLine();

			//READ [HINT LEFT]
			read.nextLine();
			savedHintClicked = Integer.parseInt(read.next());
			read.nextLine();
			read.nextLine();

			// Read [SOLUTION]
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					solution[r][c] = read.next();
				}
			}

			read.close();
		} catch(Exception e) {
			System.out.println("Failed to read state");
		}
	}

	public static String[][] getBoard() {
		return board;
	}

	public static boolean[][] getEditable() {
		return editable;
	}

	public static String getSavedTime() {
		return savedTime;
	}

	public static String getSavedDifficulty() {
		return savedDifficulty;
	}

	public static int getSavedHintClicked() {
		return savedHintClicked;
	}

	public static String[][] getSolution() {
		return solution;
	}
}
