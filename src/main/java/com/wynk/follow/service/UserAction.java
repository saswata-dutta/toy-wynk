package com.wynk.follow.service;

import javax.validation.constraints.NotNull;

public interface UserAction {
  boolean create(@NotNull String userId, String name);
}
