package com.viettel.vds.springexample.repository;

import com.viettel.vds.springexample.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  boolean existsByName(@NonNull String name);
}
