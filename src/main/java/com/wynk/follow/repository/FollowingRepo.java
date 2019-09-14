package com.wynk.follow.repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface FollowingRepo {
  boolean create(@NotNull String userId, @NotEmpty List<String> artistIds);
  boolean delete(@NotNull String userId, @NotEmpty List<String> artistIds);
}
