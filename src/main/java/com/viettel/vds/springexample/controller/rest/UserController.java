package com.viettel.vds.springexample.controller.rest;

import com.viettel.vds.springexample.dto.request.UserRequest;
import com.viettel.vds.springexample.dto.response.UserResponse;
import com.viettel.vds.springexample.mapper.UserMapper;
import com.viettel.vds.springexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${spring.application.name}/public/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll()
                .stream()
                .map(userMapper::domainToResponse)
                .collect(Collectors.toList());
    }

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
