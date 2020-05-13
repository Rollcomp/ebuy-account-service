package org.ebuy.userregisterservice.feign;

import org.ebuy.userregisterservice.dto.ChangePasswordDto;
import org.ebuy.userregisterservice.dto.ResetPasswordDto;
import org.ebuy.userregisterservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
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
    public Message<String> registerUser(@RequestBody UserDto userDto);

    @PostMapping(value = "/confirm")
    public Message<String> confirmUserAccount(@RequestParam("t") String confirmationToken);

    @PostMapping("/reset-password")
    public Message<String> sendPasswordResetMail(@RequestBody String userEmail);

    @PostMapping("/reset-password-confirm")
    public Message<String> resetUserPassword(@RequestParam("token") String token, @RequestBody ResetPasswordDto passwordDto);

    @PostMapping("/change-password")
    public Message<String> changeUserPassword(@RequestBody ChangePasswordDto changePasswordDto);

}
