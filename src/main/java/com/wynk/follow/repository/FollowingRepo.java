package com.wynk.follow.repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

public interface FollowingRepo {
  boolean create(@NotNull String userId, @NotEmpty Set<String> artistIds);

  boolean delete(@NotNull String userId, @NotEmpty Set<String> artistIds);

  Set<String> followers(@NotNull String artistId);

  Set<String> following(@NotNull String userId);

  Optional<String> mostPopularArtist();

  long followerCount(@NotNull String artistId);

  Set<String> getAllUsers();

}
