package vn.com.huylq.springexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.com.huylq.springexample.model.domain.User;
import vn.com.huylq.springexample.model.dto.request.UserRequest;
import vn.com.huylq.springexample.model.dto.response.UserResponse;
import vn.com.huylq.springexample.model.mapper.UserMapper;
import vn.com.huylq.springexample.service.UserService;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${spring.application.name}/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public Page<UserResponse> findAllUsers(Pageable pageable) {
        Page<User> users = userService.getAll(pageable);
        return new PageImpl<>(
                users.stream().map(userMapper::UserToUserResponse).collect(Collectors.toList()),
                pageable,
                users.getTotalElements()
        );
    }

    @GetMapping("/{id}")
    public UserResponse findUser(@PathVariable("id") Long id) {
        return userMapper.UserToUserResponse(userService.get(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse createUser(@RequestBody @Valid UserRequest request) {
        return userMapper.UserToUserResponse(userService.create(userMapper.UserRequestToUser(request)));
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(
            @PathVariable("id") Long id,
            @RequestBody @Valid UserRequest request
    ) {
        return userMapper.UserToUserResponse(userService.update(id, userMapper.UserRequestToUser(request)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
