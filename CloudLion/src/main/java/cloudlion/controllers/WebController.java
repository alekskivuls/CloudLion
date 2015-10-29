package cloudlion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value={"/", "home"})
    String index(){
        return "login";
    }
    
    @RequestMapping("editor")
    String editor(){
        return "editor";
    }
    
    @RequestMapping("signup")
    String signUp(){
        return "signup";
    }
    
    @RequestMapping("login")
    String login(){
        return "login";
    }
}