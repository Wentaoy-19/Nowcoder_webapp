package com.wtycoder.community.community.dao.elasticsearch;

import com.wtycoder.community.community.entity.DiscussPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {


    Page<DiscussPost> findBycontentContaining(String content, Pageable pageable);


}
