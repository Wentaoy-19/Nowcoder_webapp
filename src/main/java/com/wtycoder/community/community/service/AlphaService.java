package com.wtycoder.community.community.service;

import com.wtycoder.community.community.dao.AlphaDao;
import com.wtycoder.community.community.dao.DiscussPostMapper;
import com.wtycoder.community.community.dao.UserMapper;
import com.wtycoder.community.community.entity.DiscussPost;
import com.wtycoder.community.community.entity.User;
import com.wtycoder.community.community.util.CommunityUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public AlphaService() {
        System.out.println("instantiate alphaservice");
    }
    @PostConstruct
    public void init(){
        System.out.println("initialize alphaservice");
    }

    @PreDestroy
    public void destory(){
        System.out.println("destroy alphaservice");
    }

    public String find(){
        return alphaDao.select();
    }



    // REQUIRED: 支持当前事务（外部事物），如果不存在则创建新事务
    // REQUIRES_NEW: 创建一个新事务，并且暂停当前事务（外部事务）
    // NESTED: 如果当前存在（外部事务），则嵌套在该事务执行（独立提交和回滚），否则和REQUIRED一样
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Object savel(){
        // 新增用户
        User user = new User();
        user.setUsername("alpha");
        user.setSalt(CommunityUtil.genereateUUID());
        user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
        user.setEmail("alpha@qq.com");
        user.setHeaderUrl("http://image.nowcoder.com/head/99t.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        // 新增帖子
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle("Hello");
        post.setContent("helloooo");
        post.setCreateTime(new Date());
        discussPostMapper.insertDiscussPost(post);

        Integer.valueOf("abc");
        return "ok";
    }

}
