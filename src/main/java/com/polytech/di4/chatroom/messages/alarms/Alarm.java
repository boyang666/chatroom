package com.polytech.di4.chatroom.messages.alarms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.polytech.di4.chatroom.messages.SysMessage;
import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
@Entity
public class Alarm {

  @Id
  @GeneratedValue
  private long id;

  private String type;

  @Transient
  private SysMessage sysMessage;

  @ManyToOne
  @JoinColumn(columnDefinition = "integer", name = "associatedUser_id")
  private User associatedUser;

  @ManyToOne
  @JoinColumn(columnDefinition = "integer", name = "associatedRoom_id")
  private Room associatedRoom;

  @ManyToOne
  @JoinColumn(columnDefinition = "integer", name = "user_id")
  private User user;

  /**
   *
   */
  public Alarm() {

  }

  /**
   * @return room
   */
  public Room getAssociatedRoom() {
    return associatedRoom;
  }

  /**
   * @return user
   */
  public User getAssociatedUser() {
    return associatedUser;
  }

  /**
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * @return system message
   */
  public SysMessage getSysMessage() {
    return sysMessage;
  }

  /**
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * @return user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param associatedRoom
   */
  public void setAssociatedRoom(Room associatedRoom) {
    this.associatedRoom = associatedRoom;
  }

  /**
   * @param associatedUser
   */
  public void setAssociatedUser(User associatedUser) {
    this.associatedUser = associatedUser;
  }

  /**
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @param sysMessage
   */
  public void setSysMessage(SysMessage sysMessage) {
    this.sysMessage = sysMessage;
  }

  /**
   * @param type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @param user
   */
  public void setUser(User user) {
    this.user = user;
  }

}
