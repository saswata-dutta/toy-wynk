package com.wynk.follow.service;

import javax.validation.constraints.NotNull;

public interface ArtistAction {
  boolean create(@NotNull String artistId, String name);
}
