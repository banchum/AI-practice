package com.spartahub.aiservice.exam;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private ChatClient.Builder builder;

    @Autowired
    private ChatMemory chatMemory;

    private ChatClient client;

    @PostConstruct
    public void setup(){
        client = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("chat")
    public String chat(@RequestParam("chatId") String chatId, @RequestParam("message") String message) {
        ChatClient client = builder.build();

        return client.prompt()
                .user(message)
                .advisors(s -> s.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .content();
    }
}
