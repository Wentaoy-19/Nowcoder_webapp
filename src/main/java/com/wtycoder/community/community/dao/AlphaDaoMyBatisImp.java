package com.wtycoder.community.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMyBatisImp implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
