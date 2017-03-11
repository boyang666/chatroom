package com.polytech.di4.chatroom.users;

import java.util.List;
import java.util.Optional;

/**
 * The Interface UserService.
 */
public interface UserService {

  /**
   * Creates the user.
   *
   * @param username
   *          the username
   * @param name
   *          the name
   * @param email
   *          the email
   * @param password
   *          the password
   * @param role
   *          the role
   */
  void createUser(String username, String name, String email, String password, Role role);

  /**
   * Delete.
   *
   * @param user
   *          the user
   */
  void delete(User user);

  /**
   * Find by email.
   *
   * @param email
   *          the email
   * @return the optional
   */
  Optional<User> findByEmail(String email);

  /**
   * Find by username.
   *
   * @param username
   *          the username
   * @return the optional
   */
  Optional<User> findByUsername(String username);

  /**
   * Gets the all users.
   *
   * @return the all users
   */
  List<User> getAllUsers();

  /**
   * Save.
   *
   * @param user
   *          the user
   * @return the user
   */
  User save(User user);

  /**
   * @param user
   */
  void update(User user);
}
