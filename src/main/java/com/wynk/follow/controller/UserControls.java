package com.wynk.follow.controller;

import com.wynk.follow.controller.requests.CreateUser;
import com.wynk.follow.controller.requests.Follow;
import com.wynk.follow.controller.requests.UnFollow;
import com.wynk.follow.controller.responses.FollowStatus;
import com.wynk.follow.controller.responses.UnFollowStatus;
import com.wynk.follow.service.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/wynk", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserControls {

  @Autowired private UserAction userAction;

  @PostMapping("/create")
  public boolean create(@RequestBody @Valid CreateUser request) {
    return userAction.create(request.getUser(), request.getName());
  }

  @PostMapping("/follow")
  public FollowStatus follow(@RequestBody @Valid Follow request) {
    Set<String> artistIds = new HashSet<>(request.getArtist());
    boolean result = userAction.follow(request.getUser(), artistIds);
    if (result) return new FollowStatus(request.getUser(), artistIds);
    return FollowStatus.ERROR;
  }

  @PostMapping("/unfollow")
  public UnFollowStatus unfollow(@RequestBody @Valid UnFollow request) {
    Set<String> artistIds = new HashSet<>(request.getArtist());
    boolean result = userAction.unfollow(request.getUser(), artistIds);
    if (result) return new UnFollowStatus(request.getUser(), artistIds);
    return UnFollowStatus.ERROR;
  }
}
