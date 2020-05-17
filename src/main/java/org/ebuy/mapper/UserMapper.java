package org.ebuy.mapper;

import org.ebuy.model.User;
import org.ebuy.model.UserRequest;
import org.mapstruct.Mapper;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequest userToUserReq(User user);

}
