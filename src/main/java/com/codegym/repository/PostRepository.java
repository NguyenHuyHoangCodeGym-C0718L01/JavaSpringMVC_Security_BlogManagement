package com.codegym.repository;

import com.codegym.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

//    @Query("select p from Post group by p.id order by p.id desc")
//    Iterable<List<Post>> findAllByOrOrderByIdDesc();
}
