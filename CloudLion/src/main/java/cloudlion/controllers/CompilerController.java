package cloudlion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloudlion.compiler.javaCompiler;

@RestController
@RequestMapping("javaCompiler")
public class CompilerController
{
	
	@Autowired
	private javaCompiler compiler;
	
	@RequestMapping("compiler")
	public void compile(@RequestParam("filename") String filename)
	{
		compiler.compile(filename);
	}
	
}


