package com.wynk.follow.service.impl;

import com.wynk.follow.entity.User;
import com.wynk.follow.repository.UserRepo;
import com.wynk.follow.service.UserAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserActionImpl implements UserAction {
  Logger logger = LoggerFactory.getLogger(UserActionImpl.class);

  @Autowired private UserRepo userRepo;

  @Override
  public boolean create(@NotNull String userId, String name) {
    User user = new User(userId, name);
    return userRepo.create(user);
  }
}
