package com.black.kun.raise.service.impl;

import com.black.kun.raise.service.NoSqlService;
import com.black.kun.raise.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NosqlServiceImpl implements NoSqlService {
    private  static int a = 10;
    @Autowired
    private RedisService redisService;

    /**
     * 测试Ehcache
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "find", key = "#id")
    public int testEhcache(int id) {
        log.info("=====================执行了程序==========================");
        return 0;
    }

    @Override
    @Cacheable(cacheNames = "redisFind", key = "#id")
    public int testRedis(int id) {
        log.info("====================redis==============================");
        return 1;
    }
}

