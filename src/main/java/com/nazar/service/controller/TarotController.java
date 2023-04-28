package com.nazar.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.service.response.TarotResponse;
import com.nazar.service.service.TarotService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tarot")
@RequiredArgsConstructor
public class TarotController {

    private final TarotService tarotService;

    @PostMapping
    @ApiOperation("Random tarot game")
    public ResponseEntity<TarotResponse> gameTarot(@RequestParam("number") int number) {
        return ResponseEntity.ok(tarotService.gameTarot(number));
    }
}
