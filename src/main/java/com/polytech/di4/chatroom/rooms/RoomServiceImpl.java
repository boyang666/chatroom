package com.polytech.di4.chatroom.rooms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  private RoomRepository roomRepository;

  @Override
  public void create(String name, boolean hasPassword, String password, User host) {
    Room room = new Room();
    room.setName(name);
    room.setPasswordEnabled(hasPassword);
    room.setPassword(password);
    room.setHost(host);
    save(room);
  }

  @Override
  public void delete(Room room) {
    // TODO Auto-generated method stub
    roomRepository.delete(room);
  }

  @Override
  public Room findById(long id) {
    // TODO Auto-generated method stub
    return roomRepository.findOne(id);
  }

  @Override
  public Optional<Room> findByNameAndHost(String name, User host) {
    // TODO Auto-generated method stub
    return roomRepository.findByNameAndHost(name, host);
  }

  @Override
  public List<Room> getAllRooms() {
    // TODO Auto-generated method stub
    return roomRepository.findAll();
  }

  @Override
  public Room save(Room room) {
    // TODO Auto-generated method stub
    return roomRepository.save(room);
  }

  @Override
  public void update(Room room) {
    // TODO Auto-generated method stub
    roomRepository.saveAndFlush(room);
  }

}
