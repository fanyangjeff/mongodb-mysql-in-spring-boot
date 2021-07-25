package com.mysqlmongo.controller;

import com.mysqlmongo.dao.ConversationRepository;
import com.mysqlmongo.entity.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/*
 * @author Jeff
 * @date 7/25/21 12:36 AM
 */
@RestController
public class ConversationController {
    @Autowired
    private ConversationRepository conversationRepository;

    @PostMapping("/conversation")
    public Conversation createConversation(@RequestBody Conversation conversation) {
        conversation.setId(UUID.randomUUID().toString());
        conversationRepository.save(conversation);
        return conversation;
    }

    @GetMapping("/conversations")
    public List<Conversation> findAll() {
        return conversationRepository.findAll();
    }

}
