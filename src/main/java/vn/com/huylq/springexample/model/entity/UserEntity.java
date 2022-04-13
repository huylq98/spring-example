package vn.com.huylq.springexample.model.entity;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import vn.com.huylq.springexample.model.domain.User;

import javax.persistence.*;

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
