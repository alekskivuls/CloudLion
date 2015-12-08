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

	String classname = "";
	String extension = "";
	String lang;
	String Code;
	int exitCode;

	public javaCompiler() {
	}

	public void compile(String Code, String fileName) 
	{	
		classname = fileName.substring(0, fileName.indexOf('.'));
		extension = fileName.substring(fileName.lastIndexOf('.') + 1);
		System.out.print("The class name of the file is: " + classname + "\n");
		System.out.print("The extension of the file is: " + extension + "\n");
		
		switch (extension) {
		case "java":

			String compileCodeJava = Code;
			//System.out.print("compile code is: \n" + compileCodeJava + "\n");
			
			try 
			{
			
			//Terminates function if code string is empty
			if (Code == "")
			{
				throw new Throwable("There is no code to compile! .java file unsuccessfully compiled.");
			}	
			
			//Writing logic source:	
			//https://www.youtube.com/watch?v=V-sgbrg5jW4		
			BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\" + classname + ".java"));
			codeWriter.write(compileCodeJava);	
			codeWriter.close();
				
			//modified from source: 
			//http://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program
			String[] procArgs = new String[] {"cmd", "/K", "javac", ".\\" + classname + ".java"};
			Process compilerProcess = new ProcessBuilder(procArgs).start();
			System.out.print(".java file successfully compiled. \n");
			} 
			catch (Exception e) 
			{
				System.out.print("Exception: File not found! \n");
			}
			catch (Throwable t)
			{
				System.out.print("Exception: " + t.getMessage() + "\n");
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

//Removed in favor of more dynamic compilation code
//Code string and language is passed by CompilerController.java
//	public void getText(String Code, String filename)
//	{
//		String gotLang = filename.substring(filename.lastIndexOf('.') + 1);
//		//String gotLang = lang;
//		switch (gotLang) 
//		{
//			case "java":
//				
//				String compileCodeJava = Code;
//				System.out.print("compile code is: \n" + compileCodeJava + "\n");
//									
//				try
//				{
//				//Writing logic source:	
//				//https://www.youtube.com/watch?v=V-sgbrg5jW4	
//				//Note: sends to CloudLion folder		
//				BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\write.java"));
//				codeWriter.write(compileCodeJava);	
//				codeWriter.close();
//					
//				System.out.print(".java file successfully created. \n");
//				System.out.print(".java file is ready to compile \n");
//				if (Code == "")
//				{
//					throw new Exception("file must be created");
//				}
//				
//				//modified from source: 
//				//http://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program
//				String[] procArgs = new String[] {"cmd", "/K", "javac", ".\\write.java"};
//				Process compilerProcess = new ProcessBuilder(procArgs).start();
//				System.out.print(".java file successfully compiled.");
//				
//				}
//				catch (IOException i)
//				{
//					i.printStackTrace();
//				}
//				catch (Exception e)
//				{
//					System.out.print("file not found \n");
//				}
//				break;
//			case "c":
//	
//				String compileCodeC = Code;
//				System.out.print("compile code is: \n" + compileCodeC + "\n");
//				
//				try
//				{
//				//Writing logic source:	
//				//https://www.youtube.com/watch?v=V-sgbrg5jW4	
//				//Note: sends to CloudLion folder	
//				BufferedWriter codeWriter = new BufferedWriter(new FileWriter(".\\write.c"));
//				codeWriter.write(compileCodeC);	
//				codeWriter.close();
//				
//				System.out.print(".c file successfully created. \n");
//				System.out.print(".c file is ready to compile. \n");
//				if (Code == "")
//				{
//					throw new Exception("empty .cpp file");
//				}
//				
//				//see "case 'java'" for citation
//				String[] procArgs = new String[] {"cmd", "/K", "gcc", ".\\write.c"};
//				Process compilerProcess = new ProcessBuilder(procArgs).start();
//				
//				}
//				catch (IOException i)
//				{
//					i.printStackTrace();
//				}
//				catch (Exception e)
//				{
//					System.out.print("file not found \n");
//				}
//				break;
//			case "":
//				try{
//				throw new Exception("Empty Language Variable");
//				}
//				catch (Exception e)
//				{
//					System.out.print("Empty Language Variable");
//				}
//		}
//	}
//
//
//		