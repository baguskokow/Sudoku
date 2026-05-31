/*
 *
 * Dibuat oleh kelompok 1
 *
 * */

package com.sudoku;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

class ListState {
	private String path = "src/com/sudoku/savedata/";
	private File directory = new File(path);
	private ArrayList<String> listOfState = new ArrayList<String>();
	private String lastModified;

	public ArrayList<String> getAllState() {
		File[] files = directory.listFiles();
	
		if(files != null) {
			for(File file : files) {
				if(file.isFile()) {
					listOfState.add(file.getName());
				}
			}
		}
		return listOfState;
	}

	public String getLastModified(File file) {
		if(file.exists()) {
			long miliseconds = file.lastModified();

			Date date = new Date(miliseconds);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
		return "Data tidak ditemukan";
	}
}
