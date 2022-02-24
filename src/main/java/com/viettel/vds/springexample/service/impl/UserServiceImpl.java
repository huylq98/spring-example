package com.viettel.vds.springexample.service.impl;

import com.viettel.vds.springexample.domain.User;
import com.viettel.vds.springexample.mapper.UserMapper;
import com.viettel.vds.springexample.repository.UserRepository;
import com.viettel.vds.springexample.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User get(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException(String.format("User{id=%d} not found!", id));
        }
        return userRepository.getOne(id);
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
