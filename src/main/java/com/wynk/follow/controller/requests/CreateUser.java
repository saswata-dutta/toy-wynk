package com.wynk.follow.controller.requests;

import javax.validation.constraints.NotNull;

public class CreateUser {

  @NotNull private String user;
  private String name;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateUser(@NotNull String user, String name) {
    this.user = user;
    this.name = name;
  }
}
