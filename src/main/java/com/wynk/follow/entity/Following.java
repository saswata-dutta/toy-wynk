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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Following following = (Following) o;

    if (!userId.equals(following.userId)) return false;
    return artistId.equals(following.artistId);
  }

  @Override
  public int hashCode() {
    int result = userId.hashCode();
    result = 31 * result + artistId.hashCode();
    return result;
  }
}
