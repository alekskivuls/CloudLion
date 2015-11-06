package cloudlion.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditorController.class);

    @RequestMapping("/editor")
    public String getEditorPage() {
        LOGGER.debug("Getting editor");
        return "editor";
    }

}