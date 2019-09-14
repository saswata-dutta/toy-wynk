package com.wynk.follow.controller.responses;

import java.util.Set;

public class PlaylistStatus {
  private Set<String> songs;

  public PlaylistStatus(Set<String> songs) {
    this.songs = songs;
  }

  public Set<String> getSongs() {
    return songs;
  }

  public void setSongs(Set<String> songs) {
    this.songs = songs;
  }
}
