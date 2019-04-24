package com.codegym.service;

import com.codegym.model.Post;
import com.codegym.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        return postRepository.findOne(id);
    }

    @Override
    public void remove(int id) {
        postRepository.delete(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

//    public Iterable<List<Post>> getNewestRecords(){
//        return postRepository.findAllByOrOrderByIdDesc();
//    }
}
