package vn.com.huylq.springexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.com.huylq.springexample.model.dto.request.UserRequest;
import vn.com.huylq.springexample.model.dto.response.UserResponse;
import vn.com.huylq.springexample.model.mapper.UserMapper;
import vn.com.huylq.springexample.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("${spring.application.name}/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

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
