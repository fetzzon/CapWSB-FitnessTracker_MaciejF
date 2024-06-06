package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUser(Long userId);

    User updateUser(Long userId, User user);

    boolean deleteUser(Long userId);

    List<User> searchUsersByEmail(String email);

    List<User> searchUsersByAge(int age);

    List<User> findAllUsers();

    List<User> findUsersOlderThanAge(int age);
}
