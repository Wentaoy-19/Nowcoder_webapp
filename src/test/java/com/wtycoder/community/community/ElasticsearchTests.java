package com.wtycoder.community.community;

import co.elastic.clients.elasticsearch._types.SortOptionsBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.wtycoder.community.community.dao.DiscussPostMapper;
import com.wtycoder.community.community.dao.elasticsearch.DiscussPostRepository;
import com.wtycoder.community.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQuery;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.SearchTemplateQuery;
import org.springframework.data.elasticsearch.core.query.SearchTemplateQueryBuilder;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ElasticsearchTests {

    @Autowired
    private DiscussPostMapper discussMapper;

    @Autowired
    private DiscussPostRepository discussRepository;

    @Autowired
    private ElasticsearchTemplate elasticTemplate;

    @Test
    public void testInsert(){
        discussRepository.save(discussMapper.selectDiscussPostById(241));
        discussRepository.save(discussMapper.selectDiscussPostById(242));
        discussRepository.save(discussMapper.selectDiscussPostById(243));
    }

    @Test
    public void testInsertList(){
        discussRepository.saveAll(discussMapper.selectDiscussPosts(101,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(102,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(103,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(111,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(112,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(131,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(132,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(133,0,100));
        discussRepository.saveAll(discussMapper.selectDiscussPosts(134,0,100));
    }

    @Test
    public void testUpdate(){
        DiscussPost post = discussMapper.selectDiscussPostById(231);
        post.setContent("我是新人，使劲灌水");
        discussRepository.save(post);
    }

    @Test
    public void testDelete(){
        // discussRepository.deleteById(231);
        discussRepository.deleteAll();
    }

    @Test
    public void testSearchByRepository(){
//
//        Query searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders)
//                .withSort(SortBuil)

        Page<DiscussPost> page = discussRepository.findBycontentContaining("互联网", PageRequest.of(0,10));

        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getNumber());
        System.out.println(page.getNumber());
        System.out.println(page.getSize());


        for(DiscussPost post: page){
            System.out.println(post);
        }

    }



}
