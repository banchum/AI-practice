package com.spartahub.aiservice.exam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class AiRunner4 implements CommandLineRunner {

    @Autowired
    private ChatClient.Builder bulider;

    @Override
    public void run(String... args) throws Exception {
        String message = "비가 와서 끈적끈적하다";
        String prompt = "문장을 문석해서 enum POSITiVE, NEUTRAL, NEGATIVE 중에서 선택하고 이유를 reason으로 응답: ";

        ChatClient client = bulider.build();

        SentimentResponse response = client.prompt()
                .user(prompt + message)
                .call()
                .entity(SentimentResponse.class);
        System.out.println(response);
    }
}
