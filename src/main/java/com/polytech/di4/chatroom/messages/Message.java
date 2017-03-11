package com.polytech.di4.chatroom.messages;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.polytech.di4.chatroom.messages.commands.ChangePWCommand;
import com.polytech.di4.chatroom.messages.commands.Command;
import com.polytech.di4.chatroom.messages.commands.LogoutCommand;
import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
@Entity
public class Message {

  @Id
  @GeneratedValue
  private long id;

  private String content;

  @Temporal(TemporalType.TIMESTAMP)
  private Date time;

  @ManyToOne
  private User from;

  private boolean isPublic;

  @ManyToOne
  @JoinColumn(columnDefinition = "integer", name = "targetRoom_id")
  private Room targetRoom;

  @ManyToOne
  @JoinColumn(columnDefinition = "integer", name = "targetUser_id")
  private User targetUser;

  @Transient
  private Command command;

  /**
   *
   */
  public Message() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param content
   * @param time
   * @param from
   * @param isPublic
   * @param targetRoom
   * @param targetUser
   */
  public Message(String content, Date time, User from, boolean isPublic, Room targetRoom, User targetUser) {
    super();
    this.content = content;
    this.time = time;
    this.from = from;
    this.isPublic = isPublic;
    this.targetRoom = targetRoom;
    this.targetUser = targetUser;
  }

  /**
   * @return true if contain command
   */
  public boolean containsCommand() {
    if (content.startsWith("/")) {
      return true;
    }
    return false;
  }

  /**
   * @return execute the command
   */
  public String executeCommand() {
    return command.execute(this);
  }

  /**
   *
   */
  public void generateCommand() {
    String[] messageParsed = content.split(" ");
    if (messageParsed.length != 0) {
      String type = messageParsed[0];
      switch (type) {
        case "/logout":
          this.command = new LogoutCommand();
        case "/chpw":
          this.command = new ChangePWCommand();
      }

    }
  }

  /**
   * @return the command
   */
  public Command getCommand() {
    return command;
  }

  /**
   * @return content
   */
  public String getContent() {
    return content;
  }

  /**
   * @return where the message from
   */
  public User getFrom() {
    return from;
  }

  /**
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * @return room target
   */
  public Room getTargetRoom() {
    return targetRoom;
  }

  /**
   * @return user target
   */
  public User getTargetUser() {
    return targetUser;
  }

  /**
   * @return time
   */
  public Date getTime() {
    return time;
  }

  /**
   * @return true if is public
   */
  public boolean isPublic() {
    return isPublic;
  }

  /**
   * @param command
   */
  public void setCommand(Command command) {
    this.command = command;
  }

  /**
   * @param content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @param from
   */
  public void setFrom(User from) {
    this.from = from;
  }

  /**
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @param isPublic
   */
  public void setPublic(boolean isPublic) {
    this.isPublic = isPublic;
  }

  /**
   * @param targetRoom
   */
  public void setTargetRoom(Room targetRoom) {
    this.targetRoom = targetRoom;
  }

  /**
   * @param targetUser
   */
  public void setTargetUser(User targetUser) {
    this.targetUser = targetUser;
  }

  /**
   * @param time
   */
  public void setTime(Date time) {
    this.time = time;
  }

}
