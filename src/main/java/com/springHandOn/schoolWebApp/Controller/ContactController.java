package com.springHandOn.schoolWebApp.Controller;

import com.springHandOn.schoolWebApp.model.Contact;
import com.springHandOn.schoolWebApp.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    Logger logger = LoggerFactory.getLogger(ContactController.class.getName());

    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService){
        this.contactService=contactService;
    }
    @RequestMapping(path="/contact")
    public String displayContactPage(){
        return "contact.html";
    }
    @PostMapping(path="saveMsg")
    public ModelAndView saveMessage(Contact contact){
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
