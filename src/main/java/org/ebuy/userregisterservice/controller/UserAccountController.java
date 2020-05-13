package org.ebuy.userregisterservice.controller;

import com.netflix.discovery.converters.Auto;
import org.ebuy.userregisterservice.dto.ChangePasswordDto;
import org.ebuy.userregisterservice.dto.ResetPasswordDto;
import org.ebuy.userregisterservice.dto.UserDto;
import org.ebuy.userregisterservice.feign.AuthServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@RestController
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    private AuthServiceFeign authServiceFeign;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        return (ResponseEntity<?>) authServiceFeign.registerUser(userDto);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmUserAccount(@RequestParam("t") String confirmationToken) {
        return (ResponseEntity<?>) authServiceFeign.confirmUserAccount(confirmationToken);
    }

    @PostMapping("/reset-password")
    public Message<String> sendPasswordResetMail(@RequestParam String userEmail)  {
        return authServiceFeign.sendPasswordResetMail(userEmail);
    }

    @PostMapping("/reset-password-confirm")
    public Message<String> resetUserPassword(@RequestParam("token") String token, @RequestBody ResetPasswordDto passwordDto) {
        return authServiceFeign.resetUserPassword(token, passwordDto);
    }

    @PostMapping("/change-password")
    public Message<String> changeUserPassword(@RequestBody ChangePasswordDto changePasswordDto) {
        return authServiceFeign.changeUserPassword(changePasswordDto);
    }

}
