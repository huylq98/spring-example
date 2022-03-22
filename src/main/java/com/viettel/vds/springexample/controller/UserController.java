package com.viettel.vds.springexample.controller;

import com.viettel.vds.springexample.mapper.UserMapper;
import com.viettel.vds.springexample.model.dto.request.UserRequest;
import com.viettel.vds.springexample.model.dto.response.UserResponse;
import com.viettel.vds.springexample.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserMapper userMapper;

  @GetMapping("/{id}")
  public UserResponse get(@PathVariable("id") Long id) {
    return userMapper.domainToResponse(userService.get(id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public UserResponse create(@RequestBody @Valid UserRequest request) {
    return userMapper.domainToResponse(userService.create(userMapper.requestToDomain(request)));
  }
}
