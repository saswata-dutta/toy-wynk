package com.wynk.follow.repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface PublicationRepo {
  boolean create(@NotNull String songId, @NotEmpty List<String> artistIds);
}
