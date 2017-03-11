package com.polytech.di4.chatroom.users;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polytech.di4.chatroom.messages.MessageService;
import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.rooms.RoomService;

/**
 * The Class AdminUserPopulator.
 */
@Component
class AdminUserAndWorldRoomPopulator {

  /** The user service. */
  @Autowired
  private UserService userService;

  @Autowired
  private RoomService roomService;

  @Autowired
  private MessageService messageService;

  /**
   * Initials
   */
  @PostConstruct
  public void init() {

    if (!userService.findByUsername("admin").isPresent()) {
      // we create the default admin account if it didn't exist
      userService.createUser("admin", "Administrator", "admin@localhost", "password", Role.ADMIN);
    }

    User hostOfWorld = userService.findByUsername("admin").get();
    if (!roomService.findByNameAndHost("World Channel", hostOfWorld).isPresent()) {
      roomService.create("World Channel", false, null, hostOfWorld);
    }

    Room worldChannel = roomService.findByNameAndHost("World Channel", hostOfWorld).get();

    messageService.create("test message", hostOfWorld, true, worldChannel, null);
  }
}
