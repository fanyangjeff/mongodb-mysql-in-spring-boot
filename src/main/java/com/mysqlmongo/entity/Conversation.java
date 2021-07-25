package com.mysqlmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

/*
 * @author Jeff
 * @date 7/25/21 12:29 AM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
    @Id
    String id;
    String user1;
    String user2;
    List<String> messages;
}
