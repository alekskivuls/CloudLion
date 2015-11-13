package cloudlion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloudlion.texteditor.TextEditor;

@RestController
@RequestMapping("TextEditor")
public class TextController {

	public static void main(String[] args){
		new TextEditor();
	}

}
