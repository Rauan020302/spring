package ru.andersen.library.service;

import ru.andersen.library.entity.User;
import ru.andersen.library.exceptions.AuthorizationException;
import ru.andersen.library.model.AuthModel;
import ru.andersen.library.model.SignUpModel;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user) throws AuthorizationException;
    User saveUser(SignUpModel signUpModel) throws AuthorizationException;
    User deleteUserById(Long id);
    User updateUserById(User user,Long id);
    AuthModel getTokenByAuthModel(AuthModel authModel);
    User findByUsername(String login);
    List<User> findAllByStatus(Long status);
}
