package com.springHandOn.schoolWebApp.Controller;

import com.springHandOn.schoolWebApp.model.Contact;
import com.springHandOn.schoolWebApp.services.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public String displayContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }
    @PostMapping(path="saveMsg")
    public String  saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors error){
        if (error.hasErrors()){
            log.error("contact form submitting failed due to"+error.toString());
            return "contact.html ";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
    @GetMapping(path="/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<Contact> messages=contactService.findObjectsWithOpenStatus();
        var modelAndView=new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",messages);
        return modelAndView;
    }
}
