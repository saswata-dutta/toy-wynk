package com.wynk.follow.controller.responses;

import java.util.Set;

public class FollowStatus {
  String status;
  String message;

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

  public FollowStatus(String user, Set<String> artists) {
    this.status = "ok";
    this.message = user + " started following " + String.join(", ", artists);
  }

  public FollowStatus(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public static final FollowStatus ERROR = new FollowStatus("failed", "invalid input parameters");
}
