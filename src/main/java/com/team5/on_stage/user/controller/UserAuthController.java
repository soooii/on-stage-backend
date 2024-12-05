package com.team5.on_stage.user.controller;

import com.team5.on_stage.user.service.ReissueService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/api/auth")
@RequiredArgsConstructor
@RestController
public class UserAuthController {

    private final ReissueService reissueService;

    @PostMapping("/reissue")
    public ResponseEntity<Void> reissue(HttpServletRequest request,
                                        HttpServletResponse response) throws IOException {

        reissueService.reissueRefreshToken(request, response);

        return ResponseEntity.ok().build();
    }
}
