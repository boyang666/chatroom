package com.polytech.di4.chatroom.messages;

import java.util.List;
import java.util.Optional;

import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
public interface MessageService {

  /**
   * @param content
   * @param from
   * @param isPublic
   * @param targetRoom
   * @param targetUser
   */
  public void create(String content, User from, boolean isPublic, Room targetRoom, User targetUser);

  /**
   * @param message
   */
  public void delete(Message message);

  /**
   * @return message
   */
  public Optional<Message> findById();

  /**
   * @return all messages
   */
  public List<Message> getAllMessages();

  /**
   * @param message
   * @return message
   */
  public Message save(Message message);
}
