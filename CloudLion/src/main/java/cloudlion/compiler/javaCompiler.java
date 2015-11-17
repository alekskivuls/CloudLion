package cloudlion.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Service;

@Service
public class javaCompiler {

	String extension = "";
	String lang;
	String Code;
	int exitCode;

	public javaCompiler() {
	}

	//Code string and language is passed by CompilerController.java
	public void getText(String Code, String lang)
	{
		String gotLang = lang;
		switch (gotLang) 
		{
			case "java":
				
				String compileCodeJava = Code;
				System.out.print("compile code is: \n" + compileCodeJava + "\n");
									
				try
				{
				//Writing logic source:	
				//https://www.youtube.com/watch?v=V-sgbrg5jW4	
				//Note: sends to CloudLion folder		
				BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\write.java"));
				codeWriter.write(compileCodeJava);	
				codeWriter.close();
					
				System.out.print(".java file successfully created. \n");
				System.out.print(".java file is ready to compile \n");
				
				//modified from source: 
				//http://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program
				String[] procArgs = new String[] {"cmd", "/K", "javac", ".\\write.java"};
				Process compilerProcess = new ProcessBuilder(procArgs).start();
				System.out.print(".java file successfully compiled.");
				
				}
				catch (IOException i)
				{
					i.printStackTrace();
				}
				catch (Exception e)
				{
					System.out.print("file not found \n");
				}
				break;
			case "c":
	
				String compileCodeC = Code;
				System.out.print("compile code is: \n" + compileCodeC + "\n");
				
				try
				{
				//Writing logic source:	
				//https://www.youtube.com/watch?v=V-sgbrg5jW4	
				//Note: sends to CloudLion folder	
				BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\write.c"));
				codeWriter.write(compileCodeC);	
				codeWriter.close();
				
				System.out.print(".c file successfully created. \n");
				System.out.print(".c file is ready to compile. \n");
				
				//see "case 'java'" for citation
				String[] procArgs = new String[] {"cmd", "/K", "gcc", ".\\write.c"};
				Process compilerProcess = new ProcessBuilder(procArgs).start();
				
				}
				catch (IOException i)
				{
					i.printStackTrace();
				}
				catch (Exception e)
				{
					System.out.print("file not found \n");
				}
				break;
		}
	}



//The following should only be used once a proper file directory has been established		
	public void compile(String filename) 
	{
		extension = filename.substring(filename.lastIndexOf('.') + 1);
		System.out.print("The extension of the file is: " + extension);
		System.out.print("\n");
		switch (extension) {
		case "java":

			try 
			{
			//Writing logic source:	
			//https://www.youtube.com/watch?v=V-sgbrg5jW4	
			String compileCode = "";	
			BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\write.java"));
			codeWriter.write(compileCode);	
			codeWriter.close();
				
			//modified from source: 
			//http://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program
			String[] procArgs = new String[] {"cmd", "/K", "javac", ".\\write.java"};
			Process compilerProcess = new ProcessBuilder(procArgs).start();
			System.out.print(".java file successfully compiled.");
			} 
			catch (Exception e) 
			{
				System.out.print("file not found \n");
			}
			break;

		}
	}
}

	
	
//Following is bits of code that ended up being upgraded or discarded:

//No need to declare a JavaCompiler variable:
//JavaCompiler javac = ToolProvider.getSystemJavaCompiler();

//Removed in favor of buffered writer:
//PrintWriter CodeOutput = new PrintWriter(compilefileNEW);
//CodeOutput.println(Code);
//CodeOutput.flush();
//CodeOutput.close();
//FileOutputStream oStream = new FileOutputStream(compilefileNEW);

//Removed in favor of process builder
//String[] arguments = {"","","",""};
//javac.run(null, null, null, arguments);