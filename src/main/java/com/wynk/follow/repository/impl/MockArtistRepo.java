package com.wynk.follow.repository.impl;

import com.wynk.follow.entity.Artist;
import com.wynk.follow.repository.ArtistRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockArtistRepo implements ArtistRepo {
  Logger logger = LoggerFactory.getLogger(MockArtistRepo.class);

  private List<Artist> artists;

  @PostConstruct
  private void init() {
    artists = new ArrayList<Artist>();
  }

  @Override
  public boolean create(@NotNull Artist artist) {
    boolean notFound = artists.stream().noneMatch(it -> it.getId().equals(artist.getId()));

    if (notFound) {
      artists.add(artist);
      logger.info("Created artist {}", artist.getId());
    }

    return notFound;
  }
}
