package cloudlion.texteditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

@Service
public class TextEditor {

	public TextEditor() {

	}

	public void optionMenu(String Code, String file, String fileName) {
		String please = Code;
		String clickFile = file;
		String name = fileName;
		if (clickFile.equals("save")) {
			saveFile(please, name);
		}
	}

	public void saveFile(String Code, String name) {
		String myCode = Code;
		String fileTitle = name;
		try {
			PrintWriter writer = new PrintWriter(fileTitle + ".txt");
			writer.write(myCode);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void loadFile(String myFile) { String work = myFile; try {
	 * FileReader getfile = new FileReader(work+".txt"); BufferedReader reader =
	 * new BufferedReader(getfile);
	 * 
	 * String fileText = ""; String line = reader.readLine(); while (line !=
	 * null) { fileText += line; line = reader.readLine(); }
	 * System.out.print(fileText); } catch (Exception e) { System.out.println(
	 * "File not found"); } }
	 */

}// class ends
