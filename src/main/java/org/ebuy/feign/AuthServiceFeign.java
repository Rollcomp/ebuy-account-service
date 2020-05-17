package org.ebuy.feign;

import org.ebuy.model.ChangePasswordRequest;
import org.ebuy.model.ResetPasswordRequest;
import org.ebuy.dto.AuthUserDto;
import org.ebuy.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@FeignClient(name = "ebuy-oauth-server")
@RequestMapping("/auth")
public interface AuthServiceFeign {

    @PostMapping("/register")
    public ResponseEntity<AuthUserDto> registerUser(@RequestBody User user);

    @PostMapping("/confirm")
    public ResponseEntity<AuthUserDto> confirmUserAccount(@RequestParam("t") String activationKey);

    @PostMapping("/reset-password")
    public ResponseEntity<AuthUserDto> sendPasswordResetMail(@RequestBody String userEmail);

    @PostMapping("/reset-password-confirm")
    public ResponseEntity<AuthUserDto> resetUserPassword(@RequestParam("token") String token, @RequestBody ResetPasswordRequest passwordDto);

    @PostMapping("/change-password")
    public ResponseEntity<AuthUserDto> changeUserPassword(@RequestBody ChangePasswordRequest changePasswordRequest);

}
