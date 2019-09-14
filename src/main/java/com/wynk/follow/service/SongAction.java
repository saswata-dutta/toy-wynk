package com.wynk.follow.service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SongAction {
  boolean create(@NotNull String songId, String name);
  boolean publish(@NotNull String songId, @NotEmpty List<String> artistIds);
}
