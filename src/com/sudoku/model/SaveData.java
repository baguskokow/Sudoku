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
	private static String path = "src/com/sudoku/savedata/state.txt";
	private static String[][] board = new String[9][9];
	private static boolean[][] editable = new boolean[9][9];

	// Ini nanti dibikin dinamik nama filenya
	
	public static void save(JTextField[][] fields) {
		try {
			FileWriter file = new FileWriter(path);

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

			file.close();
			System.out.println("Game Saved!");

		} catch (Exception e) {
			System.out.println("Error save!");	
		}
	}

	public static void read(String fileName) {
		try {
		//	Scanner read = new Scanner(new FileReader(fileName));
			Scanner read = new Scanner(new FileReader("src/com/sudoku/savedata/state.txt"));

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
}
