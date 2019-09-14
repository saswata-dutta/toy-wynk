package com.wynk.follow.service.impl;

import com.wynk.follow.entity.User;
import com.wynk.follow.repository.FollowingRepo;
import com.wynk.follow.repository.PublicationRepo;
import com.wynk.follow.repository.UserRepo;
import com.wynk.follow.service.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserActionImpl implements UserAction {

  @Autowired private UserRepo userRepo;
  @Autowired private FollowingRepo followingRepo;
  @Autowired private PublicationRepo publicationRepo;

  @Override
  public boolean create(@NotNull String userId, String name) {
    User user = new User(userId, name);
    return userRepo.create(user);
  }

  @Override
  public boolean follow(@NotNull String userId, @NotEmpty Set<String> artistIds) {
    // TODO ensure foreign key constraints
    return followingRepo.create(userId, artistIds);
  }

  @Override
  public boolean unfollow(@NotNull String userId, @NotEmpty Set<String> artistIds) {
    // TODO ensure foreign key constraints
    return followingRepo.delete(userId, artistIds);
  }

  @Override
  public Set<String> playlist(@NotNull String userId) {
    Set<String> artistIds = followingRepo.following(userId);
    return artistIds.stream()
        .flatMap(artist -> publicationRepo.songs(artist).stream())
        .collect(Collectors.toSet());
  }
}
