package com.wordcloud.core.controller;

import com.wordcloud.core.service.RabbitMQSender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class RequestController {

    @Autowired
    DBController dbController;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping("/words/{identifier}")
    public HashMap<String, Integer> getWordCounts(@PathVariable(value = "identifier") String identifier) {
        return dbController.getWordsByIdentifier(identifier).getBody();
    }

    @PostMapping("/upload")
    public String receiveFile(@RequestParam("file") MultipartFile file) throws IOException {
        String identifier = UUID.randomUUID().toString();
        byte[] bytes = file.getBytes();
        String messageText = identifier + " " + new String(bytes);
        byte[] messageBytes = messageText.getBytes();
        Message message = MessageBuilder.withBody(messageBytes).build();
        rabbitMQSender.sendMessage(message);
        return "Upload identifier: " + identifier;
    }
}
