package com.spartahub.aiservice.exam;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class AiRunner1 implements CommandLineRunner {

    @Autowired
    private ChatModel chatModel;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("생성된 객체: "+ chatModel);
        String response = chatModel.call("스티브 잡스의 명언을 세개 알려줘");
        System.out.println("출력 결과: "+response);
        System.out.println("오늘 날짜 물어보기: "+ chatModel.call("오늘 날짜 알려줘 깡통아"));
    }
}
