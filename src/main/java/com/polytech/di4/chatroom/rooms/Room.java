package com.polytech.di4.chatroom.rooms;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.polytech.di4.chatroom.messages.Message;
import com.polytech.di4.chatroom.messages.alarms.Alarm;
import com.polytech.di4.chatroom.users.User;

/**
 * The chat room
 *
 * @author Boyang Wang
 * @version 1.0
 */
@Entity
public class Room {

  @Id
  @GeneratedValue
  private long id;

  /** room name */
  private String name;

  /** number of users */
  private int numUsers = 1;

  /** password of the room */
  private String password;

  /** if the room has password */
  private boolean passwordEnabled;

  /** if the room is closed */
  private boolean closed = false;

  /** if the room ban some users */
  private boolean banEnabled = false;

  /** user list banned */
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(name = "ban_information", joinColumns = { @JoinColumn(name = "room_id") },
      inverseJoinColumns = { @JoinColumn(name = "user_id") })
  private List<User> banList;

  /** host of the room */
  @ManyToOne
  @JoinColumn(name = "host_id")
  private User host;

  /** public messages */
  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "targetRoom")
  private List<Message> publicMessages;

  /** current users */
  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "currentRoom")
  private List<User> currentUsers;

  @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "associatedRoom")
  private List<Alarm> associatedAlarms;

  /**
   * constructor
   */
  public Room() {

  }

  /**
   * constructor
   *
   * @param name
   * @param numUsers
   * @param password
   * @param passwordEnabled
   * @param closed
   * @param banEnabled
   * @param banList
   * @param host
   */
  public Room(String name, int numUsers, String password, boolean passwordEnabled, boolean closed, boolean banEnabled,
      List<User> banList, User host) {
    super();
    this.name = name;
    this.numUsers = numUsers;
    this.password = password;
    this.passwordEnabled = passwordEnabled;
    this.closed = closed;
    this.banEnabled = banEnabled;
    this.banList = banList;
    this.host = host;
  }

  /**
   * @return alarms
   */
  public List<Alarm> getAssocietedAlarms() {
    return associatedAlarms;
  }

  /**
   * @return ban list
   */
  public List<User> getBanList() {
    return banList;
  }

  /**
   * @return alarms
   */
  public List<User> getCurrentUsers() {
    return currentUsers;
  }

  /**
   * @return host
   */
  public User getHost() {
    return host;
  }

  /**
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * @return number of users
   */
  public int getNumUsers() {
    return numUsers;
  }

  /**
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return public messages
   */
  public List<Message> getPublicMessages() {
    return publicMessages;
  }

  /**
   * @return true if some users are banned
   */
  public boolean isBanEnabled() {
    return banEnabled;
  }

  /**
   * @return true if the room is closed
   */
  public boolean isClosed() {
    return closed;
  }

  /**
   * @return true if have password
   */
  public boolean isPasswordEnabled() {
    return passwordEnabled;
  }

  /**
   * @param associatedAlarms
   */
  public void setAssocietedAlarms(List<Alarm> associatedAlarms) {
    this.associatedAlarms = associatedAlarms;
  }

  /**
   * @param banEnabled
   */
  public void setBanEnabled(boolean banEnabled) {
    this.banEnabled = banEnabled;
  }

  /**
   * @param banList
   */
  public void setBanList(List<User> banList) {
    this.banList = banList;
  }

  /**
   * @param closed
   */
  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  /**
   * @param currentUsers
   */
  public void setCurrentUsers(List<User> currentUsers) {
    this.currentUsers = currentUsers;
  }

  /**
   * @param host
   */
  public void setHost(User host) {
    this.host = host;
  }

  /**
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param numUsers
   */
  public void setNumUsers(int numUsers) {
    this.numUsers = numUsers;
  }

  /**
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @param passwordEnabled
   */
  public void setPasswordEnabled(boolean passwordEnabled) {
    this.passwordEnabled = passwordEnabled;
  }

  /**
   * @param publicMessages
   */
  public void setPublicMessages(List<Message> publicMessages) {
    this.publicMessages = publicMessages;
  }

}
