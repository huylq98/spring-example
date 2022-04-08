package vn.com.huylq.springexample.service;

import vn.com.huylq.springexample.model.domain.User;

public interface UserService {

    User get(Long id);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);
}