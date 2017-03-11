package com.polytech.di4.chatroom.messages;

import java.util.Date;

import com.polytech.di4.chatroom.rooms.Room;
import com.polytech.di4.chatroom.users.User;

/**
 * @author Boyang Wang
 *
 */
public class SysMessage {

  private String content;

  private Date time;

  private boolean isPublic;

  private User targetUser;

  private Room TargetRoom;

  /**
   *
   */
  public SysMessage() {

  }

  /**
   * @return content
   */
  public String getContent() {
    return content;
  }

  /**
   * @return room
   */
  public Room getTargetRoom() {
    return TargetRoom;
  }

  /**
   * @return user
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
   * @return status public
   */
  public boolean isPublic() {
    return isPublic;
  }

  /**
   * @param content
   */
  public void setContent(String content) {
    this.content = content;
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
    TargetRoom = targetRoom;
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
