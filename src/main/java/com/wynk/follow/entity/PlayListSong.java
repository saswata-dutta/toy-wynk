package com.wynk.follow.entity;

public class PlayListSong {
  private String playlistId;
  private String songId;

  public PlayListSong(String playlistId, String songId) {
    this.playlistId = playlistId;
    this.songId = songId;
  }

  public String getPlaylistId() {
    return playlistId;
  }

  public String getSongId() {
    return songId;
  }
}
