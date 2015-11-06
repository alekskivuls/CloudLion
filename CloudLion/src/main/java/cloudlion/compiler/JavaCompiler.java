package cloudlion.compiler;

import java.io.File;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class JavaCompiler {

	String extension = "";
	String Code;
	int exitCode;

	public JavaCompiler() {
	}

	public void compile(String filename) {
		extension = filename.substring(filename.lastIndexOf('.') + 1);
		switch (extension) {
		case "java":

			try {
				File compilefile = new File(filename);
				Scanner scan = new Scanner(compilefile);
				while (scan.hasNextLine())
					System.out.println(scan.nextLine());
			} catch (Exception e) {
				System.out.print("file not found");
			}
			// PrintWriter CodeOutput = new PrintWriter(compilefile);
			// CodeOutput.println(Code);
			// CodeOutput.flush();
			// CodeOutput.close();

			// JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
			// exitCode = javac.run(null, compileFile, null, null);
			break;

		}
	}
}
