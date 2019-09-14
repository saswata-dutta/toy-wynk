package com.wynk.follow.repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public interface PublicationRepo {
  boolean create(@NotNull String songId, @NotEmpty Set<String> artistIds);

  Set<String> songs(@NotNull String artistId);

  Set<String> artists(@NotNull String songId);
}
