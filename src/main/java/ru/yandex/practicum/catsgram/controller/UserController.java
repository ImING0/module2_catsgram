package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exciptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exciptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final HashMap<String, User> users = new HashMap();

    @PostMapping
    public User createUser(@RequestBody User user) {
        if (user.getEmail()
                .isEmpty() || user.getEmail()
                .isBlank() || user.getEmail() == null) {
            try {
                throw  new InvalidEmailException("email адрес пуст " + user.getEmail());
            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
            }
        }
        if (users.containsKey(user.getEmail())) try {
            throw new UserAlreadyExistException("Пользователь с таким email уже существует" + user.getEmail());
        } catch (UserAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        users.put(user.getEmail(), user);
        return user;
    }

    @GetMapping
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @PutMapping
    public User updateOrCreateUser(@RequestBody User user) {
        if (user.getEmail()
                .isEmpty() || user.getEmail()
                .isBlank() || user.getEmail() == null) {
            try {
                throw  new InvalidEmailException("email адрес пуст " + user.getEmail());
            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
            }
        }

        users.put(user.getEmail(), user);
        return user;
    }
}
