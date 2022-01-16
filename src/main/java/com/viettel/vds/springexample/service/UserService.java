package com.viettel.vds.springexample.service;

import com.viettel.vds.springexample.domain.User;

public interface UserService {

  User get(Long id);

  User create(User user);

}