package com.duongvb.SecuritySystem.controller;

import com.duongvb.SecuritySystem.dto.request.AuthenticationRequest;
import com.duongvb.SecuritySystem.dto.response.ApiResponse;
import com.duongvb.SecuritySystem.dto.response.AuthenticationResponse;
import com.duongvb.SecuritySystem.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    private final RestClient.Builder builder;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        boolean result = authenticationService.authenticate(authenticationRequest);
        log.info("Authentication : " + authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder().result(
                AuthenticationResponse.builder().authenticated(result).build()
        ).build();
    }
}
