package com.black.kun.raise.service;


public interface NoSqlService {

    /**
     * 测试Ehcache
     * @param id
     * @return
     */
     int testEhcache(int id);

    /**
     * 测试redis
     * @param id
     * @return
     */
    int testRedis(int id);

}
