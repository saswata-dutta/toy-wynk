package com.wynk.follow.repository.impl;

import com.wynk.follow.entity.Publication;
import com.wynk.follow.repository.PublicationRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockPublicationRepo implements PublicationRepo {
  private List<Publication> publications;

  @PostConstruct
  private void init() {
    publications = new ArrayList<Publication>();
  }

  @Override
  public boolean create(@NotNull String songId, @NotEmpty List<String> artistIds) {
    List<Publication> newPublications =
        artistIds.stream()
            .map(artist -> new Publication(artist, songId))
            .collect(Collectors.toList());

    publications.addAll(newPublications);
    return true;
  }
}
