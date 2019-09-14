package com.wynk.follow.repository;

import com.wynk.follow.entity.User;

import javax.validation.constraints.NotNull;

public interface UserRepo {
  boolean create(@NotNull User user);
}
