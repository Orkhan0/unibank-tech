package az.unibank.unibanktech.controller;

import az.unibank.unibanktech.dto.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentications")
public class AuthController {

    private final AuthenticationManager authManager;
    private static final String BASIC_KEYWORD = "Basic ";

    @PostMapping
    public String login(@RequestBody AuthRequest authRequest) {

        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(authRequest.getPinCode(),
                authRequest.getPassword());
        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);

        return BASIC_KEYWORD
                .concat(Base64.getEncoder()
                        .encodeToString((authRequest.getPinCode()
                                .concat(":")
                                .concat(authRequest.getPassword()))
                                .getBytes()));
    }

}