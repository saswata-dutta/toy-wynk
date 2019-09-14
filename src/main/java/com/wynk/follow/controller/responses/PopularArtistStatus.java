package com.wynk.follow.controller.responses;

public class PopularArtistStatus {
  private String artist;

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public PopularArtistStatus(String artist) {
    this.artist = artist;
  }
}
