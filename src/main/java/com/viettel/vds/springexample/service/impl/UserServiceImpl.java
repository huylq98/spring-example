package com.viettel.vds.springexample.service.impl;

import com.viettel.vds.springexample.mapper.UserMapper;
import com.viettel.vds.springexample.model.domain.User;
import com.viettel.vds.springexample.repository.UserRepository;
import com.viettel.vds.springexample.service.UserService;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public User get(Long id) {
    if (!userRepository.existsById(id)) {
      throw new NoSuchElementException(String.format("User{id=%d} not found!", id));
    }
    return userRepository.getById(id);
  }

  @Override
  public User create(User user) {
    if (userRepository.existsByName(user.getName())) {
      throw new IllegalArgumentException(
          String.format("User{name=%s} already existed!", user.getName()));
    }
    return userRepository.save(userMapper.domainToEntity(user));
  }
}
