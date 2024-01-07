package com.springHandOn.schoolWebApp.services;

import com.springHandOn.schoolWebApp.Controller.ContactController;
import com.springHandOn.schoolWebApp.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    Logger logger = LoggerFactory.getLogger(ContactService.class.getName());
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;
        logger.info(contact.toString());
        return isSaved;
    }
}
