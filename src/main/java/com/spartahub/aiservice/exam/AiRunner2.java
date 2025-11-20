package com.spartahub.aiservice.exam;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class AiRunner2 implements CommandLineRunner {

    @Autowired
    private ChatModel chatModel;

    @Override
    public void run(String... args) throws Exception {
        String message = "{content}에 대한 {adjective} 농담을 해라";
        PromptTemplate template = new PromptTemplate(message);
        template.add("content", "신라면 큰사발");
        template.add("adjective", "미스테리한");

        String str = template.render();

        Message userMessage = new UserMessage(str);
        Message systemMessage = new SystemMessage("너는 길가던 나그네야");

        Prompt prompt = new Prompt(List.of(userMessage , systemMessage), ChatOptions.builder().temperature(0.7).build());
        String response = chatModel.call(prompt).getResult().getOutput().getText();

        System.out.println("[답변 결과] : " + response);
    }
}
