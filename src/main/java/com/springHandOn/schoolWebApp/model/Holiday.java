package com.springHandOn.schoolWebApp.model;

public class Holiday {
    private final String day;
    private final Type type;
    private final String reason;
    public enum Type{
        FESTIVAL,FEDERAL
    }

    public Holiday(String day,  String reason,Type type) {
        this.day = day;
        this.type = type;
        this.reason = reason;
    }

    public String getDay() {
        return day;
    }

    public Type getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }


}
