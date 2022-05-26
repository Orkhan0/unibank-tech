package az.unibank.unibanktech.controller;

import az.unibank.unibanktech.dto.request.UserRequest;
import az.unibank.unibanktech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Long createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

}