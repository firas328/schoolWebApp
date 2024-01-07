package com.springHandOn.schoolWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;
    public enum Type{
        FESTIVAL,FEDERAL
    }
}
