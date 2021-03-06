package cloudlion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloudlion.texteditor.TextEditor;

@Controller
public class TextController {

	@Autowired
	private TextEditor texteditor;

	@RequestMapping("editor.html")
	public void optionMenu(@RequestParam(value = "code") String Code, @RequestParam(value = "file") String file,
			@RequestParam(value = "name") String fileName) {
		texteditor.optionMenu(Code, file, fileName);
	}

}