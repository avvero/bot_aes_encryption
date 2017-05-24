package com.avvero.bot_aes_encryption.controller;

import com.avvero.bot_aes_encryption.dto.bf.ConversationMessage;
import com.avvero.bot_aes_encryption.service.AesEncryptionService;
import com.avvero.bot_aes_encryption.service.BotFrameworkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fxdev-belyaev-ay
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private BotFrameworkService botFrameworkService;
    @Autowired
    private AesEncryptionService aesEncryptionService;
    @Value("${encryption.key}")
    private String key;
    @Value("${encryption.schema}")
    private String schema;

    @RequestMapping(value = "/endpoint", method = RequestMethod.POST)
    public void endpoint(@RequestBody ConversationMessage message) {
        log.info("ENDPOINT START");
        log.info(message.toString());

        ConversationMessage echo = new ConversationMessage();
        echo.setChannelId(message.getChannelId());
        echo.setConversation(message.getConversation());
        echo.setFrom(message.getRecipient());
        echo.setRecipient(message.getFrom());
        echo.setServiceUrl(message.getServiceUrl());
        echo.setType("message");
        if ("message".equals(message.getType())) {
            echo.setText(aesEncryptionService.encrypt(key, schema, message.getText()));
            botFrameworkService.send(echo);
        } else if ("conversationUpdate".equals(message.getType())) {
            echo.setText("<ss type=\"hi\">(wave)</ss>");
            botFrameworkService.send(echo);
        }
        log.info("ENDPOINT END");
    }
}
