package az.unibank.unibanktech.service;

import az.unibank.unibanktech.domain.User;
import az.unibank.unibanktech.dto.request.UserRequest;

public interface UserService {

    User findUserByPin(String pin);

    Long saveUser(UserRequest userRequest);

    User findById(Long id);

}