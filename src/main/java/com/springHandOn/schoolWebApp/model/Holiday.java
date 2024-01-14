package com.springHandOn.schoolWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Holiday {

    private  String day;
    private  String reason;
    private  Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
