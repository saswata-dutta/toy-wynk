package com.wynk.follow.repository;

import com.wynk.follow.entity.User;

import javax.validation.constraints.NotNull;
import java.util.Set;

public interface UserRepo {
  boolean create(@NotNull User user);
  Set<String> getAll();
}
