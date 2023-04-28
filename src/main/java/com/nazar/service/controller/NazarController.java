package com.nazar.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.service.model.request.NazarRequest;
import com.nazar.service.model.response.AttachNazarResponse;
import com.nazar.service.model.response.NazarCountResponse;
import com.nazar.service.service.NazarService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/nazar")
@RequiredArgsConstructor
public class NazarController {

    private final NazarService nazarService;

    @PostMapping
    @ApiOperation("Nazar Fırlat")
    public ResponseEntity<HttpStatus> addNazar(@RequestBody NazarRequest nazarRequest) {
        nazarService.addNazar(nazarRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("benim nazarlarım ve countları")
    public ResponseEntity<List<NazarCountResponse>> getNazarCountOfUser(@PathVariable Long id) {
        return ResponseEntity.ok(nazarService.getNazarCountOfUser(id));
    }

    @GetMapping("/my/{userId}")
    @ApiOperation("bana nazar atanlar")
    public ResponseEntity<AttachNazarResponse> getNazarUsersForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(nazarService.getNazarUsersForUser(userId));
    }

    @GetMapping("/user/{userId}")
    @ApiOperation("Benim nazar attıklarım")
    public ResponseEntity<AttachNazarResponse> myNazars(@PathVariable Long userId) {
        return ResponseEntity.ok(nazarService.myNazars(userId));
    }

    @PostMapping("/delete")
    @ApiOperation("Delete nazar by nazar point")
    public ResponseEntity<HttpStatus> removeNazarByNazarPoint(@RequestParam("userId") Long userId,
            @RequestParam("nazarId") Long nazarId) {
        nazarService.removeNazarByNazarPoint(userId, nazarId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
