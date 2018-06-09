package cn.huimin100.cms.config.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 缓存管理器 默认是使用redis
 * 在 Cacheable 注解中 cacheNames 不以redis开头
 * 则都是ehCacheManager
 */
public class AppCacheManage implements CacheManager {
    private CacheManager redisCacheManager;
    private CacheManager ehCacheManager;
    private final static String REDIS_PREFIX = "redis";
    @Override
    public Cache getCache(String s) {
        if(s.startsWith(REDIS_PREFIX)){
            return redisCacheManager.getCache(s);
        }else{
            return ehCacheManager.getCache(s);
        }
    }

    @Override
    public Collection<String> getCacheNames() {
        Collection<String> cacheNames = new ArrayList<String>();
        if(redisCacheManager != null){
            cacheNames.addAll(redisCacheManager.getCacheNames());
        }
        if(ehCacheManager != null){
            cacheNames.addAll(ehCacheManager.getCacheNames());
        }
        return cacheNames;
    }

    public CacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public void setRedisCacheManager(CacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    public CacheManager getEhCacheManager() {
        return ehCacheManager;
    }

    public void setEhCacheManager(CacheManager ehCacheManager) {
        this.ehCacheManager = ehCacheManager;
    }
}
