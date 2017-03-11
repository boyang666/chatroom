package com.polytech.di4.chatroom.rooms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

  /**
   * @param name
   * @param host
   * @return room found
   */
  Optional<Room> findByNameAndHost(String name, User host);

}
