package com.wynk.follow.repository.impl;

import com.wynk.follow.entity.Following;
import com.wynk.follow.repository.FollowingRepo;
import com.wynk.follow.utils.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
  public boolean create(@NotNull String userId, @NotEmpty Set<String> artistIds) {
    List<Following> newFollowings =
        artistIds.stream()
            .map(artist -> new Following(userId, artist))
            .collect(Collectors.toList());
    // TODO check following doesnt already exist
    followings.addAll(newFollowings);
    return true;
  }

  @Override
  public boolean delete(@NotNull String userId, @NotEmpty Set<String> artistIds) {
    Set<String> artistSet = new HashSet<>(artistIds);

    List<Following> unfollowed =
        followings.stream()
            .filter(it -> it.getUserId().equals(userId) && artistSet.contains(it.getArtistId()))
            .collect(Collectors.toList());

    followings.removeAll(unfollowed);
    return true;
  }

  @Override
  public Set<String> followers(@NotNull String artistId) {
    return followings.stream()
        .filter(it -> it.getArtistId().equals(artistId))
        .map(Following::getUserId)
        .collect(Collectors.toSet());
  }

  @Override
  public Set<String> following(@NotNull String userId) {
    return followings.stream()
        .filter(it -> it.getUserId().equals(userId))
        .map(Following::getArtistId)
        .collect(Collectors.toSet());
  }

  @Override
  public Optional<String> mostPopularArtist() {
    Map<String, Long> followedArtists =
        followings.stream()
            .collect(Collectors.groupingBy(Following::getArtistId, Collectors.counting()));

    return CollectionUtils.getMaxEntry(followedArtists);
  }

  @Override
  public long followerCount(@NotNull String artistId) {
    return followings.stream().filter(it -> it.getArtistId().equals(artistId)).count();
  }
}
