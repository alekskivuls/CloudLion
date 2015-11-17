package cloudlion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloudlion.compiler.javaCompiler;

@RestController
public class CompilerController 
{
	@Autowired
	private javaCompiler compiler;

	
	//Request with /compiler?filename=file.extension
	@RequestMapping("compiler")
	public void compile(@RequestParam(value = "filename") String filename) 
	{
		compiler.compile(filename);
	}
	
//	//Request with /html/compiler.html?code=getcode
//	@RequestMapping("html/compiler.html")
//	public void getText(@RequestParam(value = "code") String Code) 
//	{
//		compiler.getText(Code);
//	}
	
	//Request with Compile button on editor.html
	@RequestMapping("editor.html")
	public void copyText(@RequestParam(value = "code") String Code, @RequestParam(value = "lang") String lang)
	{
			System.out.print("code received \n");
			System.out.print(lang);
			System.out.print("\n");
			compiler.getText(Code, lang);
	}


}
