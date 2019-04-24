package com.codegym.service;

import com.codegym.model.Post;

public interface PostService {
    Iterable<Post> findAll();

    Post findById(int id);

    void remove(int id);

    void save(Post post);
}
