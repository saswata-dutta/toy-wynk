package com.wynk.follow.controller.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UnFollow {
  @NotNull private String user;
  @NotEmpty private List<String> artist;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public List<String> getArtist() {
    return artist;
  }

  public void setArtist(List<String> artist) {
    this.artist = artist;
  }

  public UnFollow(String user, List<String> artist) {
    this.user = user;
    this.artist = artist;
  }
}
