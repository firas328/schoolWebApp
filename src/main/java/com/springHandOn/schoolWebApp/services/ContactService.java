package com.springHandOn.schoolWebApp.services;

import com.springHandOn.schoolWebApp.Controller.ContactController;
import com.springHandOn.schoolWebApp.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Service
@RequestScope
public class ContactService {
    //Logger log = LoggerFactory.getLogger(ContactService.class.getName());
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;
        log.info(contact.toString());
        return isSaved;
    }
}
