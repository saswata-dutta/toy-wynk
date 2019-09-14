package com.wynk.follow.controller.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class PublishSong {

  @NotNull private String song;
  @NotEmpty private Set<String> artists;

  public PublishSong(@NotNull String song, @NotEmpty Set<String> artists) {
    this.song = song;
    this.artists = artists;
  }

  public String getSong() {
    return song;
  }

  public void setSong(String song) {
    this.song = song;
  }

  public Set<String> getArtists() {
    return artists;
  }

  public void setArtists(Set<String> artists) {
    this.artists = artists;
  }
}
