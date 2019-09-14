package com.wynk.follow.controller;

import com.wynk.follow.controller.requests.CreateUser;
import com.wynk.follow.controller.requests.Follow;
import com.wynk.follow.controller.requests.PublishSong;
import com.wynk.follow.controller.requests.UnFollow;
import com.wynk.follow.controller.responses.FollowCountStatus;
import com.wynk.follow.controller.responses.FollowStatus;
import com.wynk.follow.controller.responses.PlaylistStatus;
import com.wynk.follow.controller.responses.PopularArtistStatus;
import com.wynk.follow.controller.responses.PopularSongStatus;
import com.wynk.follow.controller.responses.PublishSongStatus;
import com.wynk.follow.controller.responses.UnFollowStatus;
import com.wynk.follow.service.PopularityStats;
import com.wynk.follow.service.SongAction;
import com.wynk.follow.service.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/wynk", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WynkControls {

  @Autowired private UserAction userAction;
  @Autowired private PopularityStats popularityStats;
  @Autowired private SongAction songAction;

  @PostMapping("/create")
  public boolean create(@RequestBody @Valid CreateUser request) {
    return userAction.create(request.getUser(), request.getName());
  }

  @PostMapping("/follow")
  public @ResponseBody FollowStatus follow(@RequestBody @Valid Follow request) {
    Set<String> artistIds = new HashSet<>(request.getArtist());
    boolean result = userAction.follow(request.getUser(), artistIds);
    if (result) return new FollowStatus(request.getUser(), artistIds);
    return FollowStatus.ERROR;
  }

  @PostMapping("/unfollow")
  public @ResponseBody UnFollowStatus unfollow(@RequestBody @Valid UnFollow request) {
    Set<String> artistIds = new HashSet<>(request.getArtist());
    boolean result = userAction.unfollow(request.getUser(), artistIds);
    if (result) return new UnFollowStatus(request.getUser(), artistIds);
    return UnFollowStatus.ERROR;
  }

  @PostMapping("/publish")
  public @ResponseBody PublishSongStatus publishSong(@RequestBody @Valid PublishSong request) {
    boolean result = songAction.publish(request.getSong(), request.getArtists());
    if (result) return new PublishSongStatus("ok", "song published against artists");
    return new PublishSongStatus("failed", "invalid input parameters");
  }

  @GetMapping("/playlist")
  public @ResponseBody PlaylistStatus playlist(@RequestParam("user") @NotEmpty String userId) {
    Set<String> songs = userAction.playlist(userId);
    return new PlaylistStatus(songs);
  }

  @GetMapping("/popular/song")
  public @ResponseBody PopularSongStatus popularSong() {
    Optional<String> song = popularityStats.mostPopularSong();
    return new PopularSongStatus(song.orElse(""));
  }

  @GetMapping("/popular/artist")
  public @ResponseBody PopularArtistStatus popularArtist() {
    Optional<String> artist = popularityStats.mostPopularArtist();
    return new PopularArtistStatus(artist.orElse(""));
  }

  @GetMapping("/follow/count")
  public @ResponseBody FollowCountStatus followCount(
      @RequestParam("artist") @NotEmpty String artistId) {
    long count = popularityStats.followerCount(artistId);
    return new FollowCountStatus(artistId, count);
  }
}
