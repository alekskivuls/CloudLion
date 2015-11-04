package cloudlion.compiler;
//import code modified from:
//http://stackoverflow.com/questions/19374345/get-parameter-sent-via-jquery-ajax-in-java-servlet

//dopost() information found at:
//http://stackoverflow.com/questions/2349633/doget-and-dopost-in-servlets

//Source for using javac in a compiler
//http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html
//accessed 10/31/2015

//Source for preparing code for compilation
//http://www.javaworld.com/article/2077497/testing-debugging/java-tip-131--make-a-statement-with-javac-.html
//Author: Shawn Silverman
//accessed 10/31/2015
			
//additionally, uses modified syntax from:
//http://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html
//and
//http://stackoverflow.com/questions/6366743/saving-files-to-a-specific-directory-in-java
//accessed 11/3/2015

import java.io.File;
import java.util.Scanner;


public class javaCompiler
{
	
	String langValue;
	String Code;
	int exitCode;
	
	public javaCompiler(){}
	
	public void compile(String filename)
	{
		switch(langValue)
		{
			case "java":
			
			try
			{
				File compilefile = new File(filename);
				Scanner scan = new Scanner(compilefile);
				while (scan.hasNextLine())
					System.out.println(scan.nextLine());
			}
			catch (Exception e){
				System.out.print("file not found");
			}
		//	PrintWriter CodeOutput = new PrintWriter(compilefile);
		//	CodeOutput.println(Code);	
		//	CodeOutput.flush();
		//	CodeOutput.close();
			
			
		
//			JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
//			exitCode = javac.run(null, compileFile, null, null);
			break;
		
		}
	}
}
			

