package com.mysqlmongo.controller;

import com.mysqlmongo.dao.ConversationRepository;
import com.mysqlmongo.entity.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * @author Jeff
 * @date 7/25/21 12:36 AM
 */
@RestController
public class ConversationController {
//    @Autowired
//    private ConversationRepository conversationRepository;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ConversationController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/conversation")
    public Conversation createConversation(@RequestBody Conversation conversation) {
        conversation.setId(UUID.randomUUID().toString());
        //conversationRepository.save(conversation);
        mongoTemplate.save(conversation, "conversations");
        return conversation;
    }

    @GetMapping("/conversations")
    public List<Conversation> findAll() {
        return mongoTemplate.findAll(Conversation.class, "conversations");
        //return conversationRepository.findAll();
    }

    @GetMapping("/conversation/{username}")
    public List<Conversation> findConversationByName(@PathVariable("username") String username) {
        Query query = Query.query(Criteria.where("user1").is(username));
        return mongoTemplate.find(query, Conversation.class);


    }

}
