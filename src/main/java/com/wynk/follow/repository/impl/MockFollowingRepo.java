package com.wynk.follow.repository.impl;

import com.wynk.follow.entity.Following;
import com.wynk.follow.repository.FollowingRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MockFollowingRepo implements FollowingRepo {
  private List<Following> followings;

  @PostConstruct
  private void init() {
    followings = new ArrayList<Following>();
  }

  @Override
  public boolean create(@NotNull String userId, @NotEmpty List<String> artistIds) {
    List<Following> newFollowings =
        artistIds.stream()
            .map(artist -> new Following(userId, artist))
            .collect(Collectors.toList());

    followings.addAll(newFollowings);
    return true;
  }

  @Override
  public boolean delete(@NotNull String userId, @NotEmpty List<String> artistIds) {
    Set<String> artistSet = new HashSet<>(artistIds);

    List<Following> unfollowed =
        followings.stream()
            .filter(it -> it.getUserId().equals(userId) && artistSet.contains(it.getArtistId()))
            .collect(Collectors.toList());

    followings.removeAll(unfollowed);
    return true;
  }
}
