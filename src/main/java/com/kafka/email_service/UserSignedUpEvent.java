package com.kafka.email_service;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class UserSignedUpEvent {
  private Long userId;
  private String email;
  private String name;

  public UserSignedUpEvent() {
  }

  public UserSignedUpEvent(Long userId, String email, String name) {
    this.userId = userId;
    this.email = email;
    this.name = name;
  }

  public static UserSignedUpEvent fromJson(String json) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();

      return objectMapper.readValue(json, UserSignedUpEvent.class);
    } catch (JacksonException e) {
      throw new RuntimeException("Json 파싱 실패");
    }
  }

  public Long getUserId() {
    return userId;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }
}
