package cloudlion.controllers;

import cloudlion.database.UserCreateForm;
import cloudlion.database.validator.UserCreateFormValidator;
import cloudlion.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;
	private final UserCreateFormValidator userCreateFormValidator;

	@Autowired
	public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
		this.userService = userService;
		this.userCreateFormValidator = userCreateFormValidator;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form,
			BindingResult bindingResult) {
		LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "redirect:/signup";
		}
		try {
			userService.create(form);
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			return "redirect:/signup";
		}
		// ok, redirect
		return "redirect:/login";
	}

}
