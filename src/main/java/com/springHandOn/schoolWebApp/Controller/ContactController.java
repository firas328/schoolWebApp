package com.springHandOn.schoolWebApp.Controller;

import com.springHandOn.schoolWebApp.model.Contact;
import com.springHandOn.schoolWebApp.services.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
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
        log.info("saving");
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
