package com.polytech.di4.chatroom.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The Class UserServiceImpl.
 */
@Service
class UserServiceImpl implements UserService {

  /** The repository. */
  @Autowired
  private UserRepository repository;

  /** The password encoder. */
  @Autowired
  private PasswordEncoder passwordEncoder;

  /*
   * (non-Javadoc)
   *
   * @see
   * org.projectsforge.courses.spring.users.UserService#createUser(java.lang.
   * String, java.lang.String, java.lang.String, java.lang.String,
   * org.projectsforge.courses.spring.users.Role)
   */
  @Override
  public void createUser(String username, String name, String email, String password, Role role) {
    User user = new User();
    user.setUsername(username);
    user.setName(name);
    user.setEmail(email);
    user.setEncryptedPassword(passwordEncoder.encode(password));
    user.setRole(role);
    save(user);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.projectsforge.courses.spring.users.UserService#delete(org.projectsforge
   * .courses.spring.users.User)
   */
  @Override
  public void delete(User user) {
    repository.delete(user);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.projectsforge.courses.spring.users.UserService#findByEmail(java.lang.
   * String)
   */
  @Override
  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.projectsforge.courses.spring.users.UserService#findByUsername(java.lang
   * .String)
   */
  @Override
  public Optional<User> findByUsername(String username) {
    return repository.findByUsername(username);
  }

  /*
   * (non-Javadoc)
   *
   * @see org.projectsforge.courses.spring.users.UserService#getAllUsers()
   */
  @Override
  public List<User> getAllUsers() {
    return repository.findAll();
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.projectsforge.courses.spring.users.UserService#save(org.projectsforge.
   * courses.spring.users.User)
   */
  @Override
  public User save(User user) {
    return repository.save(user);
  }

  @Override
  public void update(User user) {
    // TODO Auto-generated method stub
    repository.saveAndFlush(user);
  }
}
