package com.wynk.follow.repository;

import com.wynk.follow.entity.Artist;

import javax.validation.constraints.NotNull;

public interface ArtistRepo {
  boolean create(@NotNull Artist artist);
}
