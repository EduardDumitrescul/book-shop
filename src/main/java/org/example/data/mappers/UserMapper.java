package org.example.data.mappers;

import org.example.data.entities.UserEntity;
import org.example.data.models.User;

public class UserMapper {
    private UserMapper() {}

    public static User asUser(UserEntity entity) {
        return new User(
                entity.id,
                entity.username,
                entity.password
        );
    }

    public static UserEntity asEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
