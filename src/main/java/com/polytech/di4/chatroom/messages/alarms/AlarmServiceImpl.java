package com.polytech.di4.chatroom.messages.alarms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
@Service
public class AlarmServiceImpl implements AlarmService {

  @Autowired
  AlarmRepository repository;

  @Override
  public void create(String type, User user, Room associatedRoom, User associatedUser) {
    // TODO Auto-generated method stub
    Alarm alarm = new Alarm();
    alarm.setType(type);
    alarm.setUser(user);
    alarm.setAssociatedRoom(associatedRoom);
    alarm.setAssociatedUser(associatedUser);
    repository.save(alarm);
  }

  @Override
  public void delete(Alarm alarm) {
    // TODO Auto-generated method stub
    repository.delete(alarm);
  }

  @Override
  public List<Alarm> findByUserId(long id) {
    // TODO Auto-generated method stub
    return repository.findByUserId(id);
  }

  @Override
  public List<Alarm> getAll() {
    // TODO Auto-generated method stub
    return repository.findAll();
  }

  @Override
  public Alarm save(Alarm alarm) {
    // TODO Auto-generated method stub
    return repository.save(alarm);
  }

}
