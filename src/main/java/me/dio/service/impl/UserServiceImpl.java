package me.dio.service.impl;

import me.dio.Repository.UserRepository;
import me.dio.User;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    @Override
    public User create(User userToCreate) {
        if (userToCreate.getAccount() == null || userToCreate.getAccount().getNumber() == null) {
            throw new IllegalArgumentException("Account and account number must not be null.");
        }
        return userRepository.save(userToCreate);
    }

}