package ru.yandex.practicum.catsgram.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.model.Post;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private final List<Post> posts = new ArrayList<>();

    private final static Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/posts")
    public List<Post> findAll() {
        logger.debug("Текущее количество постов: {}",  posts.size());
        return posts;
    }

    @PostMapping(value = "/post")
    public void create(@RequestBody Post post) {
        logger.debug("Объект: {}", new Gson().toJson(post));
        posts.add(post);
    }
}