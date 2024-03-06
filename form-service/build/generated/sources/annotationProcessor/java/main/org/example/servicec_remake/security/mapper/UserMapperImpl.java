package org.example.servicec_remake.security.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.servicec_remake.security.model.Role;
import org.example.servicec_remake.security.model.User;
import org.example.servicec_remake.security.repository.UserDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T16:27:33+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertUserDocument(UserDocument userDocument) {
        if ( userDocument == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDocument.getId() );
        user.username( userDocument.getUsername() );
        user.password( userDocument.getPassword() );
        List<Role> list = userDocument.getRoles();
        if ( list != null ) {
            user.roles( new ArrayList<Role>( list ) );
        }

        return user.build();
    }

    @Override
    public UserDocument convertUserToUserDocument(User user) {
        if ( user == null ) {
            return null;
        }

        UserDocument.UserDocumentBuilder userDocument = UserDocument.builder();

        userDocument.id( user.getId() );
        userDocument.username( user.getUsername() );
        userDocument.password( user.getPassword() );
        List<Role> list = user.getRoles();
        if ( list != null ) {
            userDocument.roles( new ArrayList<Role>( list ) );
        }

        return userDocument.build();
    }
}
