package com.wynk.follow.controller.responses;

public class FollowCountStatus {
  private String artist;
  private Long count;

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public FollowCountStatus(String artist, Long count) {
    this.artist = artist;
    this.count = count;
  }
}
