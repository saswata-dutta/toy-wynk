package com.wynk.follow.repository.impl;

import com.wynk.follow.entity.User;
import com.wynk.follow.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MockUserRepo implements UserRepo {
  Logger logger = LoggerFactory.getLogger(MockUserRepo.class);

  private List<User> users;

  @PostConstruct
  private void init() {
    users = new ArrayList<User>();
  }

  @Override
  public boolean create(@NotNull User user) {
    boolean notFound = users.stream().noneMatch(it -> it.getId().equals(user.getId()));

    if (notFound) {
      users.add(user);
      logger.info("Created user {}", user.getId());
    }

    return notFound;
  }

  @Override
  public Set<String> getAll() {
    return users.stream().map(User::getId).collect(Collectors.toSet());
  }
}
