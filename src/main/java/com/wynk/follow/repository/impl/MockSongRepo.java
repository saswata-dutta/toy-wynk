package com.wynk.follow.repository.impl;

import com.wynk.follow.entity.Song;
import com.wynk.follow.repository.SongRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockSongRepo implements SongRepo {
  Logger logger = LoggerFactory.getLogger(MockSongRepo.class);

  private List<Song> songs;

  @PostConstruct
  private void init() {
    songs = new ArrayList<Song>();
  }

  @Override
  public boolean create(@NotNull Song song) {
    boolean notFound = songs.stream().noneMatch(it -> it.getId().equals(song.getId()));

    if (notFound) {
      songs.add(song);
      logger.info("Created song {}", song.getId());
    }

    return notFound;
  }
}
