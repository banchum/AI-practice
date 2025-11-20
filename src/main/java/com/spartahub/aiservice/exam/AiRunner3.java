package com.spartahub.aiservice.exam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class AiRunner3 implements CommandLineRunner {

    @Autowired
    private ChatClient.Builder bulider;

    @Override
    public void run(String... args) throws Exception {
        String tpl = "{content}에 대한 {adjective} 농담을 해라";
        ChatClient chatClient = bulider.build();

       String response =  chatClient.prompt()
                .user(s -> s.text(tpl)
                        .param("content","java")
                        .param("adjective","끔찍한"))
                        .system("너는 10년지기 친구야")
                .call()
                .content();

        System.out.println("[결과] : " + response);

    }
}
