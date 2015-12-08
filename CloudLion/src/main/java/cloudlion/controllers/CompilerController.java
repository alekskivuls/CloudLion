package cloudlion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloudlion.compiler.Compiler;

@RestController
public class CompilerController 
{
	@Autowired
	private Compiler compiler;

	//Request with Compile button on compiler.html
	@RequestMapping("compiler.html")
	public void copyText(@RequestParam(value = "code") String Code, @RequestParam(value = "filename") String fileName)
	{
			compiler.compile(Code, fileName);
	}


}
