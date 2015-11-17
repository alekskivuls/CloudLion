package cloudlion.texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

@Service
public class TextEditor extends JFrame{

	public boolean changed = false;
	private File myfile;
	String file;
	String getText;
	
	public TextEditor(){

	}

	public void optionMenu(String file){
		String clickFile = file;

		if(clickFile.equals("new")){
			newFile();
		} else if(clickFile.equals("save")){
			saveFile();
		} else if(clickFile.equals("load")){
			loadFile();
		}
	}

	public void newFile(){
		
	}

/*	public String loadFile(File file){
		StringBuilder result = new StringBuilder();
		try{
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while ((line = reader.readLine()) != null){
				result.append(line + "\n");
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		return result.toString();
	}*/
	
	private void loadFile() {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setMultiSelectionEnabled(false);
		try {
			int result = dialog.showOpenDialog(this);
			if (result == JFileChooser.CANCEL_OPTION)
				return;
			if (result == JFileChooser.APPROVE_OPTION) {
				if (changed)
					saveFile();
				myfile = dialog.getSelectedFile();
				//textPane.setText(readFile(myfile));
				changed = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String readFile(File file) {
		StringBuilder result = new StringBuilder();
		try {
			FileReader fr = new FileReader(file);		
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while ((line = reader.readLine()) != null) {
				result.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot read file !", "Error !", JOptionPane.ERROR_MESSAGE);
		}
		return result.toString();
	}
	

	public void saveFile(){
		String text = getText;
		System.out.println(text);
		try{
			PrintWriter writer = new PrintWriter(myfile);
			if(!myfile.canWrite())
				throw new Exception("Cannot write file!");
			writer.write(text);
			changed = false;
			writer.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void saveAs(String dialogTitle) {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setDialogTitle(dialogTitle);
		int result = dialog.showSaveDialog(this);
		if (result != JFileChooser.APPROVE_OPTION)
			return;
		myfile = dialog.getSelectedFile();
		try{
			PrintWriter writer = new PrintWriter(myfile);
			//writer.write(textPane.getText());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}//class ends

