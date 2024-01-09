package org.example.servicec_remake.security.mapper;


import org.example.servicec_remake.security.model.User;
import org.example.servicec_remake.security.repository.UserDocument;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User convertUserDocument(UserDocument userDocument);

    UserDocument convertUserToUserDocument(User user);

}
