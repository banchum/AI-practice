package com.spartahub.aiservice.exam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class AiRunner5 implements CommandLineRunner {

    @Autowired
    private ChatClient.Builder bulider;

    @Override
    public void run(String... args) throws Exception {
        Resource r1 = new ClassPathResource("role.txt");
        Resource r2 = new ClassPathResource("prompt.txt");

        ChatClient client = bulider.build();
        String response = client.prompt()
                .system(s->s.text(r1, StandardCharsets.UTF_8)
                        .param("role", "역전의 용사")
                        .param("tone", "근엄한"))
                .user(s->s.text(r2, StandardCharsets.UTF_8)
                        .param("content","가스라이팅")
                        .param("adjective","지적하는 사람을 지적하는"))
                .call()
                .content();
        System.out.println(response);
    }
}
