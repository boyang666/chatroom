package com.polytech.di4.chatroom.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.polytech.di4.chatroom.messages.Message;
import com.polytech.di4.chatroom.messages.alarms.Alarm;
import com.polytech.di4.chatroom.rooms.Room;

/**
 * class user, model
 *
 * @author Boyang Wang
 * @version 1.0
 */
@Entity
public class User {

  /** id of user */
  @Id
  @GeneratedValue
  long id;

  /** The user name */
  @Column(unique = true)
  String username;

  /** name */
  String name;

  /** The email */
  @Column(unique = true)
  String email;

  /** The password */
  String encryptedPassword;

  /** enabled status */
  boolean enabled = true;

  /** The role. */
  @Enumerated(EnumType.STRING) // stored as a string
  Role role;

  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "host")
  private List<Room> manageRooms;

  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "targetUser")
  private List<Message> messagesReceive;

  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "from")
  private List<Message> messageSend;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(name = "ban_information", joinColumns = { @JoinColumn(name = "user_id") },
      inverseJoinColumns = { @JoinColumn(name = "room_id") })
  private List<Room> bannedFrom;

  @ManyToOne
  @JoinColumn(columnDefinition = "integer", name = "current_room_id")
  private Room currentRoom;

  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "user")
  private List<Alarm> alarms;

  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "associatedUser")
  private List<Alarm> associatedAlarms;

  /**
   * constructor
   */
  public User() {

  }

  /**
   * constructor
   *
   * @param username
   * @param fullname
   * @param email
   * @param encryptedPassword
   * @param enabled
   * @param role
   * @param loginTime
   */
  public User(String username, String fullname, String email, String encryptedPassword, boolean enabled, Role role) {
    super();
    this.username = username;
    this.name = fullname;
    this.email = email;
    this.encryptedPassword = encryptedPassword;
    this.enabled = enabled;
    this.role = role;
  }

  /**
   * @return alarms
   */
  public List<Alarm> getAlarms() {
    return alarms;
  }

  /**
   * @return alarms
   */
  public List<Alarm> getAssocietedAlarms() {
    return associatedAlarms;
  }

  /**
   * rooms which is banned from
   *
   * @return rooms
   */
  public List<Room> getBannedFrom() {
    return bannedFrom;
  }

  /**
   * @return current room
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * get email
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * get password
   *
   * @return password
   */
  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  /**
   * get name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * get user id
   *
   * @return id of user
   */
  public long getId() {
    return id;
  }

  /**
   * get manage rooms
   *
   * @return rooms
   */
  public List<Room> getManageRooms() {
    return manageRooms;
  }

  /**
   * get sent messages
   *
   * @return messages
   */
  public List<Message> getMessageSend() {
    return messageSend;
  }

  /**
   * get received messages
   *
   * @return messages
   */
  public List<Message> getMessagesReceive() {
    return messagesReceive;
  }

  /**
   * get role
   *
   * @return role
   */
  public Role getRole() {
    return role;
  }

  /**
   * get user name
   *
   * @return user name
   */
  public String getUsername() {
    return username;
  }

  /**
   * get enabled
   *
   * @return enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * @param alarms
   */
  public void setAlarms(List<Alarm> alarms) {
    this.alarms = alarms;
  }

  /**
   * @param associetedAlarms
   */
  public void setAssocietedAlarms(List<Alarm> associetedAlarms) {
    this.associatedAlarms = associetedAlarms;
  }

  /**
   * set rooms which is banned from
   *
   * @param bannedFrom
   *          rooms
   */
  public void setBannedFrom(List<Room> bannedFrom) {
    this.bannedFrom = bannedFrom;
  }

  /**
   * @param currentRoom
   */
  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  /**
   * set email
   *
   * @param email
   *          email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * set enabled
   *
   * @param enabled
   *          enabled
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * set password
   *
   * @param encryptedPassword
   *          password
   */
  public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }

  /**
   * set name
   *
   * @param fullname
   *          name
   */
  public void setName(String fullname) {
    this.name = fullname;
  }

  /**
   * set user id
   *
   * @param id
   *          set user id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * set manage rooms
   *
   * @param manageRooms
   *          rooms
   */
  public void setManageRooms(List<Room> manageRooms) {
    this.manageRooms = manageRooms;
  }

  /**
   * set sent messages
   *
   * @param messageSend
   *          messages
   */
  public void setMessageSend(List<Message> messageSend) {
    this.messageSend = messageSend;
  }

  /**
   * set received messages
   *
   * @param messagesReceive
   */
  public void setMessagesReceive(List<Message> messagesReceive) {
    this.messagesReceive = messagesReceive;
  }

  /**
   * set role
   *
   * @param role
   *          role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * set user name
   *
   * @param username
   *          user name
   */
  public void setUsername(String username) {
    this.username = username;
  }

}
