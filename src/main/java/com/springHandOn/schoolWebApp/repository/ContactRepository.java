package com.springHandOn.schoolWebApp.repository;

import com.springHandOn.schoolWebApp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public int saveMsg(Contact contact){
        String sql="insert INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,"+
                "SUBJECT,MESSAGE,STATUS,CREATED_AT,CREATED_BY) VALUES(?,?,?,?,?,?,?,?);";
        return this.jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),
        contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreated_at(),contact.getCreated_by());
    }
}
