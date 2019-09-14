package com.wynk.follow.controller.responses;

public class PopularSongStatus {
  private String song;

  public String getSong() {
    return song;
  }

  public void setSong(String song) {
    this.song = song;
  }

  public PopularSongStatus(String song) {
    this.song = song;
  }
}
