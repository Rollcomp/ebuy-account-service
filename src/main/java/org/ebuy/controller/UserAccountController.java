package org.ebuy.controller;

import org.ebuy.dto.UserDto;
import org.ebuy.feign.AuthServiceFeign;
import org.ebuy.model.ChangePasswordRequest;
import org.ebuy.model.ResetPasswordRequest;
import org.ebuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@RestController
@RequestMapping("/user")
public class UserAccountController {

    private final AuthServiceFeign authServiceFeign;

    @Autowired
    public UserAccountController(AuthServiceFeign authServiceFeign) {
        this.authServiceFeign = authServiceFeign;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody User user) {
        return authServiceFeign.registerUser(user);
    }

    @PostMapping("/confirm")
    public ResponseEntity<UserDto> confirmUserAccount(@RequestParam("t") String confirmationToken) {
        return authServiceFeign.confirmUserAccount(confirmationToken);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<UserDto> sendPasswordResetMail(@RequestParam String userEmail) {
        return authServiceFeign.sendPasswordResetMail(userEmail);
    }

    @PostMapping("/reset-password-confirm")
    public ResponseEntity<UserDto> resetUserPassword(@RequestParam("token") String token, @RequestBody ResetPasswordRequest passwordDto) {
        return authServiceFeign.resetUserPassword(token, passwordDto);
    }

    @PostMapping("/change-password")
    public ResponseEntity<UserDto> changeUserPassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        return authServiceFeign.changeUserPassword(changePasswordRequest);
    }

}
