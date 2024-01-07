package com.springHandOn.schoolWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Holiday {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
