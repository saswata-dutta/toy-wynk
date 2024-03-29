package com.wynk.follow.service.impl;

import com.wynk.follow.repository.FollowingRepo;
import com.wynk.follow.repository.UserRepo;
import com.wynk.follow.service.PopularityStats;
import com.wynk.follow.service.UserAction;
import com.wynk.follow.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PopularityStatsImpl implements PopularityStats {
  Logger logger = LoggerFactory.getLogger(PopularityStatsImpl.class);

  @Autowired private FollowingRepo followingRepo;
  @Autowired private UserRepo userRepo;
  @Autowired private UserAction userAction;

  @Override
  public Optional<String> mostPopularArtist() {
    return followingRepo.mostPopularArtist();
  }

  @Override
  public Optional<String> mostPopularSong() {
    Set<String> users = followingRepo.getAllUsers();
    logger.info("found {} users", users.size());

    Map<String, Long> songCounts =
        users.stream()
            .flatMap(user -> userAction.playlist(user).stream())
            .collect(Collectors.groupingBy(it -> it, Collectors.counting()));

    logger.info("found {} songs", songCounts.size());
    return CollectionUtils.getMaxEntry(songCounts);
  }

  @Override
  public long followerCount(@NotNull String artistId) {
    return followingRepo.followerCount(artistId);
  }
}
