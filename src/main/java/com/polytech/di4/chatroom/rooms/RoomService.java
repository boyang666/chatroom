package com.polytech.di4.chatroom.rooms;

import java.util.List;
import java.util.Optional;

import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
public interface RoomService {

  /**
   * @param name
   * @param hasPassword
   * @param password
   * @param host
   */
  public void create(String name, boolean hasPassword, String password, User host);

  /**
   * @param room
   */
  public void delete(Room room);

  /**
   * @param id
   * @return room found
   */
  public Room findById(long id);

  /**
   * @param name
   * @param host
   * @return room found
   */
  public Optional<Room> findByNameAndHost(String name, User host);

  /**
   * @return list of rooms
   */
  public List<Room> getAllRooms();

  /**
   * @param room
   * @return room saved
   */
  public Room save(Room room);

  /**
   * @param room
   */
  void update(Room room);

}
