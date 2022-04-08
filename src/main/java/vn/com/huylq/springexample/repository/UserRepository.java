package vn.com.huylq.springexample.repository;

import vn.com.huylq.springexample.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  boolean existsByName(@NonNull String name);
}
