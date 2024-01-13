package com.springHandOn.schoolWebApp.services;

import com.springHandOn.schoolWebApp.Controller.ContactController;
import com.springHandOn.schoolWebApp.constant.ApplicationConstant;
import com.springHandOn.schoolWebApp.model.Contact;
import com.springHandOn.schoolWebApp.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@SessionScope
public class ContactService {
    //Logger log = LoggerFactory.getLogger(ContactService.class.getName());
    @Autowired
    private ContactRepository contactRepository;
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setCreated_at(LocalDateTime.now());
        contact.setCreated_by(ApplicationConstant.ANANYMOUS);
        contact.setStatus(ApplicationConstant.OPEN);
        int i =contactRepository.saveMsg(contact);
        if (i>0){
            isSaved=true;
        }
        return isSaved;
    }
    public List<Contact> findObjectsWithOpenStatus(){
       List<Contact> messages=contactRepository.queryMessagesWithStatus(ApplicationConstant.OPEN);
        return messages;
    }
}
