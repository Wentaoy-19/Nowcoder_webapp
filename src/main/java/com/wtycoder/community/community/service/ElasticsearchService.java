package com.wtycoder.community.community.service;

import com.wtycoder.community.community.dao.elasticsearch.DiscussPostRepository;
import com.wtycoder.community.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchService {

    @Autowired
    private DiscussPostRepository discussRepository;

    @Autowired
    private ElasticsearchTemplate elasticTemplate;

    public void saveDiscussPost(DiscussPost post){
        discussRepository.save(post);
    }

    public void deleteDiscussPost(int id){
        discussRepository.deleteById(id);
    }

    public Page<DiscussPost> searchDiscussPost(String keyword, int current, int limit){
        Page<DiscussPost> page = discussRepository.findBycontentContaining(keyword, PageRequest.of(current,limit));
        return page;
    }

}
