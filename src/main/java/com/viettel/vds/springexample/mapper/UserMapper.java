package com.viettel.vds.springexample.mapper;

import com.viettel.vds.springexample.domain.User;
import com.viettel.vds.springexample.dto.request.UserRequest;
import com.viettel.vds.springexample.dto.response.UserResponse;
import com.viettel.vds.springexample.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "request.username", target = "name")
    @Mapping(target = "id", ignore = true)
    User requestToDomain(UserRequest request);

    @Mapping(source = "user.name", target = "username")
    UserResponse domainToResponse(User user);

    UserEntity domainToEntity(User user);

    User entityToDomain(UserEntity userEntity);
}
