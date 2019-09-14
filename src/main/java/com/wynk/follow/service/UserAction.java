package com.wynk.follow.service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public interface UserAction {
  boolean create(@NotNull String userId, String name);

  boolean follow(@NotNull String userId, @NotEmpty Set<String> artistIds);

  boolean unfollow(@NotNull String userId, @NotEmpty Set<String> artistIds);

  Set<String> playlist(@NotNull String userId);
}
