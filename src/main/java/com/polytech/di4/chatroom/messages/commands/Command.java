package com.polytech.di4.chatroom.messages.commands;

import com.polytech.di4.chatroom.messages.Message;

/**
 * @author Boyang Wang
 *
 */
public interface Command {

  /**
   * @param message
   * @return result
   */
  public String execute(Message message);
}
