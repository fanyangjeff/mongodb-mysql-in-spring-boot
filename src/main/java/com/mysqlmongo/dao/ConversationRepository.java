package com.mysqlmongo.dao;

import com.mysqlmongo.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
}
