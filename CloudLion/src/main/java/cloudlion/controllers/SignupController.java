package cloudlion.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignupController.class);

	@RequestMapping("/signup")
	public String getSignupPage() {
		LOGGER.debug("Getting signup page");
		return "signup";
	}

}