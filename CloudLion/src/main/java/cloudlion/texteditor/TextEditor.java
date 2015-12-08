package cloudlion.texteditor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
			PrintWriter writer = new PrintWriter(".\\" + fileTitle);
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
