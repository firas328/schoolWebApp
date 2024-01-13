package com.springHandOn.schoolWebApp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseModel {
  private LocalDateTime created_at;
  private String created_by;
  private LocalDateTime updated_at;
  private String updated_by;
}
