package com.nazar.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.service.response.NumerologyResponse;
import com.nazar.service.service.NumerologyService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/numerology")
@RequiredArgsConstructor
public class NumerologyContoller {

    private final NumerologyService numerologyService;

    @PostMapping
    @ApiOperation("numerolog analysis")
    public ResponseEntity<NumerologyResponse> numerologyAnalysisName(@RequestParam("name") String name){
        return ResponseEntity.ok(numerologyService.calculateNumerology(name));
    }
    
}
