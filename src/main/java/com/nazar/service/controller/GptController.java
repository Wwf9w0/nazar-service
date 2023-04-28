package com.nazar.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.service.model.request.BotRequest;
import com.nazar.service.model.response.ChatGptResponse;
import com.nazar.service.service.ChatGptService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chat-gpt")
@RequiredArgsConstructor
public class GptController {

    private final ChatGptService chatGptService;

    @PostMapping
    @ApiOperation("answer")
    public ResponseEntity<ChatGptResponse> chat(@RequestBody BotRequest botRequest) {
        return ResponseEntity.ok(chatGptService.askQuestion(botRequest));
    }

}
