package com.springHandOn.schoolWebApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping(path="/contact")
    public String displayContactPage(){
        return "contact.html";
    }
}
