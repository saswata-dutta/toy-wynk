package com.wynk.follow.entity;

public class Artist {
  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Artist(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
