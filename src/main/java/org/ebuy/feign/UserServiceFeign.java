package org.ebuy.feign;

import org.ebuy.dto.UserDto;
import org.ebuy.model.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@FeignClient(name = "ebuy-user-service")
@RequestMapping("/user")
public interface UserServiceFeign {

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId);

    @GetMapping("/{userEmail}/get-user")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String userEmail);

    @PostMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserRequest userRequest);

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest);

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserRequest userRequest);

    @PostMapping("/delete-users")
    public ResponseEntity<String> deleteAllUsers();

}
