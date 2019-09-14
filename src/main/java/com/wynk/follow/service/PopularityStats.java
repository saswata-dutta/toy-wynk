package com.wynk.follow.service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface PopularityStats {
  Optional<String> mostPopularArtist();

  Optional<String> mostPopularSong();

  long followerCount(@NotNull String artistId);
}
