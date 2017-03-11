package com.polytech.di4.chatroom.messages.alarms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Boyang Wang
 *
 */
public interface AlarmRepository extends JpaRepository<Alarm, Long> {

  /**
   * @param id
   * @return alarm
   */
  @Query("select alarm from Alarm alarm where alarm.user.id=:id")
  public List<Alarm> findByUserId(@Param("id") long id);
}
