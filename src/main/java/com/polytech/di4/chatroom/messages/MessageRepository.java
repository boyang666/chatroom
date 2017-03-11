package com.polytech.di4.chatroom.messages;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Boyang Wang
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

}
