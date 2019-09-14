package com.wynk.follow.entity;

public class Publication {
  private String artistId;
  private String songId;

  public String getArtistId() {
    return artistId;
  }

  public String getSongId() {
    return songId;
  }

  public Publication(String artistId, String songId) {
    this.artistId = artistId;
    this.songId = songId;
  }
}
