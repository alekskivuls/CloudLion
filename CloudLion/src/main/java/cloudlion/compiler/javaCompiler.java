package cloudlion.compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Service;

@Service
public class javaCompiler {

	String extension = "";
	String Code;
	int exitCode;

	public javaCompiler() {
	}

	public void getText(String Code)
	{
		JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
		String compileCode = Code;
		System.out.print("compile code is: " + compileCode + "\n");
		
		File compilefileNEW = new File("compiletest");
		
		try
		{
		System.out.print("File successfully created \n");
		PrintWriter CodeOutput = new PrintWriter(compilefileNEW);
		CodeOutput.println(Code);
		CodeOutput.flush();
		CodeOutput.close();
		
		FileOutputStream oStream = new FileOutputStream(compilefileNEW);
		
		String[] arguments = {"","","",""};
		System.out.print("Ready to compile \n");
		javac.run(null, null, null, arguments);
		}
		catch (Exception e)
		{
			System.out.print("file not found \n");
		}
	}

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
				JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
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
