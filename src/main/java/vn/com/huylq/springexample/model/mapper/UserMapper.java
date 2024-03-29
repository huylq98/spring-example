package vn.com.huylq.springexample.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.huylq.springexample.model.domain.User;
import vn.com.huylq.springexample.model.dto.request.UserRequest;
import vn.com.huylq.springexample.model.dto.response.UserResponse;
import vn.com.huylq.springexample.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "request.username", target = "name")
    @Mapping(target = "id", ignore = true)
    User UserRequestToUser(UserRequest request);

    @Mapping(source = "user.name", target = "username")
    UserResponse UserToUserResponse(User user);

    UserEntity UserToUserEntity(User user);

    @InheritInverseConfiguration
    User UserEntityToUser(UserEntity UserEntity);
}
