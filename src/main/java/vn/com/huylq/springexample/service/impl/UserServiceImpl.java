package vn.com.huylq.springexample.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.huylq.springexample.model.domain.User;
import vn.com.huylq.springexample.model.entity.UserEntity;
import vn.com.huylq.springexample.model.mapper.UserMapper;
import vn.com.huylq.springexample.repository.UserRepository;
import vn.com.huylq.springexample.service.UserService;

import javax.transaction.Transactional;
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
    public Page<User> getAll(Pageable pageable) {
        Page<UserEntity> userEntities = userRepository.findAll(pageable);
        return new PageImpl<>(
                userEntities.stream().map(userMapper::UserEntityToUser).collect(Collectors.toList()),
                pageable,
                userEntities.getTotalElements());
    }

    @Cacheable(cacheNames = "users", key = "#id")
    @Override
    public User get(Long id) {
        log.info("Cache miss for key {}", id);
        return userRepository.findById(id)
                             .orElseThrow(
                                     () -> new NoSuchElementException(String.format("User{id=%d} not found!", id)));
    }

    @CachePut(cacheNames = "users", key = "#result.id")
    @Override
    public User create(User user) {
        if (userRepository.existsByName(user.getName())) {
            throw new IllegalArgumentException(
                    String.format("User{name=%s} already existed!", user.getName()));
        }
        return userRepository.save(userMapper.UserToUserEntity(user));
    }

    @Override
    public User update(Long id, User user) {
        UserEntity userEntity = userRepository.findById(id)
                                              .orElseThrow(() -> new NoSuchElementException(
                                                      String.format("User{id=%d} not found!", id)));

        if (userRepository.existsByName(user.getName()) && !userEntity.getName().equals(user.getName())) {
            throw new IllegalArgumentException(String.format("User{name=%s} already existed!", user.getName()));
        }
        return userRepository.save(userMapper.UserToUserEntity(user));
    }

    @CacheEvict(cacheNames = "users", key = "#id")
    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException(String.format("User{id=%d} not found!", id));
        }
        userRepository.deleteById(id);
    }
}
