package com.wynk.follow.entity;

public class PlayList {
  private String id;
  private String name;
  private String userId;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public PlayList(String id, String name, String userId) {
    this.id = id;
    this.name = name;
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }
}
