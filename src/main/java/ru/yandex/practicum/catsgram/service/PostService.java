package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exciptions.PostNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts;
    }

    public Post findPostById(int id) {
        return posts.stream()
                .filter(post -> post.getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() ->  new PostNotFoundException(String.format("Пост с id %d не найден", id)));
    }

    public Post create(Post post) {
        posts.add(post);
        return post;
    }
}