package com.wynk.follow.entity;

public class Following {
  private String userId;
  private String artistId;

  public String getUserId() {
    return userId;
  }

  public String getArtistId() {
    return artistId;
  }

  public Following(String userId, String artistId) {
    this.userId = userId;
    this.artistId = artistId;
  }
}
