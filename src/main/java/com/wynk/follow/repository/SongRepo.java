package com.wynk.follow.repository;

import com.wynk.follow.entity.Song;

import javax.validation.constraints.NotNull;

public interface SongRepo {
  boolean create(@NotNull Song song);
}
