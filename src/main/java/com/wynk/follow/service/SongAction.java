package com.wynk.follow.service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public interface SongAction {
  boolean create(@NotNull String songId, String name);
  boolean publish(@NotNull String songId, @NotEmpty Set<String> artistIds);
}
