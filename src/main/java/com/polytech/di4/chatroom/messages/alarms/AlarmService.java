package com.polytech.di4.chatroom.messages.alarms;

import java.util.List;

import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
public interface AlarmService {

  /**
   * @param type
   * @param user
   * @param associatedRoom
   * @param associatedUser
   */
  void create(String type, User user, Room associatedRoom, User associatedUser);

  /**
   * @param alarm
   *
   */
  void delete(Alarm alarm);

  /**
   * @param id
   * @return alarm
   */
  List<Alarm> findByUserId(long id);

  /**
   * @return list of alarms
   */
  List<Alarm> getAll();

  /**
   * @param alarm
   * @return alarm
   */
  Alarm save(Alarm alarm);
}
