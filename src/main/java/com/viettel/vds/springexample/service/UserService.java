package com.viettel.vds.springexample.service;

import com.viettel.vds.springexample.model.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User get(Long id);

    User create(User user);

}