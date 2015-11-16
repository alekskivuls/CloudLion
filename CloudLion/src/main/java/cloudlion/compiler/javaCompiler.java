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

	public void getText(String Code)
	{
//		switch (lang) 
//		{
//			case "java":
				//JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
				
				
				String compileCode = Code;
				System.out.print("compile code is: " + compileCode + "\n");
				
				//Note: sends to src folder
				//File compilefileNEW = new File("compiletest");
				
				try
				{
				//Writing logic source:	
				//https://www.youtube.com/watch?v=V-sgbrg5jW4	
				BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\write.java"));
				codeWriter.write(compileCode);	
				codeWriter.close();
					
				System.out.print("File successfully created \n");
				//PrintWriter CodeOutput = new PrintWriter(compilefileNEW);
				//CodeOutput.println(Code);
				//CodeOutput.flush();
				//CodeOutput.close();
				//FileOutputStream oStream = new FileOutputStream(compilefileNEW);
				
				System.out.print("Ready to compile \n");
				
				//String[] arguments = {"","","",""};
				//javac.run(null, null, null, arguments);
				
				//modified from source: 
				//http://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program
				String[] procArgs = new String[] {"cmd"};
				System.out.print("worked");
				Process compilerProcess = Runtime.getRuntime().exec(procArgs);
				//new ProcessBuilder(procArgs).start();
				
				}
				catch (IOException i)
				{
					i.printStackTrace();
				}
				catch (Exception e)
				{
					System.out.print("file not found \n");
				}
//			case "c":
//	
//				String compileCode = Code;
//				System.out.print("compile code is: " + compileCode + "\n");
//				
//				File compilefileNEW = new File("compiletest");
//				
//				try
//				{
//				System.out.print("File successfully created \n");
//				PrintWriter CodeOutput = new PrintWriter(compilefileNEW);
//				CodeOutput.println(Code);
//				CodeOutput.flush();
//				CodeOutput.close();
//				
//				FileOutputStream oStream = new FileOutputStream(compilefileNEW);
//				System.out.print("Ready to compile \n");
//				
//				//see "case 'java'" for source
//				String[] procArgs = new String[] {"/bin/bash", "-c", "gcc"};
//				Process compilerProcess = new ProcessBuilder(procArgs).start();
//				
//				}
//				catch (Exception e)
//				{
//					System.out.print("file not found \n");
//				}
		}
//	}

	public void compile(String filename) 
	{
		extension = filename.substring(filename.lastIndexOf('.') + 1);
		System.out.print("The extension of the file is: " + extension);
		System.out.print("\n");
		switch (extension) {
		case "java":

			try 
			{
				File compilefile = new File(filename);
				Scanner scan = new Scanner(compilefile);
				while (scan.hasNextLine())
				System.out.println(scan.nextLine());
				
				
				
				//JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
				 //javac.run(null, compileFile, null, null);
			} 
			catch (Exception e) 
			{
				System.out.print("file not found \n");
			}
			// PrintWriter CodeOutput = new PrintWriter(compilefile);
			// CodeOutput.println(Code);
			// CodeOutput.flush();
			// CodeOutput.close();

			break;

		}
	}
}
