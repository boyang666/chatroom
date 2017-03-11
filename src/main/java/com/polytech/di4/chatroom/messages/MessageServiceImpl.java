package com.polytech.di4.chatroom.messages;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

  @Autowired
  MessageRepository messageRepository;

  @Override
  public void create(String content, User from, boolean isPublic, Room targetRoom, User targetUser) {
    // TODO Auto-generated method stub
    Message message = new Message();
    message.setContent(content);
    message.setFrom(from);
    message.setPublic(isPublic);
    message.setTargetRoom(targetRoom);
    message.setTargetUser(targetUser);
    message.setTime(new Date());
    messageRepository.save(message);
  }

  @Override
  public void delete(Message message) {
    // TODO Auto-generated method stub

  }

  @Override
  public Optional<Message> findById() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Message> getAllMessages() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Message save(Message message) {
    // TODO Auto-generated method stub
    return null;
  }

}
