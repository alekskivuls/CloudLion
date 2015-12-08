package cloudlion.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloudlion.database.FileCreateForm;
import cloudlion.database.validator.FileCreateFormValidator;
import cloudlion.service.file.FileService;

@Controller
public class FileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	private final FileService fileService;
	private final FileCreateFormValidator fileCreateFormValidator;

	@Autowired
	public FileController(FileService fileService, FileCreateFormValidator fileCreateFormValidator) {
		this.fileService = fileService;
		this.fileCreateFormValidator = fileCreateFormValidator;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(fileCreateFormValidator);
	}

	@RequestMapping(value = "/file/create", method = RequestMethod.POST)
	public String handleFileCreateForm(@Valid @ModelAttribute("form") FileCreateForm form,
			BindingResult bindingResult) {
		LOGGER.debug("Processing File create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return null;//"redirect:/signup";
		}
		try {
			fileService.create(form);
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same File
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn("Exception occurred when trying to save the File, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			return null;//"redirect:/signup";
		}
		// ok, redirect
		return "";//"redirect:/login";
	}
	
	   @RequestMapping("/file")
	    public String getFilePage() {
	        LOGGER.debug("Getting file page");
	        return "file";
	    }

}
