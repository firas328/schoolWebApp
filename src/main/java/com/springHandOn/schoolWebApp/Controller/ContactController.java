package com.springHandOn.schoolWebApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    Logger logger = LoggerFactory.getLogger(ContactController.class.getName());
    @RequestMapping(path="/contact")
    public String displayContactPage(){
        return "contact.html";
    }
    @PostMapping(path="saveMsg")
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,@RequestParam String email,
                                    @RequestParam String subject,@RequestParam String message ){
        logger.info("Name :"+name);
        logger.info("mobile number :"+mobileNum);
        logger.info("email :"+email);
        logger.info("subject :"+subject);
        logger.info("message :"+message);
        return new ModelAndView("redirect:/contact");
    }
}
