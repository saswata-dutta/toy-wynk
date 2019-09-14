package com.wynk.follow.controller.responses;

public class PublishSongStatus {
  private String status;
  private String message;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PublishSongStatus(String status, String message) {
    this.status = status;
    this.message = message;
  }
}
