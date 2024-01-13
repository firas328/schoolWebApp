package com.springHandOn.schoolWebApp.repository;

import com.springHandOn.schoolWebApp.RowMapper.ContactRowMapper;
import com.springHandOn.schoolWebApp.constant.ApplicationConstant;
import com.springHandOn.schoolWebApp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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
    public List<Contact> queryMessagesWithStatus(String status){
        String sql="SELECT * FROM CONTACT_MSG WHERE status=?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,status);
            }
        }, new ContactRowMapper() );

    }
    public int updateMsgSatus(int id, String name){
       String sql="Update CONTACT_MSG SET STATUS=? ,UPDATED_BY=?,UPDATED_AT=? WHERE CONTACT_ID=?";
       return jdbcTemplate.update(sql, new PreparedStatementSetter() {
           @Override
           public void setValues(PreparedStatement ps) throws SQLException {
               ps.setString(1, ApplicationConstant.CLOSE);
               ps.setString(2, name);
               ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
               ps.setInt(4,id);
           }
       });
    }
}
