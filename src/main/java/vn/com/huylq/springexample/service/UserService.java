package vn.com.huylq.springexample.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.com.huylq.springexample.model.domain.User;

public interface UserService {

    Page<User> getAll(Pageable pageable);

    User get(Long id);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);
}