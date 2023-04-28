package com.nazar.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.request.UserRegisterRequest;
import com.nazar.service.model.response.TopNazarsResponse;
import com.nazar.service.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation("Create User")
    public ResponseEntity<HttpStatus> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        userService.createUser(userRegisterRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Returns user list")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    @ApiOperation("Get User By userId")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/top-nazar")
    @ApiOperation("Returns top 10 nazar of user")
    public ResponseEntity<List<TopNazarsResponse>> getTopNazarOfUsers() {
        return ResponseEntity.ok(userService.getTopNazarUsers());
    }

}
