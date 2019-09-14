package com.wynk.follow.controller.responses;

import java.util.Set;

public class UnFollowStatus {
  String status;
  String message;

  public UnFollowStatus(String user, Set<String> artists) {
    this.status = "ok";
    this.message = user + " stopped following " + String.join(", ", artists);
  }

  public UnFollowStatus(String status, String message) {
    this.status = status;
    this.message = message;
  }

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

  public static final UnFollowStatus ERROR =
      new UnFollowStatus("failed", "invalid input parameters");
}
