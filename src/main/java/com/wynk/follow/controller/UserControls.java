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
    return FollowStatus.ERROR;
  }

  @PostMapping("/unfollow")
  public UnFollowStatus unfollow(@RequestBody @Valid UnFollow request) {
    return UnFollowStatus.ERROR;
  }
}
