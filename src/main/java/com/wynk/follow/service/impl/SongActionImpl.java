package com.wynk.follow.service.impl;

import com.wynk.follow.repository.PublicationRepo;
import com.wynk.follow.service.SongAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class SongActionImpl implements SongAction {
  @Autowired private PublicationRepo publicationRepo;

  @Override
  public boolean create(@NotNull String songId, String name) {
    // TODO
    return false;
  }

  @Override
  public boolean publish(@NotNull String songId, @NotEmpty List<String> artistIds) {
    return publicationRepo.create(songId, artistIds);
  }
}
