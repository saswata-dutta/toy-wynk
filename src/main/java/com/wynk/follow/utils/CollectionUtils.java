package com.wynk.follow.utils;

import java.util.Map;
import java.util.Optional;

public class CollectionUtils {
  public static Optional<String> getMaxEntry(Map<String, Long> items) {
    Map.Entry<String, Long> maxEntry = null;

    for (Map.Entry<String, Long> entry : items.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }

    if (maxEntry == null) return Optional.empty();
    else return Optional.of(maxEntry.getKey());
  }
}
