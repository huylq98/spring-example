package com.viettel.vds.springexample.model.entity;

import com.viettel.vds.springexample.model.domain.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user")
@NoArgsConstructor
@SuperBuilder
public class UserEntity extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Override
  public Long getId() {
    return super.getId();
  }

  @Column(name = "name", length = 50)
  @Override
  public String getName() {
    return super.getName();
  }
}
