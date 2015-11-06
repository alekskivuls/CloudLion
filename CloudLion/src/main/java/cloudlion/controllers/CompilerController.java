package cloudlion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloudlion.compiler.JavaCompiler;

@RestController
public class CompilerController {
	@Autowired
	private JavaCompiler compiler;

	
	//Request with /compiler?filename=file.extension
	@RequestMapping("compiler")
	public void compile(@RequestParam(value = "filename") String filename) {
		compiler.compile(filename);
	}

}
