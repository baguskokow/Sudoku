/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import java.util.Random;

class RandomNumber {
	private static int number;
	private static Random rand = new Random();

	public static String getNumber() {
		int number = rand.nextInt(9) + 1;
		return String.valueOf(number); 
	}

	public static int randomRow() {
		return rand.nextInt(9);
	}
}
