package me.dio.service;

import me.dio.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    User findById(Long id);

    User create (User userToCreate);

}
