package org.ebuy.controller;

import org.ebuy.dto.AuthUserDto;
import org.ebuy.feign.AuthServiceFeign;
import org.ebuy.feign.UserServiceFeign;
import org.ebuy.mapper.UserMapper;
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
@RequestMapping("/account")
public class UserAccountController {

    private final AuthServiceFeign authServiceFeign;
    private final UserServiceFeign userServiceFeign;
    private final UserMapper userMapper;

    @Autowired
    public UserAccountController(AuthServiceFeign authServiceFeign, UserServiceFeign userServiceFeign, UserMapper userMapper) {
        this.authServiceFeign = authServiceFeign;
        this.userServiceFeign = userServiceFeign;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthUserDto> registerUser(@RequestBody User user) {
        userServiceFeign.createUser(userMapper.userToUserReq(user));
        return authServiceFeign.registerUser(user);
    }

    @PostMapping("/confirm")
    public ResponseEntity<AuthUserDto> confirmUserAccount(@RequestParam("t") String confirmationToken) {
        return authServiceFeign.confirmUserAccount(confirmationToken);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<AuthUserDto> sendPasswordResetMail(@RequestParam String userEmail) {
        return authServiceFeign.sendPasswordResetMail(userEmail);
    }

    @PostMapping("/reset-password-confirm")
    public ResponseEntity<AuthUserDto> resetUserPassword(@RequestParam("token") String token, @RequestBody ResetPasswordRequest passwordDto) {
        return authServiceFeign.resetUserPassword(token, passwordDto);
    }

    @PostMapping("/change-password")
    public ResponseEntity<AuthUserDto> changeUserPassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        return authServiceFeign.changeUserPassword(changePasswordRequest);
    }

}
