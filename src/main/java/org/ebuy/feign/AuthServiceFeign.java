package org.ebuy.feign;

import org.ebuy.model.ChangePasswordRequest;
import org.ebuy.model.ResetPasswordRequest;
import org.ebuy.dto.UserDto;
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
    public ResponseEntity<UserDto> registerUser(@RequestBody User user);

    @PostMapping("/confirm")
    public ResponseEntity<UserDto> confirmUserAccount(@RequestParam("t") String activationKey);

    @PostMapping("/reset-password")
    public ResponseEntity<UserDto> sendPasswordResetMail(@RequestBody String userEmail);

    @PostMapping("/reset-password-confirm")
    public ResponseEntity<UserDto> resetUserPassword(@RequestParam("token") String token, @RequestBody ResetPasswordRequest passwordDto);

    @PostMapping("/change-password")
    public ResponseEntity<UserDto> changeUserPassword(@RequestBody ChangePasswordRequest changePasswordRequest);

}
