package com.wtycoder.community.community.util;

public interface CommunityConstant {
    // activation success
    int ACTIVATION_SUCCESS = 0;
    // repeated activation
    int ACTIVATION_REPEAT = 1;
    // activation fail
    int ACTIVATION_FAILURE = 2;

    // Default login expire time
    int DEFAULT_EXPIRE_SECONDS = 3600 * 12;

    // remember me status login expire time
    int REMEMBER_EXPIRE_SECONDS = 3600 * 24 * 100;

    // entity: post
    int ENTITY_TYPE_POST = 1;
    // entity: comment
    int ENTITY_TYPE_COMMENT = 2;

    // entity: user
    int ENTITY_TYPE_USER = 3;

    // topic: comment
    String TOPIC_COMMENT = "comment";

    // topic: like
    String TOPIC_LIKE = "like";

    // topic: follow
    String TOPIC_FOLLOW = "follow";

    // topic: add post
    String TOPIC_PUBLISH = "publish";

    // SYSTEM USER ID
    int SYSTEM_USER_ID = 1;





}
