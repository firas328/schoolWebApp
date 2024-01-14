package com.springHandOn.schoolWebApp.repository;

import com.springHandOn.schoolWebApp.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidayRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public HolidayRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<Holiday> getHolidays(){
        String sql="SELECT * FROM HOLIDAYS";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Holiday.class));
    }
}
